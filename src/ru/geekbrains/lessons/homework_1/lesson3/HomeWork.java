package ru.geekbrains.lessons.homework_1.lesson3;

import java.util.*;

public class HomeWork {

    static String text = "Mama take this badge off of me\n" +
            "I can not use it anymore\n" +
            "It is getting dark too dark to see\n" +
            "I feel like I am knocking on Heaven's door\n" +
            "Knock knock knocking on Heaven's door\n" +
            "Knock knock knocking on Heaven's door\n" +
            "Knock knock knocking on Heaven's door\n" +
            "Knock knock knocking on Heaven's door\n" +
            "Mama put my gun to the ground\n" +
            "I can not shoot them anymore\n" +
            "There is a long black cloud coming down\n" +
            "I feel like I am knocking on Heaven's door\n";

    static ArrayList<String> arrayList = new ArrayList<>();
    static HashSet<String> hashList = new HashSet<>();
    static HashMap<String, Integer> hashMap = new LinkedHashMap<>();


    public static String[] changeStringToArray(String string){
        String array = string.toLowerCase().replace("\n", " ");
        return array.split(" ");
    }

    public static ArrayList<String> massiveIntoArrayList(String[] string){
        Collections.addAll(arrayList, string);
        return arrayList;
    }

    public static HashSet<String> massiveIntoHashset(String[] string){
        Collections.addAll(hashList, string);
        return hashList;
    }

    public static HashMap<String, Integer> massiveIntoHashmap(String[] string){
        for (int i = 0; i < string.length; i++) {
            Integer frequency = hashMap.get(string[i]);
            hashMap.put(string[i], frequency == null ? 1 : frequency + 1);
        }
        return hashMap;
    }

    public static void main(String[] args) {
        System.out.println(massiveIntoArrayList(changeStringToArray(text)));
        System.out.println("Общее количество элементов в тексте: " + arrayList.size());
        System.out.println(massiveIntoHashset(changeStringToArray(text)));
        System.out.println("Уникальных элементов в тексте: " + hashList.size());
        massiveIntoHashmap(changeStringToArray(text));
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println("Слово " + "'" + entry.getKey() + "'" + " встречается " + entry.getValue() + " раз(а).");
        }
        System.out.println(hashMap.get("knock"));
    }

}
