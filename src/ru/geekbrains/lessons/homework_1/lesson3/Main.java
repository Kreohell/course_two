package ru.geekbrains.lessons.homework_1.lesson3;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Person();
        person1.setName("Ershov");
        person1.setNumber("111111");
        person1.setEmail("111@sad.sa");

        System.out.println(Phonebook.addPerson(person1));

    }
}
