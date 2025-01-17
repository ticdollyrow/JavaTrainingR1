package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String name, String phone){
        ArrayList<String> phones;
        phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public ArrayList<String> get(String name){
        ArrayList<String> phones = phoneBook.get(name);

        return phones;
    }

    public void print(){
        System.out.println(phoneBook);
    }
}
