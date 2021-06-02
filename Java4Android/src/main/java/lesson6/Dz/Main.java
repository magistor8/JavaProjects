package lesson6.Dz;

public class Main {

    public static void main(String[] args) {

        Dog dog1 = new Dog("Барсик");
        Dog dog2 = new Dog("Тузик");
        Cat cat1 = new Cat("Васька");

        dog1.run(400);
        dog2.run(600);
        dog1.swim(5);
        dog2.swim(15);
        cat1.run(150);
        cat1.run(250);
        cat1.swim(20);

        Dog.showCount();
        Cat.showCount();
        Animal.showCount();

    }

}
