/*
   Samantha Oxley
   11/05/07
   QuickSort - uses partitioning and recoursion to sort integer values of an array 
*/

import java.util.*;

public class QuickSort{
   int array[];
   int size;
   /*
      constructor
      @param int array - array to be sorted
   */
   public QuickSort(int[] anArray){
      array = new int[anArray.length];
      array = anArray;
   }
   /*
      sort - recoursively calls itself using partition 
      @param int - first value to be operated 
      @param int - last value to be operated
   */
   public void sort(int from, int to){
      // MUST HAVE AN END CASE -- if from is greater than or equal to 'to' then the sort has completed
      if(from >= to) return;
      int p = partition(from, to);
      sort(from, p);
      sort(p+1, to);
   }
   /*
      partition - compares value at last pivot
      @return int - current pivot point
      @param int - first value to be switched
      @param int - second value to be switched
   */
   public int partition(int from, int to){
      // comparison point
      int pivot = array[from]; 
      int i = from - 1;
      int j = to + 1;
      while(i < j){
         i++;
         while(array[i] < pivot) i++;
         j--;
         while(array[j] > pivot) j--;
         if(i < j){
            swap(i, j);
         }
      }
      return j;
   }
   /*
      Swap - switches two values in array
         no return
      @param int - first value to be switched
      @param int - second value to be switched
   */
   public void swap(int i, int j){
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }
   public void print(){
      for(int i=0; i < array.length; i++){
         System.out.println(array[i]);
      }
   }
}