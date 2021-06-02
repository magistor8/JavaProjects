package lesson8.Dz;

public class Cat implements Party {

    protected final String type = "Кот";
    protected final String name;
    protected final int maxRunningLength;
    protected final int maxJumpHeight;

    public Cat(String name, int maxRunningLength, int maxJumpHeight) {
        this.name = name;
        this.maxRunningLength = maxRunningLength;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public void jump() {
        System.out.println(type + " " + name + " умеет прыгать");
    }

    @Override
    public void run() {
        System.out.println(type + " " + name + " умеет бегать");
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxRunningLength() {
        return maxRunningLength;
    }

    @Override
    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }
}
