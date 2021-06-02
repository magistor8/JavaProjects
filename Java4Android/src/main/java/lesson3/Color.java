package lesson3;

import java.util.Scanner;

public class Color {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        turnGame();
    }

    public static void turnGame() {
        while (true) {
            printTitles();
            chooseAction();
        }
    }

    private static void chooseAction() {
        switch (in.next()) {
//            case "1" -> colorRed();
//            case "2" -> colorCyan();
//            case "3" -> colorYellow();
//            case "4" -> colorBlue();
//            case "0" -> doExit();
//            default -> System.out.println("Попробуйте еще");
        }
    }

    private static void printTitles() {
        System.out.println("\nВыберите цвет терминала:");
        System.out.println("1. Красный");
        System.out.println("2. Бирюзовый");
        System.out.println("3. Желтый");
        System.out.println("4. Синий");
        System.out.println("0. Выход");
    }

    private static void colorRed() {
        System.out.println("\u001B[31m");
    }

    private static void colorCyan() {
        System.out.println("\u001B[36m");
    }

    private static void colorYellow() {
        System.out.println("\u001B[33m");
    }

    private static void colorBlue() {
        System.out.println("\u001B[34m");
    }

    private static void doExit() {
        System.out.println("Вы уверены? y\\n");
        switch (in.next()) {
//            case "y", "yes", "да", "торжественно подтверждаю", "+" -> System.exit(0);
        }

    }
}
