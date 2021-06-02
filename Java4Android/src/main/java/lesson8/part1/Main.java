package lesson8.part1;

public class Main {
    public static void main(String[] args) {

        var cat = new Cat();
        var dog = new Dog();
        var duck = new Duck();
        var plane = new Plane();
        HomeAnimal[] homeAnimals = {cat, dog, duck};

        foo(plane);
        foo(duck);
        /*foo(cat);*/
        String s;
    }

    private static void foo(Flying flying) {
        flying.fly();
    }


}
