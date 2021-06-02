package lesson13;

public class Store {
    private int product = 0;

    public synchronized void getProduct() {
        if (product < 1) {
            try {
                System.out.println("Сработала блокировка у покупателя");
                wait();
                System.out.println("Снята блокировка у покупателя");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println("Пользователь закупился на 1 единицу товара");
        System.out.println("Всего товара: " + product);
        notify();

    }

    public synchronized void setProduct() {
        if (product > 2) {
            try {
                System.out.println("Сработала блокировка у продавца");
                wait();
                System.out.println("Снята блокировка у покупателя");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println("Продавец пополнил на 1 единицу товара");
        System.out.println("Всего товара: " + product);
        notify();
    }
}

class MainStore {
    public static void main(String[] args) {

        Store store = new Store();

        //покупатель
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                store.getProduct();
            }
        }).start();

        //продавец
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                store.setProduct();
            }
        }).start();

    }
}


