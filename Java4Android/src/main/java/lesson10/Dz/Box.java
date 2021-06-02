package lesson10.Dz;

import java.util.ArrayList;

public class Box<E extends Fruits> {

    private final ArrayList<E> list = new ArrayList<>();
    private float weight;

    protected void add(E fruit) {
        list.add(fruit);
    }

    protected float boxWeight() {
        weight = 0;
        list.forEach((elem) -> weight += elem.getWeigth());
        return weight;
    }

    protected boolean compare(Box box) {
        return this.boxWeight() == box.boxWeight();
    }

    protected void pourInTo(Box<E> box) {
        list.forEach((elem) -> {
            box.add(elem);
        });
        list.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "list=" + list +
                ", weight=" + weight +
                '}';
    }
}
