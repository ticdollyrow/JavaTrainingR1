package org.example.InnerClass;

import org.example.InnerClass.Task2.package1.Destination;
//Класс PDestination является частью destination(), а не частью Parcel5. Следовательно,
//к PDestination невозможно обратиться за пределами destination().
public class Parcel5 {
    public Destination destination(String s){
        class PDestination implements Destination{
            private String label;
            private PDestination(String whereTo){
                label = whereTo;
            }
            public String readLabel(){
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        final Destination terra = parcel5.destination("Terra");
    }
}
