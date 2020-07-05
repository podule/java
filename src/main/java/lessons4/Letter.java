package lessons4;

public class Letter {
    private String letter;
    private int order;

    public Letter(String letterString, int order) {
        this.letter = letterString;
        this.order = order;
    }

    public String getLetter() {
        return letter;
    }

    public int getOrder() {
        return order;
    }
}
