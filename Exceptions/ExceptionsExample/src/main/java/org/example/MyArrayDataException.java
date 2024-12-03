package org.example;

public class MyArrayDataException extends Exception{
    private final static String ERROR_MESSAGE = "Ошибка в ячейке: строка %d, столбец %d";

    public MyArrayDataException(Throwable e,  int i, int j){
        super(String.format(ERROR_MESSAGE, i , j), e);
    }
}
