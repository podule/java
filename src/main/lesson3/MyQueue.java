package lesson3;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyQueue<T> {
    private final int DEFAULT_CAPACITY = 10;
    protected int size;
    protected T[] list;
    protected int begin;
    protected int end;

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("" + capacity);
        }

        list = (T[]) new Object[capacity];
    }

    public MyQueue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[begin];
    }


    public T remove() {
        T temp = peek();
        list[begin] = null;
        begin = nextIndex(begin);
        size--;

        return temp;
    }

    public void insert(T item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        list[end] = item;
        size++;
        end = nextIndex(end);
    }

    protected int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    public int size() {
        return size;
    }

    protected boolean isFull() {
        return size == list.length;
    }

    protected boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(list) + " begin: " + begin + " end: " + end + " size: " + size;
    }
}
