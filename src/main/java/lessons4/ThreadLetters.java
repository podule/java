package lessons4;

public class ThreadLetters extends Thread {

    private Letter letter;
    private int replay;
    private Mutex mutex;

    public ThreadLetters(Letter letter, Mutex mutex, int replay) {
        this.letter = letter;
        this.mutex = mutex;
        this.mutex.addLetters(letter);
        this.replay = replay;
    }

    @Override
    public void run() {
        try {
            synchronized (mutex) {
                for (int i = 0; i < replay; i++) {
                    while (mutex.currentIndexLetter != letter.getOrder()) {
                        mutex.wait();
                    }
                    System.out.print(letter.getLetter());
                    mutex.setNextCurrentIndexLetter();
                    mutex.notifyAll();
                    Thread.sleep(600);
                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
