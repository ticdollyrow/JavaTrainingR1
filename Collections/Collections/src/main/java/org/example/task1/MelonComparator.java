package org.example.task1;

import java.util.Comparator;

public class MelonComparator implements Comparator<Melon> {
    @Override
    public int compare(Melon o1, Melon o2) {
        return o1.getWeight() - o2.getWeight();
    }
}
