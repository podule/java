package lesson3;

import java.util.EmptyStackException;

public class MyDequeue<T> extends MyQueue<T> {

    public MyDequeue(int capacity) {
        super(capacity);
    }

    public MyDequeue() {
        super();
    }

    public void insertLeft(T item) {
        if (super.isFull()) {
            throw new StackOverflowError();
        }
        begin = prevIndex(begin);
        list[begin] = item;
        size++;
    }

    public void insertRight(T item) {
        super.insert(item);
    }

    public T removeLeft() {
        return super.remove();
    }

    public T removeRight() {
        T temp = peekRight();
        list[end-1] = null;
        end = prevIndex(end);
        size--;

        return temp;
    }

    public T peekRight()
    {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[end-1];

    }

    protected int prevIndex(int index) {
        return index == 0 ? list.length - 1 : index - 1;
    }

    @Override
    public void insert(T item) {
        throw new UnsupportedOperationException("Not");
    }

    @Override
    public T remove() {
        throw new UnsupportedOperationException("Not");
    }
}
