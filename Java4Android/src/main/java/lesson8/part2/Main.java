package lesson8.part2;

import lesson8.part1.Flying;

public class Main {
    public static void main(String[] args) {

//        Cat cat = new Cat(ColorOld.BLACK);
        Cat cat = new Cat(Color.BLACK);
//        System.out.println(cat);


        switch (cat.color) {
            case GREY -> System.out.println("ccc");
            case BLACK -> System.out.println("ччч");
        }


        testAnonClass();

    }

    private static void testAnonClass() {

//      new FlyingTestClass().fly();

        Flying testPeople = new Flying() {
            @Override
            public void fly() {
                System.out.println("каскадер выполняет новый трюк!");
            }
        };

        testPeople.fly();
        testPeople = () -> System.out.println("каскадер ОПЯТЬ выполняет новый трюк!");
        testPeople.fly();


/*        Flying testPeople2 = Math::random;
        testPeople2 = new Flying() {
            @Override
            public void fly() {
                Math.random();
            }
        };

        System.out.println(testPeople2.fly());*/



        Bar foo = new Bar() {
            @Override
            public void render(String startMessage) {
                System.out.println(startMessage);
            }
        };

        Bar foo1 = startMessage -> System.out.println(startMessage);

        Bar foo2 = System.out::println;



        foo.render("Hello world");

        foo2.render("Вывод из рендер 2");

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.print(i + " ");
            }
        }).start();

        new Thread(() -> {
            for (int i = 1000; i > 0; i--) {
                System.out.print(i + " ");
            }
        }).start();


    }
}
