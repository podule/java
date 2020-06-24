package lessons1;

import lessons1.Suitabilitys.SuitabilityForApples;
import lessons1.Suitabilitys.SuitabilityForOranges;
import lessons1.boxs.Box;
import lessons1.fruits.Apple;
import lessons1.fruits.Orange;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // первая задача
        Object[] list = new Object[2];

        list[0] = new Object();
        list[1] = new Object();

        Task1<Object> task1 = new Task1<>();

        task1.printArray(list);
        Object[] listRevert = task1.revertArrayWithToElement(list);
        task1.printArray(listRevert);

        // вторая задача
        Task2<Object> task2 = new Task2<>();

        ArrayList<Object> objectArrayList = task2.conversionArrayToArrayList(listRevert);
        task2.printArrayList(objectArrayList);

        // третья задача
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Box<Apple> appleBox = new Box<>(new SuitabilityForApples());
        appleBox.addFruit(apple1);
        appleBox.addFruit(apple2);
        appleBox.addFruit(apple3);

        System.out.println("Вес коробки с яблоками (3) " + appleBox.getWeight());

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Orange> orangeBox = new Box<>(new SuitabilityForOranges());
        orangeBox.addFruit(orange1);
        orangeBox.addFruit(orange2);
        orangeBox.addFruit(orange3);

        System.out.println("Вес коробки с апельсинами (6) " + orangeBox.getWeight());

        System.out.println("Размер ящиков одинаков? " + appleBox.compare(orangeBox));

        appleBox.spread(orangeBox);

        Apple apple4 = new Apple();

        Box<Apple> appleBox2 = new Box<>(new SuitabilityForApples());
        appleBox2.addFruit(apple4);

        appleBox.spread(appleBox2);
        System.out.println("Вес второй коробки с яблоками после пересыпки (4) " + appleBox2.getWeight());
        System.out.println("Вес первой коробки с яблоками после пересыпки (0) " + appleBox.getWeight());

    }

}
