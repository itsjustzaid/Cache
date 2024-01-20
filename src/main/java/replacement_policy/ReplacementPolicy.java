package replacement_policy;

public interface ReplacementPolicy<K> {
    void access(K key);

    K evict();
}
