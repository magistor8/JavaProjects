package lesson10.generics;

public class GenericTest {

    public static void main(String[] args) {
        genericTest();
    }

    private static void genericTest() {
        GenericStorage<Integer> intStorage = new GenericStorage<>(20);
        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);
//        intStorage.add("3");


        intStorage.display();

        System.out.println("Find 2: " + intStorage.find(2));
        System.out.println("Find 2: " + intStorage.find(5));

        int valueLast = intStorage.get(intStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + valueLast);

//        ================

        GenericStorage<String> stringStorage = new GenericStorage<>(20);
        stringStorage.add("A");
        stringStorage.add("B");
        stringStorage.add("C");
//        stringStorage.add(1);

        stringStorage.display();

        System.out.println("Find 2: " + stringStorage.find("B"));
        System.out.println("Find 2: " + stringStorage.find("F"));

        String valueLast2 = stringStorage.get(stringStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + valueLast2);
    }
}
