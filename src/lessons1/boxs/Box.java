package lessons1.boxs;

import lessons1.fruits.Fruit;

import java.util.ArrayList;
import java.util.Iterator;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits = new ArrayList<>();
    private int weight = 0;

    public Integer getWeight() {
        int weight = 0;
        for (T t : this.fruits) {
            weight += t.getWeight();
        }

        return weight;
    }

    public void addFruit(T fruit) {

        this.fruits.add(fruit);
        this.weight += fruit.getWeight();
    }

    public boolean compare(Box box) {
        return this.weight == box.weight;
    }

    public void spread(Box<T> box) {

        Iterator<T> iterator = this.fruits.iterator();

        while (iterator.hasNext()) {
            T fruit = iterator.next();
            box.addFruit(fruit);
            iterator.remove();
        }

    }
}
