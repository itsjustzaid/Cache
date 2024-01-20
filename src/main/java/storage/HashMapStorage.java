package storage;

import exception.KeyNotFound;
import exception.StorageFull;

import java.util.HashMap;

public class HashMapStorage<K, V> implements Storage<K, V> {
    private final int capacity;
    private final HashMap<K, V> map;

    public HashMapStorage(final int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    @Override
    public void put(final K key, final V value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            return;
        }

        if (!isFull()) {
            map.put(key, value);
            return;
        }

        throw new StorageFull("Storage is full.");
    }

    @Override
    public V get(final K key) {
        if (!map.containsKey(key)) throw new KeyNotFound("Key " + key + " not found.");
        return map.get(key);
    }

    @Override
    public void remove(final K key) {
        if (!map.containsKey(key)) throw new KeyNotFound("Key " + key + " not found.");
        map.remove(key);
    }

    private boolean isFull() {
        return map.size() == capacity;
    }
}
