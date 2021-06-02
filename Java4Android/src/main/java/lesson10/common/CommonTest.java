package lesson10.common;

public class CommonTest {

    public static void main(String[] args) {
//        intTest();
//        stringTest();
        objectTest();
    }

    private static void intTest() {
        IntStorage intStorage = new IntStorage(20);
        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);

        intStorage.display();

        System.out.println("Find 2: " + intStorage.find(2));
        System.out.println("Find 2: " + intStorage.find(5));

        int valueLast = intStorage.get(intStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + valueLast);

    }

    private static void stringTest() {

        StringStorage stringStorage = new StringStorage(20);
        stringStorage.add("A");
        stringStorage.add("B");
        stringStorage.add("C");

        stringStorage.display();

        System.out.println("Find 2: " + stringStorage.find("B"));
        System.out.println("Find 2: " + stringStorage.find("F"));

        String valueLast = stringStorage.get(stringStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + valueLast);
    }

    private static void objectTest() {
        ObjectStorage intStorage = new ObjectStorage(20);
        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);
//        intStorage.add("3");


        intStorage.display();

        System.out.println("Find 2: " + intStorage.find(2));
        System.out.println("Find 2: " + intStorage.find(5));

        int valueLast = (int)intStorage.get(intStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + valueLast);

//        ================

        ObjectStorage stringStorage = new ObjectStorage(20);
        stringStorage.add("A");
        stringStorage.add("B");
        stringStorage.add("C");
//        stringStorage.add(1);

        stringStorage.display();

        System.out.println("Find 2: " + stringStorage.find("B"));
        System.out.println("Find 2: " + stringStorage.find("F"));

        String valueLast2 = (String) stringStorage.get(stringStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + valueLast2);
    }




}
