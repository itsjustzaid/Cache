package replacement_policy;

import linked_list.DoublyLinkedList;
import linked_list.Node;

import java.util.HashMap;
import java.util.Map;

public class LRU<K> implements ReplacementPolicy<K> {
    private final DoublyLinkedList<K> list;
    private final Map<K, Node<K>> map;

    LRU() {
        map = new HashMap<>();
        list = new DoublyLinkedList<>();
    }
    @Override
    public void access(final K key) {
        if(map.containsKey(key)) {
            list.remove(map.get(key));
            list.add(key);
            return;
        }
        final Node<K> node = list.add(key);
        map.put(key, node);
    }

    @Override
    public K evict() {
        final Node<K> toRemove = list.getHead();
        if(toRemove == null)  return null;
        final K key = toRemove.data;
        list.remove(toRemove);
        map.remove(key);
        return key;
    }
}
