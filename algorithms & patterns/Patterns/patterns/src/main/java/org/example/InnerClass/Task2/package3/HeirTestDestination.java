package org.example.InnerClass.Task2.package3;

import org.example.InnerClass.Task2.package1.Destination;
import org.example.InnerClass.Task2.package2.TestDestination;

public class HeirTestDestination extends TestDestination {
    public static void main(String[] args) {
        new HeirTestDestination().print();
    }

    public void print(){
        Destination destination = getDestination();
        System.out.println(destination.readLabel());

    }

    private Destination getDestination(){
        return new innerDestination();
    }
}
