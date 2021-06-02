package lesson9;

import lesson8.part1.Animal;
import lesson8.part1.Cat;
import lesson8.part1.Dog;
import lesson8.part1.Duck;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        testThrow();
//        foo();
//        bar();
//        baz();
//        System.out.println(testFinally(6, 2));
//        System.out.println(testFinally(6, 0));

/*        try {
            readFile("text543");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        danceAnimals();
    }

    private static void testThrow() {
        RuntimeException e = new ArithmeticException("Мы что-то сломали");
        System.out.println(e.getMessage());
//        e.printStackTrace();
        throw e;
    }

    private static void foo() {

        try {
            System.out.println(5 / 1);
            System.out.println(5 / 0);
            System.out.println(5 / 2);
        } catch (ArithmeticException e) {
        }
        System.out.println("Конец");
    }

    private static void bar() {
        int[] arr = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int[] arrDividers = {2, 5, 0, 1, 4, 0, 1};

        try {
            doCycleFor(arr, arrDividers);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Выход за пределы массива!");
            throw e;
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void doCycleFor(int[] arr, int[] arrDividers) {
        for (int i = 0; i < arr.length; i++) {
            try {
                divideNumber(arr, arrDividers, i);
            } catch (ArithmeticException e) {
                arr[i] = -1;
                System.err.println("Произошло деление на ноль на индексе: " + i);
            }
        }
    }

    private static void divideNumber(int[] arr, int[] arrDividers, int i) {
        arr[i] /= arrDividers[i];
    }

    private static void baz() {
        int c = 0;
        int n = 0;


        try (Scanner scanner = new Scanner(System.in)) {
            c = Integer.parseInt(scanner.next());
            n = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    private static int testFinally(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) {
            return 0;
        } finally {
            return -1;
        }
    }


    private static void readFile(String fileName) throws IOException {
        String path = "src/main/resources/lib/" + fileName + ".txt";
        File file = new File(path);
        var is = new BufferedReader(new FileReader(path));
        System.out.println(new String(is.readLine()));

        var sb = new StringBuilder();
        int n;
        while ((n = is.read()) != -1) {
            sb.append((char) n);
        }
        System.out.println(sb);
    }

    private static void danceAnimals() {
        Animal[] animals = {new Dog(), new Duck(), new Cat(), new Duck(), new Cat()};

        int i = 1;
        for (Animal animal : animals) {

            try {
                if (animal instanceof Cat) {
                    throw new CatFoundException(i);
                }
                System.out.println(animal);
            } catch (CatFoundException e) {
                System.err.println(e.getMessage());
            } finally {
                i++;
            }

        }

        throw new CatFoundException2();
    }
}

class CatFoundException2 extends RuntimeException {

        public CatFoundException2() {
            super("Котам здесь не рады!");
        }

        public CatFoundException2(int i) {
            super(String.format("Кот прокрался под номером %d на вечеринку животных", i));
        }

}
