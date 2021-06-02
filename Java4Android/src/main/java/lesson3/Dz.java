package lesson3;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Dz {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        gameGeneralCycle(words);

    }

    private static void gameGeneralCycle(String[] words) {
        boolean game = true;

        while (game) {

            //Создаем пустую строку ответов
            String[] result = new String[15];
            fillString(result);

            //Выбираем слово
            String word = words[random.nextInt(words.length)];

            //Приветствие
            hello();

            //Игровой цикл
            while (!gameIterate(word, result)) {
                subtotal(result);
            }

            //Новая игра
            game = isNewGame();

        }
        System.out.print("\u001B[92;1m");
        System.out.println("Всего доброго");
    }

    private static void hello() {
        System.out.print("\u001B[92;1m");
        System.out.println("Здравствуйте! Вы должны отгадать слово, которое загадал компьютер.");
        System.out.println("Если вы напишете неверное слово, но там будут одинаковые буквы из правильного, компьютер покажет их вам в нужном порядке!\n");
        System.out.println("Введите слово:");
        System.out.print("\u001B[31;1m");
    }

    private static boolean gameIterate(String word, String[] result) {


        //Пользователь вводит ответ
        String answer = scanner.next();

        //Проверяем
        if (answer.toLowerCase(Locale.ROOT).equals(word)) {
            return true;
        } else {
            for (int i = 0; i < answer.length() && i < word.length(); i++) {
                char a = answer.charAt(i);
                char b = word.charAt(i);
                if (a == b) {
                    result[i] = Character.toString(a);
                }
            }
            return false;
        }

    }

    private static void fillString(String[] result) {
        for (int i = 0; i < result.length; i++) {
            result[i] = "*";
        }
    }

    private static void subtotal(String[] result) {
        System.out.println("К сожалению не верно, но посмотрите какие буквы совпали:");
        for (String s : result) {
            System.out.print(s);
        }
        System.out.println("\nВведите слово:");
    }

    private static boolean isNewGame() {
        System.out.println("Вы выиграли! Сыграете еще? y/n");
        while (true) {
            String answer = scanner.next();
            if (answer.equals("y") || answer.equals("Y")) {
                return true;
            } else {
                return false;
            }
        }
    }


}
