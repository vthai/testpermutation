package org.vthai.practice.algo;

import java.util.ArrayList;
import java.util.List;

public class HeapPermutation {
   private List<int[]> list = new ArrayList<>();
   
   public void permutate(int n, int[] array) {
      if (n == 0) {
         copyArray(array);
      } else {
         for (int i = 0; i < n; i++) {
            permutate(n - 1, array);
            int index = (n % 2 == 0) ? i : 0;
            swap(index, n - 1, array);
         }
      }
   }

   private void swap(int index1, int index2, int[] array) {
      int temp = array[index1];
      array[index1] = array[index2];
      array[index2] = temp;
   }
   
   public void copyArray(int[] array) {
      int[] temp = new int[array.length];
      System.arraycopy(array, 0, temp, 0, array.length);
      list.add(temp);
   }
   
   public void printArray() {
      for (int[] array : list) {
         for(int number : array) {
            System.out.print(number + ",");
         }
         System.out.println();
      }
   }
   
   public int count() {
      return list.size();
   }

   public static void main(String[] args) {
      HeapPermutation permutation = new HeapPermutation();
      int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
      long start = System.currentTimeMillis();
      permutation.permutate(array.length, array);
      
      long end = System.currentTimeMillis();
      long total = end - start;
      
      permutation.printArray();
      
      System.out.println("There are " + permutation.count() + " permuation(s)");
      System.out.println("It took " + total);
   }
}
