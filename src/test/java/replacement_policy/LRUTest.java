package replacement_policy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LRUTest {
    private LRU<String> policy;

    @BeforeEach
    void setUp() {
        policy = new LRU<>();
    }

    @Test
    @DisplayName("Given an empty cache, when evict is called, then it should return null")
    void shouldReturnNull() {
        assertNull(policy.evict());
    }

    @Test
    @DisplayName("Given a lru cache, when elements are inserted, then they should evict in lru manner")
    void shouldEvictInLRUFashion() {
        policy.access("1");
        policy.access("2");
        policy.access("3");
        policy.access("4");

        assertEquals("1", policy.evict());
        assertEquals("2", policy.evict());
        assertEquals("3", policy.evict());
        assertEquals("4", policy.evict());
    }

    @Test
    @DisplayName("Given a lru, when keys are accessed again, then order of evict should change according to lru policy")
    void shouldChangeOrderOfEviction() {
        policy.access("1");
        policy.access("2");
        policy.access("3");
        policy.access("4");
        policy.access("1");
        policy.access("3");

        assertEquals("2", policy.evict());
        assertEquals("4", policy.evict());
        assertEquals("1", policy.evict());
        assertEquals("3", policy.evict());
    }
}