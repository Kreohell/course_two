package ru.geekbrains.lessons.homework_1.lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Phonebook extends ArrayList<Person> {

    static HashMap<String, String> phoneBook = new HashMap<>();
    static ArrayList<String> list = new ArrayList<>();
    private static Person person;

    public static HashMap<String, String> addPerson(Person person){
        String[] arr = {person.getEmail(), person.getNumber()};
        phoneBook.put(person.getName(), Arrays.toString(arr));
        return phoneBook;
    }

    public static ArrayList<String> findNumber(String name){
        if (name.equals(phoneBook.get(name))) {
            list.add(phoneBook.get(person.getNumber()));
        }
        return list;
    }


}
