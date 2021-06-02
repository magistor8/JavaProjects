package lesson6;

public class Dog extends Animal{

    private String name;
    private boolean isBark = false;

    public Dog(String name, String color, int age, boolean isBark) {
        super(name, color, age);
        this.isBark = isBark;
        this.name = "товарищ " + name.toUpperCase();
    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("%s, isBark = %s, также известный как %s", super.toString(), isBark, name);
    }

    public boolean isBark() {
        return isBark;
    }

    public void setBark(boolean bark) {
        isBark = bark;
    }

    @Override
    protected void voice() {
        System.out.println("Гау гау");
    }
}
