package lesson3;

public class MyStack<T> {
    private T[] chars;
    private int size;

    public MyStack(int capacity) {
        chars = (T[]) new Object[capacity];
    }

    public void push(T ch) {
        if (size >= chars.length) {
            throw new StackOverflowError();
        }
        chars[size] = ch;
        size++;
    }

    public T pop()
    {
        T temp = chars[size-1];
        chars[size-1] = null;
        size--;

        return temp;
    }
}
