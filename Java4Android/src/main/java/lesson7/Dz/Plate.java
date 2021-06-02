package lesson7.Dz;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    protected void eat(Cat cat) {
        int ration = cat.ration();
        if (food < ration) {
            //Кушаем
            cat.currentSatiety += food;
            //Обнуляем еду в тарелке
            this.food = 0;
            return;
        }
        //Кушаем
        cat.currentSatiety += ration;
        //Уменьшаем еду в тарелке
        this.food -= ration;
    }

    protected void currentFood() {
        System.out.println("В тарелке осталось " + this.food + " еды");
    }

    public void addFood(int food) {
        this.food += food;
        System.out.printf("В тарелку насыпали %d еды, теперь всего %d еды в тарелке\n", food, this.food);
    }
}
