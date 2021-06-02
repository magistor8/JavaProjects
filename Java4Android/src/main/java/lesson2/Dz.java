package lesson2;

import java.util.Arrays;

public class Dz {

    public static void main(String[] args) {

        final int MAX = 6;

        //1 задание
        int[] arrInt = {1, 0, 0, 1, 0, 1, 0};
        arrInt = doFirst(arrInt);
        printArray(1, arrInt);

        //2 задание
        int[] arrInt2 = new int[8];
        arrInt2 = doSecond(arrInt2);
        printArray(2, arrInt2);

        //3 задание
        int[] arrInt3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        arrInt3 = doThird(arrInt3);
        printArray(3, arrInt3);

        //4 задание
        int[][] arrInt4 = new int[9][9];
        arrInt4 = doFourth(arrInt4);
        printTwoDimensionalArray(4, arrInt4);

        //5 задание
        int[] arrInt5 = {7, 99, 4, 5, 1, -2, 68};
        int[] dataRes = new int[2];
        dataRes = doFifth(arrInt5, dataRes);
        System.out.println("Результат 5 задания:");
        System.out.print("Минимальное значение: " + dataRes[0] + ", ");
        System.out.println("Максимальное значение: " + dataRes[1]);

        //6 задание
        //объявляем массив
        int[] arrInt6 = new int[6];
        //Заполняем случайными значениями
        arrInt6 = setRandomValues(arrInt6, MAX);
        //Получаем результат
        boolean resultCheckBalance = doSixth(arrInt6);
        System.out.println("Результат 6 задания:");
        System.out.print("В массиве: ");
        System.out.print(Arrays.toString(arrInt6));
        if (resultCheckBalance) {
            System.out.println(" - Есть место, в котором сумма левой и правой части массива равны");
        } else {
            System.out.println(" - Нет места, в котором сумма левой и правой части массива равны");
        }

        //7 задание
        //объявляем массив
        int[] arrInt7 = new int[6];
        //Заполняем случайными значениями
        arrInt7 = setRandomValues(arrInt7, MAX);
        //Выводим результат
        System.out.println("Результат 7 задания:");
        System.out.print("Изначальный массив: ");
        System.out.print(Arrays.toString(arrInt7));
        arrInt7 = doSeventh(arrInt7, 77);
        System.out.println();
        System.out.print("После сдвига: ");
        System.out.print(Arrays.toString(arrInt7));

    }

    private static void printArray(int a, int[] data) {
        System.out.println("Результат " + a + " задания:");
        for (int i : data) {
            System.out.printf("%3d", i);
        }
        System.out.println();
    }

    private static void printTwoDimensionalArray(int a, int[][] data) {
        System.out.println("Результат " + a + " задания:");
        for (int[] datum : data) {
            for (int i : datum) {
                System.out.printf("%3d", i);
            }
            System.out.println();
        }
    }

    private static int[] doFirst(int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                data[i] = 0;
            } else {
                data[i] = 1;
            }
        }
        return data;
    }

    private static int[] doSecond(int[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = i * 3;
        }
        return data;
    }

    private static int[] doThird(int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 6) data[i] *= 2;
        }
        return data;
    }

    private static int[][] doFourth(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            data[i][i] = data[i][data.length - (i + 1)] = 1;
        }
        return data;
    }


    private static int[] doFifth(int[] data, int[] dataRes) {
        Arrays.sort(data);
        dataRes[0] = data[0];
        dataRes[1] = data[data.length - 1];
        return dataRes;
    }

    private static int[] setRandomValues(int[] data, int max) {
        for (int i = 0; i < data.length; i++) {
            data[i] = (int)(Math.random() * max);
        }
        return data;
    }

    private static boolean doSixth(int[] data) {
        int sumLeftSide;
        int sumRightSide;
        for (int i = 0; i < data.length; i++) {
            sumLeftSide = 0;
            sumRightSide = 0;
            for (int j = 0; j < data.length; j++) {
                if (j <= i) {
                    sumLeftSide += data[j];
                } else {
                    sumRightSide += data[j];
                }
            }
            if (sumLeftSide == sumRightSide) {
                return true;
            }
        }
        return false;
    }


    private static int[] doSeventh(int[] data, int offset) {
        int old;
        if (offset < 0) {
            for (int i = 0; i > offset; i--) {
                old = data[0];
                for (int j = 0; j < data.length - 1; j++) {
                    data[j] = data[j + 1];
                }
                data[data.length - 1]= old;
            }
        } else if (offset > 0) {
            for (int i = 0; i < offset; i++) {
                old = data[data.length - 1];
                for (int j = data.length - 1; j > 0; j--) {
                    data[j] = data[j - 1];
                }
                data[0]= old;
            }
        } else {
            return data;
        }
        return data;
    }
}
