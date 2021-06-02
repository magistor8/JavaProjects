package lesson5;

public class Cat {
    //Статическое поле
    private static int catsCount = 0;
    //Дефолтное поле
    String name;
    //Публичное поле
    public String color;
    //Только в рамках пакета
    private int age;
    private String fff;
    //Только в рамках пакета и унаследованные
    protected int width;

    void voice() {
        System.out.println("Мяу");
    }

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        catsCount++;
    }

    //Геттер
    public static int getCatsCount() {
        return catsCount;
    }

    //Сеттер
    public void setFff(String fff) {
        this.fff = fff;
    }

    //Сеттер
    public void setAge(int age) {
        if (age >= 0 && age <= 30) {
            this.age = age;
        } else {
            System.err.println("Неверный ввод возраста");
        }

    }

    public void printInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format("Котик с именем %s имеет %s цвет и его возраст %d", name, color, age);
    }

    @Override
    protected void finalize() throws Throwable {
        catsCount--;
    }
}
