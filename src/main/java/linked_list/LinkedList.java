package linked_list;

public interface LinkedList <T>{
    Node<T> add(T data);
    void remove(Node<T> node);
    Integer size();
}
