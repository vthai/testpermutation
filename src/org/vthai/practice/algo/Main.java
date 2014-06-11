package org.vthai.practice.algo;


public class Main {
   public static void main(String[] args) {
      BackTracking backTracking = new BackTracking();
      HeapPermutation heapPermutation = new HeapPermutation();
      MyNonRecursivePermutation myNonRecursivePermutation = new MyNonRecursivePermutation();
      
      int size = 8;
      int[] array = new int[size];
      
      for(int i= 0; i < size; i++) {
         array[i] = i+1;
      }
      
      long backTrackStart = System.currentTimeMillis();
      backTracking.permutate(size, array);
      long backTrackEnd = System.currentTimeMillis();
      
      long heapPermutationStart = System.currentTimeMillis();
      heapPermutation.permutate(size, array);
      long heapPermutationEnd = System.currentTimeMillis();
      
      long myNonRecursiveStart = System.currentTimeMillis();
      myNonRecursivePermutation.permutate(array);
      long myNonRecursiveEnd = System.currentTimeMillis();
      
      System.out.println("Backtrack took " + (backTrackEnd - backTrackStart));
      System.out.println("Heap Permutation took " + (heapPermutationEnd - heapPermutationStart));
      System.out.println("My non recursive took " + (myNonRecursiveEnd - myNonRecursiveStart));
   }
}
