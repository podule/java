package lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        MyArrayList<Integer> arr = new MyArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arr.add(random.nextInt(100));
        }
        long startTime = System.currentTimeMillis();
        arr.selectionSort();
        System.out.println("Сортировка выбором: " + (System.currentTimeMillis() - startTime));

        MyArrayList<Integer> arr2 = new MyArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arr2.add(random.nextInt(100));
        }
        startTime = System.currentTimeMillis();
        arr2.insertionSort();
        System.out.println("Сортировка вставкой: " + (System.currentTimeMillis() - startTime));

        MyArrayList<Integer> arr3 = new MyArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arr3.add(random.nextInt(100));
        }
        startTime = System.currentTimeMillis();
        arr3.bubbleSort();
        System.out.println("Сортировка пузырьковая: " + (System.currentTimeMillis() - startTime));

    }
}
