package linked_list;

public class Node<T> {
    public T data;
    Node<T> next, prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}
