package org.example.Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,6,1,8,3,8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] array){
        int length = array.length - 1;
        for(int i = 0; i < length; i++ ){
          for(int j = 0; j < length - i; j++){
            if(array[j] > array[j+1]){
                int tmp = array[j];
                array[j] = array[j+1];
                array[j+1] = tmp;
            }
          }
      }
    }
}
