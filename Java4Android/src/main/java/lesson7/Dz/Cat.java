package lesson7.Dz;

import java.util.Random;

public class Cat {

    private final Random rand = new Random();
    private final String name;
    //Максимальная сытость
    private final int maxSatiety = rand.nextInt(100) + 101;
    //Текущая сытость
    protected int currentSatiety = 0;


    public Cat(String name) {
        this.name = name;
    }

    protected void satiety() {
        long percent = Math.round(((double)currentSatiety / (double)maxSatiety) * 100);
        System.out.println("Котик " + this.name + " сыт на " + percent + " процентов");
    }

    protected int ration() {
        return this.maxSatiety - this.currentSatiety;
    }
}
