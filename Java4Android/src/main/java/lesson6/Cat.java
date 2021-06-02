package lesson6;

public class Cat extends Animal {


    public Cat(String name, String color, int age) {
        super(name, color, age);
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    protected void voice() {
        System.out.println("Мявк");
//        super.voice();
    }
}
