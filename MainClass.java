package ru.podule.lthree;


import java.util.*;

public class MainClass {

    static String[] arrayWords = {"Создать", "массив", "набором", "слов", "Найти", "вывести",
            "список", "уникальных", "слов", "которых", "состоит", "массив", "слов"};

    public static void main(String[] args) {
        printUniqueWords(arrayWords);
        countNotUniqueWords(arrayWords);


        Phonebook pb = new Phonebook();
        pb.add("Иванов", "8-999-888-77-66", "iv@m.com");
        pb.add("Сидоров", "8-555-777-33-11", "sd@m.com");
        pb.add("Иванов", "8-111-444-66-99", "ov@m.com");

        System.out.println(pb.get("Иванов"));

    }

    private static void printUniqueWords(String[] array){
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        System.out.println(set);
    }

    private static void countNotUniqueWords(String[] array){
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i])+1);
            }else{
                map.put(array[i], 1);
            }
        }

        System.out.println(map);
    }

}
