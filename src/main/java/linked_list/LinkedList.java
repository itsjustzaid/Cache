package linked_list;

public interface LinkedList<T> {
    Node<T> add(T data);

    void remove(Node<T> node);

    Node<T> getHead();

    Node<T> getTail();

    Integer size();
}
