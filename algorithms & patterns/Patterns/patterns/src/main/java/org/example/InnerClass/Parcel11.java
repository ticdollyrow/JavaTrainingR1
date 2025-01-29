package org.example.InnerClass;

import org.example.InnerClass.Task2.package1.Destination;

public class Parcel11 {
    private static class ParcelContents implements Contents{
        private int i = 11;
        public int value(){return  i;}
    }

    protected static class ParcelDestination implements Destination{
        private String label;
        private ParcelDestination(String whereTo){
            label = whereTo;
        }
        public String readLabel(){
            return label;
        }
        //Вложенные классы могут содержать другие статические элементы:
        public static void f(){}
        static int x = 10;
        static class AnotherLevel{
            public static void f(){}
            static int x = 10;
        }
    }

    public static Destination destination(String s){
        return new ParcelDestination(s);
    }

    public static Contents contents(){
        return new ParcelContents();
    }


    public static void main(String[] args) {
        Contents contents  = contents();
        Destination destination = destination("Place");
    }
}
