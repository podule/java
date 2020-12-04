package lesson4;

public class MyStack<T> {
    private MyLinkedList<T> myLinkedList = new MyLinkedList<>();

    public void push(T ch) {
        myLinkedList.insertLast(ch);
    }

    public T pop()
    {
       return myLinkedList.removeLast();
    }

    public T peek() {
        return myLinkedList.getLast();
    }

    public boolean isEmpty() {
        return myLinkedList.isEmpty();
    }

    public int size() {
        return myLinkedList.size();
    }
}
