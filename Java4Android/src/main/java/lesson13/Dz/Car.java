package lesson13.Dz;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;
    private CyclicBarrier cb;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public void setCb(CyclicBarrier cb) {
        this.cb = cb;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 1600));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Машина готова, ждем остальные
        try {
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (MainClass.winner == null) {
            MainClass.winner = this.name;
            System.out.println(this.name + " пересек финишную прямую первым");
        }
    }
}
