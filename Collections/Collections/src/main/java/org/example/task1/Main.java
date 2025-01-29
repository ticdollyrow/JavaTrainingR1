package org.example.task1;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Melon[] melons = new Melon[] { new Melon("type1", 4),
                                       new Melon("type1", 3),
                                       new Melon("type2", 2) };

        Arrays.sort(melons, new Comparator<Melon>() {
            @Override
            public int compare(Melon o1, Melon o2) {
                if(o1.getType().equals(o2.getType())){
                    return o1.getWeight() - o2.getWeight();
                }else{
                    return o1.getType().compareTo(o2.getType());
                }
            }
        });

        System.out.println(Arrays.toString(melons));

        Arrays.sort(melons, ((o1, o2) ->{
            int result;
            if(o2.getWeight() == o1.getWeight() ){
                result = o1.getType().compareTo(o2.getType());
            }else{
                result = o2.getWeight() - o1.getWeight();
            }
            return result;
        } ));

        System.out.println(Arrays.toString(melons));

        System.out.println("BubbleSort");
        Comparator<Melon> byType = Comparator.comparing(Melon::getType);
        bubleSortWithComparator(melons, byType);
        System.out.println(Arrays.toString(melons));


        Comparator<Melon> comparator = new MelonComparator();
        bubleSortWithComparator(melons, comparator);
        System.out.println(Arrays.toString(melons));

        Comparator<Melon> inserionComparator = Comparator.comparing(Melon::getType).thenComparing(Melon::getWeight);
        insertionSort(melons, inserionComparator);
        System.out.println(Arrays.toString(melons));

    }

    public static <T>  void bubleSortWithComparator(T[] arr, Comparator<? super T> c){
        int length = arr.length - 1;

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length - i; j++){
                if(c.compare(arr[j],arr[j+1]) > 0){
                    T tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }


    public static <T>  void insertionSort(T[] arr, Comparator<? super T> c){
        int length = arr.length;

        for(int i = 1; i < length; i++){
            T keyValue = arr[i];
            int j = i -1;
            while (j >= 0 && c.compare(keyValue, arr[j]) < 0){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = keyValue;
        }
    }

}
