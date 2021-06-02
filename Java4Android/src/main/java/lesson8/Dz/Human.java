package lesson8.Dz;

public class Human implements Party {

    protected String type = "Человек";
    protected String name;
    protected int maxRunningLength;
    protected int maxJumpHeight;

    public Human(String name, int maxRunningLength, int maxJumpHeight) {
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
