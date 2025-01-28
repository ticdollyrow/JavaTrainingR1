package org.example.InnerClass.Task3;

import org.example.InnerClass.Task2.package1.Destination;

public class Parcel9 {
    // Для использования в анонимном внутреннем классе
    // аргумент должен быть объявлен как final.
    public Destination destination(final String dest){
        return new Destination() {
            private String label = dest;
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Destination destination = parcel9.destination("Tritia");
        System.out.println(destination.readLabel());
    }
}
