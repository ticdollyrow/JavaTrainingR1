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
    }
}
