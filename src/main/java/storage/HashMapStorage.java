package storage;

import exception.KeyNotFound;
import exception.StorageFull;

import java.util.HashMap;

public class HashMapStorage<K, V> implements Storage<K, V> {
    private final int capacity;
    private final HashMap<K, V> map;

    public HashMapStorage(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    @Override
    public void put(K key, V value) {
        if (!isFull()) map.put(key, value);
        throw new StorageFull("Storage is full.");
    }

    @Override
    public V get(K key) {
        if (map.containsKey(key)) return map.get(key);
        throw new KeyNotFound(key + "not found.");
    }

    @Override
    public void remove(K key) {
        if (!map.containsKey(key)) {
            throw new KeyNotFound(key + "not found.");
        }
        map.remove(key);
    }

    private boolean isFull() {
        return map.size() == capacity;
    }
}
