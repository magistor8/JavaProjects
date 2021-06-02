package lesson8.Dz;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        
        Random rand = new Random();

        Human human1 = new Human("Игорь", rand.nextInt(10) + 11, rand.nextInt(10) + 6);
        Human human2 = new Human("Тимофей", rand.nextInt(10) + 11, rand.nextInt(10) + 6);
        Robot robot1 = new Robot("Бамблби", rand.nextInt(20) + 11, rand.nextInt(20) + 6);
        Robot robot2 = new Robot("Валли", rand.nextInt(20) + 11, rand.nextInt(20) + 6);
        Cat cat1 = new Cat("Рыжик", rand.nextInt(10) + 1, rand.nextInt(5) + 1);
        Cat cat2 = new Cat("Мурзик", rand.nextInt(10) + 1, rand.nextInt(5) + 1);
        
        Treadmill treadmill1 = new Treadmill(rand.nextInt(25) + 1);
        Treadmill treadmill2 = new Treadmill(rand.nextInt(25) + 1);
        Treadmill treadmill3 = new Treadmill(rand.nextInt(25) + 1);
        Wall wall1 = new Wall(rand.nextInt(20) + 1);
        Wall wall2 = new Wall(rand.nextInt(20) + 1);
        Wall wall3 = new Wall(rand.nextInt(20) + 1);
        
        Party[] party = {human1, human2, robot1, robot2, cat1, cat2};
        Obstacles[] obstacles = {treadmill1, treadmill2, treadmill3, wall1, wall2, wall3};
        
        //Погнали
        for (Party member : party) {
            int win = 1;
            System.out.println("Дистанцию начинает проходить " + member.getType() + " " + member.getName());
            for (Obstacles obstacle : obstacles) {
                if (!obstacle.jump(member) && !obstacle.run(member)) {
                    System.out.println(member.getType() + " " + member.getName() + " выбывает с дистанции");
                    win = 0;
                    break;
                }
            }
            if (win == 1) System.out.println(member.getType() + " " + member.getName() + " полностью прошел дистанцию, поздравляем победителя!");
        }

    }

}
