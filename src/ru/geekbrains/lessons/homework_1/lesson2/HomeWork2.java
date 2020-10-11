package ru.geekbrains.lessons.homework_1.lesson2;


import java.util.Arrays;

class ArraySizeException extends Exception{
   public ArraySizeException() {
    }
}

public class HomeWork2 {
    static String text = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    static int ARRAY_SIZE = 4;

    public static String[][] changeStringToArray(String string) throws ArraySizeException{
        String[] arrayWithoutN = string.split("\n");
        if(arrayWithoutN.length != ARRAY_SIZE) throw new ArraySizeException();
        String[][] arrayWithoutSpace = new String[arrayWithoutN.length][];
        for (int i = 0; i < arrayWithoutN.length; i++) {
            arrayWithoutSpace[i] = arrayWithoutN[i].split(" ");
            if(arrayWithoutSpace[i].length != ARRAY_SIZE) throw new ArraySizeException();
        }
        return arrayWithoutSpace;
    }

    public static int someArithmeticInArray(String[][] array) throws NumberFormatException{
        int summOfNumbersOfArray = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                summOfNumbersOfArray += Integer.parseInt(array[i][j]);
            }
        }
        return (summOfNumbersOfArray / 2);
    }

    public static void main(String[] args) {
        try {
            System.out.println(Arrays.deepToString(changeStringToArray(text)));
        } catch (ArraySizeException exception) {
            exception.printStackTrace();
            System.out.println("Incorrect size, right size is " + ARRAY_SIZE);
        }
        try {
        System.out.println(someArithmeticInArray(changeStringToArray(text)));
             } catch (NumberFormatException | ArraySizeException exception) {
        System.out.println("Illegal argument.");
        }
        System.out.println("Do something things.");
    }
}
