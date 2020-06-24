package lessons1.boxs;

import lessons1.Suitabilitys.Suitability;
import lessons1.fruits.Fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits = new ArrayList<>();
    private Suitability suitability;

    public Box(Suitability suitability) {
        this.suitability = suitability;
    }

    private String getSuitabilityString() {
        return this.suitability.getString();
    }

    public Integer getWeight() {
        int weight = 0;
        for (T t : this.fruits) {
            weight += t.getWeight();
        }

        return weight;
    }

    public void addFruit(T fruit) {
        this.fruits.add(fruit);
    }

    public boolean compare(Box box) {
        return this.getWeight().equals(box.getWeight());
    }

    public void spread(Box box) {
        if (this.isSuitableBox(box)) {

            for (T t : this.fruits) {
                box.addFruit(t);
            }

            this.fruits.clear();
        } else {
            System.out.println("В коробке другие фрукты!");
        }
    }

    private boolean isSuitableBox(Box box) {
        return this.getSuitabilityString().equals(box.getSuitabilityString());
    }
}
