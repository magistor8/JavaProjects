package lesson7.Dz;

public class Main {

    public static void main(String[] args) {

        Cat cat = new Cat("Барсик");
        Plate plate = new Plate(300);

        //Отправляем котика поесть
        plate.eat(cat);

        //Проверяем его сытость
        cat.satiety();

        //Остаток в тарелке
        plate.currentFood();

        //Насыпаем еды в тарелку
        plate.addFood(200);

        //Создаем еще котиков и добавляем в массив котиков в массив
        Cat cat2 = new Cat("Рыжий");
        Cat cat3 = new Cat("Арчи");
        Cat cat4 = new Cat("Вася");
        Cat cat5 = new Cat("Дымок");

        Cat[] cats = {cat2, cat3, cat4, cat5};

        //Отправляем всех котиков поесть
        for (Cat thisCat : cats) {
            plate.eat(thisCat);
            //Проверяем их сытость
            thisCat.satiety();
            //Остаток в тарелке
            plate.currentFood();
        }


    }

}
