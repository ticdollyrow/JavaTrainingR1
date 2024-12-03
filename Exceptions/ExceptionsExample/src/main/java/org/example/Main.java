package org.example;

//1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
//подаче массива другого размера необходимо бросить исключение MyArraySizeException.

//2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
//просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
//ячейке лежит символ или текст вместо числа), должно быть брошено исключение
//MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

//3 В методе main() вызвать полученный метод, обработать возможные исключения
//MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов,
// при условии, что подали на вход корректный массив).


public class Main {
    public static void main(String[] args) {

        String[][] array = {{"2", "5"},
                            {"6", "6"}};

        String[][] array1 = {{"2", "5", "34", "4"},
                             {"6", "6", "3", "32"},
                            {"4", "34", "23", "12"},
                            {"0", "3", "2", "1q"}};

        try {
            System.out.println(sumElements(array1));
        }catch (MyArraySizeException | MyArrayDataException e ){
            System.out.println(e.getMessage());
        }
    }

    public static int sumElements(String[][]array) throws MyArraySizeException, MyArrayDataException {
        int length = 4;
        int sum = 0, num;
        if(array.length != length) throw new MyArraySizeException();
        for(int i = 0; i < array.length; i++){
            if(array[i].length != length) throw new MyArraySizeException();
            for (int j = 0; j < array[i].length; j++){
                try {
                    num = Integer.parseInt(array[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(e, i, j);
                }
                sum += num;
            }
        }
        return sum;
    }
}