package lesson8.part2;

public class Cat {

    Color color;


    public Cat(Color color) {
        this.color = color;
        color.action();
    }

    class newInnerClass {

    }

    static class newStaticNestedClass {

    }

    @Override
    public String toString() {
        class newClass{

        }
        return "Cat{" + "color='" + color.getRussianColor() + '\'' + '}';
    }


}
