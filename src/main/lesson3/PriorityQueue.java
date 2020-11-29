package lesson3;

import java.util.Comparator;
import java.util.EmptyStackException;

public class PriorityQueue<T extends Comparable<T>> {
    private final int DEFAULT_CAPACITY = 10;
    private int size;
    private T[] list;
    Comparator<T> comparator;

    public PriorityQueue(int capacity) {
        this(capacity, Comparator.naturalOrder());
    }

    public PriorityQueue(int capacity, Comparator<T> comparator) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("" + capacity);
        }
        this.comparator = comparator;
        list = (T[]) new Object[capacity];
    }

    public PriorityQueue(Comparator<T> comparator) {

        list = (T[]) new Object[DEFAULT_CAPACITY];
        this.comparator = comparator;
    }

    public PriorityQueue() {
        this(Comparator.naturalOrder());
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public T remove() {
        T temp = peek();
        size--;
        list[size] = null;

        return temp;
    }

    public void insert(T item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        list[size] = item;
        size++;

        int i = size - 1;
        while (i > 0 && comparator.compare(list[i], list[i - 1]) < 0) {
            swap(i, i - 1);
            i--;
        }
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    private boolean isFull() {
        return size == list.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

}
