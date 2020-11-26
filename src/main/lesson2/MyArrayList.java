package lesson2;

import java.util.Arrays;

public class MyArrayList<T extends Comparable<T>> {
    private final int DEFAULT_CAPACITY = 10;
    private int size;
    private T[] list;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("" + capacity);
        }

        list = (T[]) new Comparable[capacity];
    }

    public MyArrayList() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    protected void resize() {
        list = Arrays.copyOf(list, size + DEFAULT_CAPACITY);
    }

    public void add(T item) {
        add(size, item);
    }

    public void add(int index, T item) {
        if (size == list.length)
            resize();
        validateList(index);

        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }

        list[index] = item;
        size++;
    }

    public boolean remove(int index)
    {
        validateList(index);

        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;
        list[size] = null;

        return true;
    }

    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return remove(i);
            }
        }

        return false;
    }

    public T get(int index) {
        validateList(index);

        return list[index];
    }

    public void set(int index, T item) {
        validateList(index);
        list[index] = item;
    }

    public int size() {
        return size;
    }

    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public void selectionSort() {
         int min;
        for (int i = 0; i < size - 1; i++) {
            min = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[min])) {
                    min = j;
                }
            }

            swap(i, min);
        }
    }

    public void insertionSort() {
        int min;
        for (int i = 0; i < size; i++) {
            min = i;
            for (int j = i-1; j >= 0; j--) {
                if (less(list[min], list[j])) {
                    swap(j, min);
                    min = j;
                } else {
                    break;
                }
            }
        }
    }

    public void bubbleSort() {
        boolean isSwap = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-i-1; j++) {
                if (less(list[j+1], list[j])) {
                    swap(j, j+1);
                    isSwap = true;
                }
            }

            if (!isSwap) {
                break;
            }
        }
    }

    protected void validateList(int index)
    {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("out size");
        }
    }

    @Override
    public String toString() {
        int iMax = size - 1;
        if (iMax <= 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; ; i++) {
            sb.append(list[i]);
            if (i == iMax)
                return sb.append(']').toString();
            sb.append(", ");
        }
    }
}
