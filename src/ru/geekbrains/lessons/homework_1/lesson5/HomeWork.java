package ru.geekbrains.lessons.homework_1.lesson5;


import java.util.Arrays;

public class HomeWork{

    static final int size = 10000000;
    static final int h = size / 2;


    public static float[] method1(){
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
        return arr;
    }

    public static float[] method2() {
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        MyThread threadOne = new MyThread(arr1, 0);
        MyThread threadTwo = new MyThread(arr2, h);
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - a);
        return arr;
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println(Arrays.equals(method1(), method2()));
        //  System.out.println(Arrays.toString(method1()));
        //  System.out.println(Arrays.toString(method2()));
    }
}
