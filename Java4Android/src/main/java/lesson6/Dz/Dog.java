package lesson6.Dz;

public class Dog extends Animal{

    private final int maxRun = 500;
    private final int maxSwim = 10;
    protected static int count = 0;

    public Dog(String name) {
        super(name);
        count++;
    }

    protected void swim(int length) {
        super.swim(length, maxSwim);
    }

    protected void run(int length) {
        super.run(length, maxRun);
    }

    protected static void showCount() {
        System.out.println("Всего создано " + count + " собак");
    }

}
