package lesson6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Мартин");
        Animal dog = new Dog("Гендальф", "Серый", 10, false);
        Animal duck = new Duck("Дональд Дак");
//        Animal animal = new Animal("Чудо-юдо");

//        duck.fly();

        Animal[] animals = {cat, duck, dog};

        for (Animal animal : animals) {
            animal.voice();
            if (animal instanceof Duck) {
                Duck trueDuck = (Duck) animal;
                trueDuck.fly();
            }

            if (animal instanceof Duck realDuck) {
                realDuck.fly();
            }
        }


        Object[] objects = {
                new int[]{1,1,1,1},
                new String("Строка"),
                new Random(),
                cat
        };

        for (Object object : objects) {
            System.out.println(object.toString());
        }

/*        cat.voice();
        dog.voice();*/

//        System.out.println(dog);

/*        doAction(cat);
        doAction(dog);*/
    }

    private static void doAction(Animal animal) {
        animal.voice();
        animal.run();
    }


}
