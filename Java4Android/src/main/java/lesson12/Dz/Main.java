package lesson12.Dz;

import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {

        testArray1();
        testArray2();

    }

    private static void testArray1() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();
        computationalCycle(arr);
        System.out.println("Время работы однопоточного метода: " + (System.currentTimeMillis() - a) + " мс");
    }

    private static void testArray2() {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> computationalCycle(a1), "A");

        Thread t2 = new Thread(() -> computationalCycle(a2), "B");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Время работы многопоточного метода: " + (System.currentTimeMillis() - a) + " мс");
    }

    //Синхронизация тут не обязательна, потому что потоки работают над разными массивами, а с помощью Join мы ждем окончание задач обоих потоков.
    private static void computationalCycle(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
