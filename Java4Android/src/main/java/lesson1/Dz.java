package lesson1;

public class Dz {

    public static void main(String[] args) {

        //2 задание
        byte varByte = 1;
        short varShort = 2;
        int varInt = 3;
        long varLong = 4;
        float varFloat = 1.11f;
        double varDouble = 1.22;
        char varChar = '│';
        char varChar2 = 44555;
        boolean varBool = true;
        String varString = "Строка";

        //3 задание
        float resultGetFormula = getFormula(1.11f, 2.22f, 3.33f, 4.44f);
        System.out.println("Результат 3 задания = " + resultGetFormula);

        //4 задание
        boolean resultIntSum = intSum(3, 6);
        System.out.println("Результат 4 задания = " + resultIntSum);
        resultIntSum = intSum(5, 7);
        System.out.println("Результат 4 задания = " + resultIntSum);

        //5 задание
        positiveOrNegative(4);
        positiveOrNegative(0);
        positiveOrNegative(-8);

        //6 задание
        boolean resultIsNegative = isNegative(7);
        System.out.println("Результат 6 задания = " + resultIsNegative);
        resultIsNegative = isNegative(-7);
        System.out.println("Результат 6 задания = " + resultIsNegative);

        //7 задание
        printHello("Вадим");

        //8 задание
        leapYear(1900);
        leapYear(2000);
        leapYear(2003);
        leapYear(2004);
    }

    private static float getFormula(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    private static boolean intSum(int a, int b) {
        if ((a + b) >= 10 && (a + b) <= 20) {
            return true;
        } else {
            return false;
        }
    }

    private static void positiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Метод positiveOrNegative принял положительное число");
        } else {
            System.out.println("Метод positiveOrNegative принял отрицательное число");
        }
    }

    private static boolean isNegative(int a) {
        if (a >= 0) {
            return false;
        } else {
            return true;
        }
    }

    private static void printHello(String name) {
        System.out.println("Привет, " + name);
    }

    private static void leapYear(int year) {
        if (year % 4 != 0) {
            System.out.println(year + " год не является високосным");
        } else if (year % 100 == 0 && year % 400 != 0) {
            System.out.println(year + " год не является високосным");
        } else {
            System.out.println(year + " год является високосным");
        }
    }
}
