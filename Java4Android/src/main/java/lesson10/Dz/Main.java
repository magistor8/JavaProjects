package lesson10.Dz;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //первая часть
        String[] stringArray = {"str1", "str2", "str3", "str4"};
        Integer[] intArray = {1, 2, 3, 4};

        System.out.println("Массив до: " + Arrays.toString(stringArray));
        swap(stringArray, 1, 2);
        System.out.println("Массив после: " + Arrays.toString(stringArray));

        System.out.println("Массив до: " + Arrays.toString(intArray));
        swap(intArray, 2, 3);
        System.out.println("Массив после: " + Arrays.toString(intArray));

        //вторая часть
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();

        box1.add(apple1);
        box1.add(apple2);
        box2.add(orange1);
        box2.add(orange2);

        System.out.println("Вес первой коробки: " + box1.boxWeight());
        System.out.println("Вес второй коробки: " + box2.boxWeight());

        //Сравниваем коробки
        if (box1.compare(box2)) {
            System.out.println("Коробки равны по весу");
        } else {
            System.out.println("Коробки не равны по весу");
        }
        //Кладем еще один фрукт в первую коробку
        box1.add(apple3);

        //Сравниваем коробки
        if (box1.compare(box2)) {
            System.out.println("Коробки равны по весу");
        } else {
            System.out.println("Коробки не равны по весу");
        }

        //Создаем еще одну коробку с яблоками и добавляем туда пару яблок
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Box<Apple> box3 = new Box<>();
        box1.add(apple4);
        box1.add(apple5);

        //Пересыпаем из одной коробки яблоки в другую
        box1.pourInTo(box3);
        //Проверяем вес
        System.out.println("Вес первой коробки: " + box1.boxWeight());
        System.out.println("Вес третей коробки: " + box3.boxWeight());

    }

    private static <E> void swap(E[] array, int ind1, int ind2) {
        E temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }


}


