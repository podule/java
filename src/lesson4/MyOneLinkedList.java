package lesson4;

import java.util.NoSuchElementException;

public class MyOneLinkedList<T> {
    private Node first;
    private int size;

    public MyOneLinkedList() {
        first = null;
    }

    private class Node {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void insertFirst(T item) {
        Node node = new Node(item);
        node.setNext(first);
        first = node;
        size++;
    }

    public T getFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        return first.getValue();
    }

    public T removeFirst() {
        T item = getFirst();
        first = first.getNext();
        size--;

        return item;
    }

    public int indexOf(T item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.getValue().equals(item)) {
                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    public void insert(int index, T item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            insertFirst(item);
            return;
        }

        Node current = first;
        int i = 0;

        while (i < index - 1) {
            current = current.getNext();
            i++;
        }

        Node node = new Node(item);
        node.setNext(current.getNext());
        current.setNext(node);
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            return removeFirst();
        }

        Node current = first;
        int i = 0;

        while (i < index - 1) {
            current = current.getNext();
            i++;
        }
        T temp = current.getNext().getValue();
        current.setNext(current.getNext().getNext());
        size--;

        return temp;

    }

    public boolean remove(T item) {
        if (isEmpty()) {
            return false;
        }
        if (first.getValue().equals(item)) {
            removeFirst();
            return true;
        }

        Node current = first;
        while (current.getNext() != null && !current.getNext().getValue().equals(item)) {
            current = current.getNext();
        }

        if (current.getNext() == null) {
            return false;
        }

        current.setNext(current.getNext().getNext());
        size--;
        return true;

    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.getValue());
            current = current.getNext();
            if(current != null) sb.append(", ");
        }

        return sb.toString();
    }
}
