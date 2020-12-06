package com.company.Lab25_26;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MHashMap<K, V> implements HashMapInterface<K, V> {
    private int size = 64;
    private LinkedList<Item<K, V>>[] map = new LinkedList[size];
    private ArrayList<V> AllValues = new ArrayList<>();

    private int getHashNumber(K key) {
        return key.hashCode() % size;
    }

    @Override
    public void add(K key, V value) {
        int index = getHashNumber(key);
        if (map[index] == null)
            map[index] = new LinkedList<>();
        map[index].add(new Item<>(key, value));
        AllValues.add(value);
    }

    @Override
    public V get(K key) {
        int index = getHashNumber(key);
        if (map[index] != null) {
            for (Item<K, V> item : map[index]) {
                if (item.getKey().equals(key))
                    return item.getValue();
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = getHashNumber(key);
        if (map[index] != null) {
            Item<K, V>[] items = map[index].toArray(new Item[0]);
            for (int i = 0; i < items.length; i++) {
                if (items[i].getKey().equals(key)) {
                    AllValues.remove(map[index].get(i).getValue());
                    map[index].remove(i);
                    return items[i].getValue();
                }
            }
        }
        return null;
    }

    @Override
    public Iterator iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<V> {
        private int iterator = 0;

        @Override
        public boolean hasNext() {
            return iterator < AllValues.toArray().length;
        }

        @Override
        public V next() {
            return AllValues.get(iterator++);
        }
    }
}
