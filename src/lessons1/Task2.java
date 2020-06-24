package lessons1;

import java.util.ArrayList;
import java.util.Arrays;

class Task2 <T> {

    ArrayList<T> conversionArrayToArrayList(T[] list)
    {
        return new ArrayList<>(Arrays.asList(list));
    }

    void printArrayList(ArrayList<T> arrayList)
    {
        for (T t : arrayList) {
            System.out.println(t.toString());
        }
    }
}
