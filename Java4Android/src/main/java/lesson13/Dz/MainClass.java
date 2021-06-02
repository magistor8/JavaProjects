package lesson13.Dz;

import java.util.concurrent.*;

public class MainClass {

    private static final int CARS_COUNT = 6;
    private static final CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
    private static final Semaphore tunnelSemaphore = new Semaphore((int)(CARS_COUNT/2));
    private final static Thread[] threads = new Thread[CARS_COUNT];
    public static String winner;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(100), new Tunnel(tunnelSemaphore), new Road(80));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
            cars[i].setCb(cb);
        }
        //Создаем потоки
        for (int i = 0; i < cars.length; i++) {
            threads[i] = new Thread(cars[i]);
        }
        //Стартуем
        for (int i = 0; i < cars.length; i++) {
            threads[i].start();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        //Ждем окончания
        for (int i = 0; i < cars.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Поздравляем " + winner + ", он становится победителем");
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}

