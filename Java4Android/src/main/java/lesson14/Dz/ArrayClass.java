package lesson14.Dz;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayClass {
    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 6, 8, 1, 9, 5, 6};
        int[] arr2 = arrayMagic(arr);
        System.out.println(Arrays.toString(arr2));
    }

    public static int[] arrayMagic (int[] arr) {

        //Чекаем на наличие 4
        try {
            check(arr);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        //Находим последнюю 4
        int lastIndex = lastIndexOf(arr, 4);

        //Вытаскиваем новый массив
        return Arrays.copyOfRange(arr, lastIndex + 1, arr.length);

    }

    public static void check(int[] arr) throws RuntimeException {
        //Подсмотрел в интернете
        if (IntStream.of(arr).noneMatch(x -> x == 4)) {
            throw new RuntimeException("Массив не содержит ни одной четверки");
        }
    }

    public static int lastIndexOf(int[] arr, int v) {
        for (int i = arr.length-1; i >= 0; i--)
            if (arr[i] == v)
                return i;
        return -1;
    }
}
