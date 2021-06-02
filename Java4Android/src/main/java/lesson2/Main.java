package lesson2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        converterSeasonSwitch(1);
//        converterSeasonSwitchAnother(2);
//        cycleFor();
//        cycleWhile();
        arrayTest();
    }

    private static void converterSeasonSwitch(int seasonNumber) {
        String season;

        switch (seasonNumber) {
            case 1:
                season = "Winter";
                break;
            case 2:
                season = "Spring";
                break;
            case 3:
                season = "Summer";
                break;
            case 4:
                season = "Fall";
                break;
            default:
                season = "Unknown";
                break;
        }

        System.out.println(season);
    }

    private static void converterSeasonSwitchAnother(int seasonNumber) {
    //Не работает в 1.8
//        String season = switch (seasonNumber) {
//            case 12, 1, 2 -> "Winter";
//            case 3, 4, 5 -> "Spring";
//        }

    }

    private static void cycleFor() {

        for (int i = 0; i < 10; i++) {
            if (i == 8) {
                break;
            } else if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }

    }

    private static void cycleWhile() {

        int i = 10;
        while (i == 0) {
            System.out.println("Безконечный цикл");
        }

        do {
            System.out.println("Безконечный цикл");
        } while (i == 0);
    }

    private static void arrayTest() {
        //Одномерный массив
        int[] array = new int[4];
        int[] array2 = {2, 6, 7, 8};

        final int ARRAY_SIZE = 8;
        int[] data = new int[ARRAY_SIZE];
        data[0] = 3;
        data[3] = 5;
        data[data.length - 1] = 6;

        for (int i = 0; i < data.length; i++) {
            //System.out.print(data[i] + " ");
        }
        //Вывод массива вариант 2
        //for each
        for(int n : data) {
            System.out.print(n);
        }
        System.out.println();
        //Вывод массива вариант 3
        System.out.println(Arrays.toString(data));
        //Сортировка массива
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));

        //Двумерный массив
        int[][] deepData = new int[ARRAY_SIZE][ARRAY_SIZE];

        int n = 1;
        //Перебор двумерного массива
        for (int i = 0; i < deepData.length; i++) {
            for (int j = 0; j < deepData[i].length; j++) {
                deepData[i][j] = n++;
            }
        }

        //iter -  for each
        for (int[] deepDatum : deepData) {
            for (int num : deepDatum) {
                System.out.printf("%3d", num);
            }
            System.out.println();
        }
    }
}
