package lessons4;

public class Abc {
    static Mutex mon = new Mutex(4);

    public static void main(String[] args) {
        new ThreadLetters(new Letter("A", 0), mon, 5).start();
        new ThreadLetters(new Letter("B", 1), mon,  5).start();
        new ThreadLetters(new Letter("C", 2), mon,  5).start();
        new ThreadLetters(new Letter("D", 3), mon,  5).start();
    }

}
