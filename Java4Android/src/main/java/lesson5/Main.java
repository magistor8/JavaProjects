package lesson5;

public class Main {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Мася", "Зеленый", 4);
        Cat cat2 = new Cat("Пушка", "Белый", 3);
        Cat cat4 = new Cat("Миша", "Черный", 6);
        //Вызов статического поля
        System.out.println(Cat.getCatsCount());


        cat1.printInfo();
        cat2.printInfo();

        System.out.println(cat1);

        Cat[] cats = {cat1, cat2};
        for (Cat cat : cats) {
            cat.voice();
        }

        //Финализер следует избегать
        cat4 = null;
        //Принудительный вызов мусорщика
        System.gc();

        System.out.println(Cat.getCatsCount());
    }
}
