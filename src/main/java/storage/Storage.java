package storage;

import exception.KeyNotFound;
import exception.StorageFull;

public interface Storage<K, V> {
    void put(K key, V value) throws StorageFull;

    V get(K key) throws KeyNotFound;

    void remove(K Key) throws KeyNotFound;
}
