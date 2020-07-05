package lessons4;

public class Mutex {

    public volatile int currentIndexLetter;
    public String[] letters;

    public Mutex(int sizeLetters) {
        letters = new String[sizeLetters];
    }

    public void addLetters(Letter letter) {
        letters[letter.getOrder()] = letter.getLetter();
    }

    public String getLetter(int order) {
        return letters[order];
    }

    public void setNextCurrentIndexLetter()
    {
        if (currentIndexLetter == letters.length-1) {
            currentIndexLetter = 0;
        } else {
            currentIndexLetter++;
        }
    }
}
