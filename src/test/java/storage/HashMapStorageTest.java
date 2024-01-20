package storage;

import exception.KeyNotFound;
import exception.StorageFull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapStorageTest {
    @Test
    @DisplayName("Given an empty storage, when get is called, then should throw key not found exception")
    void shouldThrowKeyNotFoundExceptionOnPut() {
        final int capacity = 3;
        final Integer key = 4;
        final HashMapStorage<Integer, Integer> store = new HashMapStorage<>(capacity);
        final KeyNotFound exception = assertThrows(
                KeyNotFound.class,
                () -> store.get(key)
        );
        final String expected = "Key " + key + " not found.";

        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("Given an empty list, when inserting elements, then it should store the values")
    void shouldStoreValues() {
        final int capacity = 3;
        final HashMapStorage<Integer, Integer> store = new HashMapStorage<>(capacity);
        store.put(1, 1);
        store.put(2, 2);
        store.put(3, 3);

        assertEquals(1, store.get(1));
        assertEquals(2, store.get(2));
        assertEquals(3, store.get(3));
    }

    @Test
    @DisplayName("Given a list, when put is called on an existing key, then the associated value should be updated")
    void shouldUpdateKeyOnPut() {
        final int capacity = 1;
        final int key = 1, value = 1, updatedValue = 2;
        final HashMapStorage<Integer, Integer> store = new HashMapStorage<>(capacity);
        store.put(key, value);
        store.put(key, updatedValue);

        assertEquals(updatedValue, store.get(key));
    }

    @Test
    @DisplayName("Given a list, when capacity is reached, then should throw storage full error")
    void shouldThrowStorageFullException() {
        final int capacity = 2;
        final HashMapStorage<Integer, Integer> store = new HashMapStorage<>(capacity);
        store.put(1, 1);
        store.put(2, 2);
        StorageFull exception = assertThrows(
                StorageFull.class,
                () -> store.put(3, 3)
        );
        final String expected = "Storage is full.";

        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("Given a list, when remove is called and key doesn't exist, then it should throw key not found exception")
    void shouldThrowKeyNotFoundOnRemove() {
        final int capacity = 2;
        final int key = 1;
        final  HashMapStorage<Integer, Integer> store = new HashMapStorage<>(capacity);
        final KeyNotFound exception = assertThrows(
                KeyNotFound.class,
                () -> store.remove(key)
        );

        final String expected = "Key " + key + " not found.";

        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("Given a list, when remove is called with a key that is avaialble, then it should remove the key")
    void shouldRemoveAKey() {
        final int capacity = 2;
        final int key1 = 1, value1 = 1;
        final int key2 = 2, value2 = 2;
        final HashMapStorage<Integer, Integer> store = new HashMapStorage<>(capacity);
        store.put(key1, value1);
        store.put(key2, value2);
        store.remove(key1);
        final KeyNotFound exception = assertThrows(
                KeyNotFound.class,
                () -> store.get(key1)
        );

        final String expected = "Key " + key1 + " not found.";

        assertEquals(expected, exception.getMessage());
        assertEquals(value2, store.get(2));
    }
}