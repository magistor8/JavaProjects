package lesson8.Dz;

public class Treadmill implements Obstacles {

    protected final int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean run(Party member) {
        System.out.println("Расстояние которое необходимо пробежать " + distance + "м., а " + member.getType() + " " + member.getName() + " может пробежать максимум " + member.getMaxRunningLength() + " м.");
        if (member.getMaxRunningLength() < this.distance) {
            System.out.println("К сожалению " + member.getType() + " " + member.getName() + " не смог пробежать до конца эту дистанцию");
            return false;
        }
        System.out.println(member.getType() + " " + member.getName() + " с легкостью пробежался по беговой дорожке");
        return true;
    }

    @Override
    public boolean jump(Party member) {
        return false;
    }

}
