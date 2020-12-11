package lesson6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        int notBalanced = 0;
        for (int i = 0; i < 20; i++) {
            MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
            int a = 0;
            while (a < 6) {
                map.put(random.nextInt(100), 0);
                a++;
            }
            if (map.isBalanced() == false) {
                notBalanced++;
            }
        }
        System.out.println("Несбалансированы деревьев - " + notBalanced);
        System.out.println("Процент несбалансированных " + (((float) notBalanced * 100) / (float) 20) + " %");


    }

}
