package lesson3;

public class Main {
    public static void main(String[] args) {

        MyDequeue<Integer> dequeue = new MyDequeue<Integer>(4);

        dequeue.insertRight(1);
        System.out.println(dequeue);
        dequeue.insertRight(2);
        System.out.println(dequeue);
        dequeue.removeRight();
        System.out.println(dequeue);
        dequeue.insertLeft(4);
        System.out.println(dequeue);
        dequeue.removeRight();
        System.out.println(dequeue);
        dequeue.removeLeft();
        System.out.println(dequeue);

        InvertedString str = new InvertedString("Паралелограмм");
        System.out.println(str.revers());
    }
}
