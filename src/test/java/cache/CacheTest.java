package cache;

import exception.KeyNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import replacement_policy.LRU;
import replacement_policy.ReplacementPolicy;
import storage.HashMapStorage;
import storage.Storage;

import static org.junit.jupiter.api.Assertions.*;

class CacheTest {
    private Cache<Integer, String> cache;

    @BeforeEach
    void setUp() {
        final int capacity = 3;
        final Storage<Integer, String> store = new HashMapStorage<>(capacity);
        final ReplacementPolicy<Integer> policy = new LRU<>();
        cache = new Cache<>(store, policy);
    }

    @Test
    @DisplayName("Given a cache, when an key is present in the cache, then it should return associated value with the key")
    void shouldReturnValueForExistingKey() {
        final int key = 1234;
        final String value = "Value for 1234 key";
        cache.put(key, value);

        final String actual = cache.get(key);

        assertEquals(value, actual);
    }

    @Test
    @DisplayName("Given a cache, when an key is absent in cache, then it should throw key not present exception")
    void shouldReturnKeyNotFoundForUnavailableKey() {
        final int key = 1;
        final KeyNotFound exception = assertThrows(
                KeyNotFound.class,
                () -> cache.get(key)
        );
        final String expected = "Cache doesn't have a key " + key + ".";

        final String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given a cache, when capacity is reached its peak and a key is inserted, then it should evict the element according to specified poliy")
    void shouldRemoveElementBySpecifiedPolicy() {
        final int willBeReplaced = 1;
        cache.put(willBeReplaced, "1");
        cache.put(2, "2");
        cache.put(3, "3");
        cache.put(4, "4");
        final KeyNotFound exception = assertThrows(
                KeyNotFound.class,
                () ->  cache.get(1)
        );
        final String expected = "Cache doesn't have a key " + willBeReplaced + ".";

        final String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

}