package lesson11.Dz;

import java.util.*;

public class Phonebook<K, V> {

    private final Map<K, List<V>> map = new TreeMap<>();

    protected void add(K surname, V tel) {
        if (!ifEmptyMap(surname, tel)) {
            addValue(surname, tel);
        }
    }

    private boolean ifEmptyMap(K surname, V tel) {
        if (map.isEmpty()) {
            map.put(surname, new ArrayList<>());
            map.get(surname).add(tel);
            return true;
        }
        return false;
    }

    private void addValue(K surname, V tel) {
        if (!map.containsKey(surname)) {
            map.put(surname, new ArrayList<>());
        }
        map.get(surname).add(tel);
    }

    protected List<V> get(K surname) {
        if (map.containsKey(surname)) {
            return map.get(surname);
        }
        return new ArrayList<>();
    }
}
