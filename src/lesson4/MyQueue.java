package lesson4;

public class MyQueue<T> {
    private MyLinkedList<T> myLinkedList = new MyLinkedList<>();

    public int size() {
        return myLinkedList.size();
    }

    public boolean isEmpty() {
        return myLinkedList.isEmpty();
    }

    public void insert(T item) {
        myLinkedList.insertLast(item);
    }

    public T pop() {
        return myLinkedList.removeFirst();
    }

    public T peek() {
        return myLinkedList.getFirst();
    }
}
