package lesson9.Dz;

import java.io.IOException;

public class MyArrayDataException extends IOException {

    public MyArrayDataException(int i, int j) {
        super("Элемент массива под номером: строка - " + i + ", столбец - " + j + " не может быть целым числом, элемент заменен на 0");
    }
}
