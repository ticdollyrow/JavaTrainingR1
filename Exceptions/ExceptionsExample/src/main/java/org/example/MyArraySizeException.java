package org.example;

public class MyArraySizeException extends Exception{
    final static private String ERROR_MESSAGE = "Подан массив некорректного размера";

   public MyArraySizeException(){
       super(ERROR_MESSAGE);
    }
}
