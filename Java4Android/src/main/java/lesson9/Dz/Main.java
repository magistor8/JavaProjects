package lesson9.Dz;

import java.util.Random;

public class Main {

    static Random random = new Random();
    static final int MAX_ARRAY_SIZE = 4;

    public static void main(String[] args) {

        //Массив не верного размера
        String[][] arr = new String[5][5];
        fillArray(arr);
        //Правильный массив
        String[][] arr2 = new String[4][4];
        fillArray(arr2);
        //Массив с ошибкой
        String[][] arr3 = new String[4][4];
        fillArray(arr3);
        //Создаем ошибку
        arr3[2][3] = "fdfdddfddf";
        arr3[0][2] = "error";

        myArrayData(arr);
        myArrayData(arr2);
        myArrayData(arr3);
    }

    private static void fillArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = String.valueOf(random.nextInt(9) + 1);
            }
        }
    }

    private static void myArrayData(String[][] arr) {

        int sum = 0;

        try {
            checkMyArraySizeException(arr);
            sum = checkMyArrayDataException(arr);
            System.out.println("Сумма числел всех элементов массива равна: " + sum);
        } catch (MyArraySizeException e) {
            System.err.println(e.getMessage());
        }

    }

    private static void checkMyArraySizeException(String[][] arr) throws MyArraySizeException {
        if (arr.length > MAX_ARRAY_SIZE) {
            throw new MyArraySizeException("Массив не подходящего размера");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j + 1 > MAX_ARRAY_SIZE) {
                    throw new MyArraySizeException("Массив не подходящего размера");
                }
            }
        }
    }

    private static int checkMyArrayDataException(String[][] arr) {
        int sum = 0;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    if (isParsable(arr[i][j])) {
                        temp = Integer.parseInt(arr[i][j]);
                    } else {
                        throw new MyArrayDataException(i, j);
                    }
                } catch (MyArrayDataException e){
                    System.err.println(e.getMessage());
                    temp = 0;
                }
                sum += temp;
            }
        }
        return sum;
    }

    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
