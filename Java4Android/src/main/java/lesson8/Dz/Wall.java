package lesson8.Dz;

public class Wall implements Obstacles{

    protected final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean run(Party member) {
        return false;
    }

    @Override
    public boolean jump(Party member) {
        System.out.println("Высота которую необходимо перепрыгнуть " + height + "м., а " + member.getType() + " " + member.getName() + " может прыгнуть максимум на " + member.getMaxJumpHeight() + " м.");
        if (member.getMaxJumpHeight() < this.height) {
            System.out.println("К сожалению " + member.getType() + " " + member.getName() + " не смог перепрыгнуть стену");
            return false;
        }
        System.out.println(member.getType() + " " + member.getName() + " с легкостью перепрыгнул эту стену");
        return true;
    }

}
