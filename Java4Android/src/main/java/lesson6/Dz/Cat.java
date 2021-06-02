package lesson6.Dz;

public class Cat extends Animal{

    private final int maxRun = 200;
    protected static int count = 0;

    public Cat(String name) {
        super(name);
        count++;
    }

    protected void swim(int length) {
        System.out.println(super.name + " не умеет плавать");
    }

    protected void run(int length) {
        super.run(length, maxRun);
    }

    protected static void showCount() {
        System.out.println("Всего создано " + count + " кошек");
    }

}
