package lesson11;

import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        testArrayList();
//        testLinkedList();
//        testSet();
        testMap();
    }

    private static void testArrayList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add(1, "D");
//        arrayList.remove("B");
        System.out.println(arrayList);

        arrayList.trimToSize();

        Object[] objects = arrayList.toArray();
        String[] strings = arrayList.toArray(new String[0]);

        for (String s : arrayList) {
            System.out.print(s);
        }

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            System.out.print(s);
        }

//        Collections.rotate(arrayList, 3478563 % arrayList.size());
//        Collections.shuffle(arrayList);
//            Collections.reverse(arrayList);
        System.out.println(Collections.binarySearch(arrayList, "D"));
        System.out.println(Collections.replaceAll(arrayList, "C", "!!!"));
        Collections.swap(arrayList, 0, 1);
        System.out.println(arrayList);

        //Stream API
        System.out.println(arrayList.stream().peek(s -> System.out.println(s.toLowerCase().concat("!!!"))).collect(Collectors.toList()));

        var numArray = new ArrayList<Integer>();
        Collections.addAll(numArray, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(numArray.stream().filter(e -> e % 2 == 0).count());
        System.out.println(numArray.stream().filter(e -> e % 2 == 0).collect(Collectors.toList()));

    }


    private static void testLinkedList() {

        LinkedList<Set<BigInteger>> newList = new LinkedList<>();
        var linkedList = new LinkedList<Integer>();
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(7);
        linkedList.add(1);

        Collections.sort(linkedList);
        System.out.println(linkedList);
    }

    private static void testSet() {
        Set<Integer> set = new TreeSet<>();
        Collections.addAll(set, 7, 3, 4, 5, 1, 1, 1, 1, 2, 1, 1, 2, 3, 4, 5, 1, 1);
        System.out.println(set);
    }

    private static void testMap() {
        Map<String, String> map = new TreeMap<>();
        map.put("Russia", "Moscow");
        map.put("France", "Paris");
        map.put("Germany", "Berlin");
        map.put("Norway", "Oslo");

/*        for (String key : map.keySet()) {
            System.out.println(MessageFormat.format("Страна: {0}, столица:  {1}", key, map.get(key)));
        }*/

/*        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(MessageFormat.format("Страна: {0}, столица:  {1}", entry.getKey(), entry.getValue()));
        }*/

/*        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(MessageFormat.format("Страна: {0}, столица:  {1}", key, value));
            }
        });*/

        map.forEach( (key, value) -> System.out.println(MessageFormat.format("Страна: {0}, столица:  {1}", key, value)));

    }

}
