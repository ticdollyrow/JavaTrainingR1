package org.example.InnerClass;

// Возвращение экземпляра анонимного внутреннего класса.
public class Parcel7 {
    public Contents contents(){
        return new Contents(){
            private int i = 11;
            public int value(){ return i;}
        };
    }

    public static void main(String[] args) {
        Parcel7 parcel7 = new Parcel7();
        Contents contents = parcel7.contents();
    }
}
