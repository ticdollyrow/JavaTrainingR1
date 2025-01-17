package org.example;

//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//Посчитать сколько раз встречается каждое слово.
//2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
//В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get()
//искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
//(в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String string = "Before European settlement, the Chicago " +
                "area was inhabited by indigenous people, " +
                "including the Potawatomi and Illinois " +
                "tribes. In the late 19th and early 20th centuries, " +
                "Chicago became a magnet for immigrants from " +
                "around the world.";
        String[] array = string.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
//        for( int i = 0; i < array.length; i++){
//            if(map.containsKey(array[i])){
//                map.put(array[i], map.get(array[i]) + 1);
//            }else{
//                map.put(array[i],1);
//            }
//        }

//        for(int i = 0; i < array.length; i++){
//           Integer val = map.getOrDefault(array[i], 0);
//           map.put(array[i], val+1);
//        }
//        System.out.println(map);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Brown", "9854545");
        phoneBook.add("Silver", "65656");
        phoneBook.add("Brown", "757757");
        phoneBook.print();
    }
}