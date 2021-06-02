package lesson3;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
/*        testString();
        int[] testArr = {1,1,1,1,1};
        testLinkArray(testArr.clone());
        System.out.println(Arrays.toString(testArr));*/

//        mainTestOverload();
//        testConsoleInput();
//        testSecondConsoleInput();
//        testRandom();
        Color.turnGame();
    }

    private static void testString() {
        String str1 = "Java";
        String str2 = "Java";
        String str3 = new String("Java");

        System.out.println("str1 == str2: " + (str1.equals(str2)));
        System.out.println("str1 == str3: " + (str3.equals(str1)));
    }

    private static void testLinkArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
            System.out.print(arr[i] + " ");
        }

    }

    private static void mainTestOverload() {
        testOverload(3, 4);
        testOverload(40);
        testOverload(3.6, 4.1);
        testOverload(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        testOverload(1, 2, 3, 4, 5, 6, 7, 8, 9);
        testOverload(4, 3, 6, 23, 3);
    }

    private static void testOverload(int a, int b) {
        int multiple = a * b;
        System.out.printf("Произведение %d и %d равно: %d (int*int)%n", a, b, multiple);
    }

    private static void testOverload(double a, double b) {
        double multiple = a * b;
        System.out.printf("Произведение %.1f и %.1f равно: %.1f (double*doble)%n", a, b, multiple);
    }

    private static void testOverload(int a) {
        int multiple = a * a;
        System.out.printf("Квадрат числа %d равен: %d (квадрат)%n", a, multiple);
    }

    private static void testOverload(int... arr) {
        int multiple = 1;
        for (int n : arr) {
            multiple *= n;
        }

        System.out.printf("Произведение массива %s равно: %d%n", Arrays.toString(arr), multiple);
    }

    private static void testConsoleInput() {
        int a = getFromScanner();
        int b = getFromScanner();
        testOverload(a, b);

    }

    private static int getFromScanner() {
        int a = 0;
        boolean isValid;
        do {
            isValid = false;
            if (in.hasNextInt()) {
                a = in.nextInt();
                isValid = true;
            } else {
                in.next();
            }
        } while (!isValid);

        return a;
    }

    private static void testSecondConsoleInput() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String name = in.readLine();
        double d = Double.parseDouble(in.readLine());
        System.out.println("Привет, " + name);
    }


    private static void testRandom() {
        int[] data = new int[40];
        Random random = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(10); //0 - 9
            data[i] = random.nextInt(8) + 3; //3 - 10
            data[i] = random.nextInt(12) - 5 ; //-5 - 6

            data[i] = (int)(Math.random() * 10); //0 - 9
            data[i] = (int)(Math.random() * 8) + 3; //3 - 10
            data[i] = (int)(Math.random() * 12) -5; //3 - 10
        }

        System.out.println(Arrays.toString(data));
    }




}
