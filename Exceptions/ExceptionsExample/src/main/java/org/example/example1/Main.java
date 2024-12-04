package org.example.example1;

//Написать метод, который при работе бросил бы StackOverflowError
public class Main {
    public static void main(String[] args) {
        recursiveMeth(1);
    }

    public static void recursiveMeth(int i){
        recursiveMeth(i+1);
    }
}
