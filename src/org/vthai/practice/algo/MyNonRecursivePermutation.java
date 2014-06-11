package org.vthai.practice.algo;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MyNonRecursivePermutation {

   private LinkedList<int[]> queue = new LinkedList<>();
   
   private static final int[] DUMMYS_SIGNAL = new int[0];

   private void init(int[] array) {
      queue.clear();
      for (int i = 0; i < array.length; i++) {
         int[] initArray = new int[array.length];
         initArray[0] = array[i];
         queue.add(initArray);
      }
      queue.add(DUMMYS_SIGNAL);
   }

   public void permutate(int[] array) {
      init(array);
      Set<Integer> pickedRecord = new HashSet<>();
      
      int availability = 1;
      while (availability != array.length) {
         int[] oldArray = queue.remove();
         if(oldArray == DUMMYS_SIGNAL) {
            availability++;
            queue.addLast(DUMMYS_SIGNAL);
         } else {
            pickedRecord.clear();
            for (int i = availability; i < array.length; i++) {
               int[] newArray = new int[array.length];
   
               copyArray(newArray, oldArray, pickedRecord);
               pick(newArray, array, pickedRecord, availability);
               queue.add(newArray);
            }
         }
      }
      queue.removeLast();
   }
   
   private void copyArray(int[] newArray, int[] oldArray, Set<Integer> pickedRecord) {
      for(int i = 0; i < oldArray.length; i++) {
         newArray[i] = oldArray[i];
         pickedRecord.add(oldArray[i]);
      }
   }

   private void pick(int[] newArray, int[] array, Set<Integer> pickedRecord, int currentIndex) {
      for (int number : array) {
         if (!pickedRecord.contains(number)) {
            newArray[currentIndex] = number;
            pickedRecord.add(number);
            return;
         }
      }
   }

   public static void main(String[] args) {
      MyNonRecursivePermutation permutation = new MyNonRecursivePermutation();
      int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
      long start = System.currentTimeMillis();
      permutation.permutate(array);
      long end = System.currentTimeMillis();
      long total = end - start;
      permutation.printArray();
      System.out.println("It took " + total);
   }

   public void printArray() {
      int queueSize = queue.size();
      while(!queue.isEmpty()) {
         int[] array = queue.pop();
         for (int number : array) {
            System.out.print(number + ",");
         }
         System.out.println();
      }
      System.out.println("There are " + queueSize + " permutation(s)");
   }
}
