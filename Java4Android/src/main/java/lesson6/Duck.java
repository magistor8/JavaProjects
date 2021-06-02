package lesson6;

public class Duck extends Animal{

    public Duck(String name, String color, int age) {
        super(name, color, age);
    }

    public Duck(String name) {
        super(name);
    }

    @Override
    protected void voice() {
        System.out.println("Кря кря");
    }

    public void fly() {
        System.out.println("I can fly!");
    }
}
