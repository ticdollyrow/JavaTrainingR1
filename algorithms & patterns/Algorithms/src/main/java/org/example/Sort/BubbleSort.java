package org.example.Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,6,1,8,3,8};
//        bubbleSort(arr);
        bubleSortOptimized(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] array){
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

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

    public static void bubleSortOptimized(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int n = arr.length;
        while (n != 0) {
            int swap = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;

                    swap = i;
                }
            }
            n = swap;
        }
    }



}
