package lesson11.Dz;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //1 часть
        System.out.println("\nпервая часть задачи:");
        ListTest.run();

        //2 часть
        System.out.println("\nвторая часть задачи:");
        MapTest.run();

    }

    private static class ListTest {

        static void run() {
            Set<String> set = new TreeSet<>();
            List<String> arrayList = new ArrayList<>();
            String[] stringArray = {"Apple", "Avocado", "Apricot", "Banana", "Grapes", "Lime", "Lemon", "Melon", "Avocado", "Banana"};
            Collections.addAll(set, stringArray);
            Collections.addAll(arrayList, stringArray);
            System.out.println("Первоначальный массив");
            System.out.println(Arrays.toString(stringArray));
            System.out.println("Уникальные слова");
            System.out.println(set);
            System.out.println("Количество повторений");
            //frequency подглядел в интернете ^_^
            for (String key : set) {
                System.out.println(key + ": " + Collections.frequency(arrayList, key));
            }
        }
    }

    private static class MapTest {

        static void run() {
            Phonebook<String, String> phonebook = new Phonebook<>();
            //Вносим значения
            phonebook.add("Иванов", "+79111505050");
            phonebook.add("Петров", "+79187778585");
            phonebook.add("Сидоров", "+79212121121");
            //Ищем значение и выводим в консоль
            System.out.println("Телефон Иванова: " + phonebook.get("Иванов"));
            //Добавляем второй телефон Петрову
            phonebook.add("Петров", "+79883235688");
            //Ищем значение и выводим в консоль
            System.out.println("Телефон Петрова: " + phonebook.get("Петров"));
        }
    }
}
