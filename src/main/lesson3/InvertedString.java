package lesson3;

public class InvertedString {
    private String str;


    public InvertedString(String str) {
        this.str = str;
    }

    public String revers() {
        MyStack<Character> chars = new MyStack<Character>(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            chars.push(ch);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(chars.pop());
        }

        return sb.toString();
    }

}
