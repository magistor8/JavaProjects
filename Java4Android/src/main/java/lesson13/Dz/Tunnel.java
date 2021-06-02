package lesson13.Dz;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private final Semaphore tunnelSemaphore;

    public Tunnel(Semaphore ts) {
        this.length = 120;
        this.description = "Тоннель " + length + " метров";
        this.tunnelSemaphore = ts;
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                //Устанавливаем семафор
                tunnelSemaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                tunnelSemaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
