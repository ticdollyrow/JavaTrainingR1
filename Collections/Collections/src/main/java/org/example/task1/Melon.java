package org.example.task1;

import javax.xml.namespace.QName;
import java.util.Comparator;

public class Melon {
    private final String type;
    private final int weight;

    public Melon(String type, int weight){
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return type + " " + weight;
    }


}


