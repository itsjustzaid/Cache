package cache;

import exception.KeyNotFound;
import exception.StorageFull;
import replacement_policy.ReplacementPolicy;
import storage.Storage;

public class Cache<K, V> {
    private final Storage<K, V> store;
    private final ReplacementPolicy<K> policy;

    public Cache(final Storage<K, V> store, final ReplacementPolicy<K> policy) {
        this.store = store;
        this.policy = policy;
    }

    public V get(K key) {
        try {
            policy.access(key);
            return store.get(key);
        } catch (KeyNotFound e) {
            throw new KeyNotFound("Cache doesn't have a key " + key);
        }
    }

    public void put(K key, V value) {
        try {
            store.put(key, value);
            policy.access(key);
        } catch (StorageFull e) {
            store.remove(policy.evict());
            put(key, value);
        }
    }
}
