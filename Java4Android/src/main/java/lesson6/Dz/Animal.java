package lesson6.Dz;

public abstract class Animal {

    protected String name;
    protected static int count = 0;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    protected void run(int length, int max) {
        if (length > max) {
            System.out.println(name + " может пробежать только " + max + " метров");
            return;
        }
        System.out.println(name + " пробежал " + length + " метров");
    }

    protected void swim(int length, int max) {
        if (length > max) {
            System.out.println(name + " может проплыть только " + max + " метров");
            return;
        }
        System.out.println(name + " проплыл " + length + " метров");
    }

    protected static void showCount() {
        System.out.println("Всего создано " + count + " животных");
    }

}
