package lesson4;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int size;

    public MyLinkedList() {
        first = null;
        last = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    public ListIterator<T> listIterator() {
        return null;
    }

    private class MyListIterator implements ListIterator<T>{

        Node current = new Node(null, first);
        int index = 0;

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            T item = current.getNext().getValue();
            current = current.getNext();
            index++;
            return item;
        }

        @Override
        public boolean hasPrevious() {
            return current.getPrev() != null;
        }

        @Override
        public T previous() {
            T item = current.getPrev().getValue();
            current = current.getPrev();
            index--;
            return item;
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override
        public void set(T t) {
            current.setValue(t);
        }

        @Override
        public void add(T t) {
            Node node = new Node(t, current.getNext(), current);
            if (current.getNext() != null) {
                current.getNext().setPrev(node);
            }
            current.setNext(node);
            current = node;
            size++;
            index++;
        }
    }


    private class MyIterator implements Iterator<T> {

        Node current = new Node(null, first);

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            current = current.getNext();

            return current.getValue();
        }

        public void remove() {
            if (current.getPrev() == null) {
                current.getNext().setPrev(null);
            } else {
                current.getPrev().setNext(current.getNext());
            }

            if (current.getNext() == null) {
                current.getPrev().setNext(null);
            } else{
                current.getNext().setPrev(current.getPrev());
            }
            size--;
        }

    }

    private class Node {
        T value;
        Node next;
        Node prev;

        public Node(T value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
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
        if (isEmpty()) {
            last = node;
        } else {
            first.setPrev(node);
        }
        first = node;
        size++;
    }

    public void insertLast(T item) {
        Node node = new Node(item);
        if (isEmpty()) {
            first = node;
        } else {
            node.setPrev(last);
            last.setNext(node);
        }
        last = node;
        size++;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return first.getValue();
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return last.getValue();
    }

    public T removeFirst() {
        T item = getFirst();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;

        return item;
    }

    public T removeLast() {
        T item = getLast();

        if (last.getPrev() != null) {
            last.getPrev().setNext(null);
        } else {
            first = null;
        }
        last = last.getPrev();
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

        if (index == size) {
            insertLast(item);
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
        node.setPrev(current);
        current.setNext(node);
        node.getNext().setPrev(node);
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size) {
            return removeLast();
        }

        Node current = first;
        int i = 0;

        while (i < index - 1) {
            current = current.getNext();
            i++;
        }
        T temp = current.getNext().getValue();
        current.setNext(current.getNext().getNext());
        current.getNext().setPrev(current);
        size--;

        return temp;

    }

    public boolean remove(T item, int i) {
        if (isEmpty()) {
            return false;
        }
        if (first.getValue().equals(item)) {
            removeFirst();
            return true;
        }

        Node current = first;
        while (current != null && !current.getValue().equals(item)) {
            current = current.getNext();
        }

        if (current == null) {
            return false;
        }
        if (current == last) {
            removeLast();
            return true;
        }

        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
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
            if (current != null) sb.append(", ");
        }

        return sb.toString();
    }
}
