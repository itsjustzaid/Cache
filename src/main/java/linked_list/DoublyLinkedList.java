package linked_list;

public class DoublyLinkedList<T> implements LinkedList<T> {

    private Node<T> head, tail;
    private Integer size = 0;
    @Override
    public Node<T> add(T data) {
        size += 1;
        if (head == null) {
            head = new Node<>(data);
            tail = head;
            return head;
        }
        Node<T> node = new Node<>(data);
        tail.next = node;
        node.prev = tail;
        tail = node;
        return tail;
    }

    @Override
    public void remove(Node<T> node) {
        if (head == null) return;

        if (node == head) {
            removeHead();
            size-=1;
            return;
        }
        if (node == tail) {
            removeTail();
            size-=1;
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size++;
    }

    @Override
    public Integer size() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    private void removeHead() {
        if(head == null) return;

        if(head.next != null) {
            head = head.next;
            head.prev = null;
            return;
        }

        head = null;
        tail = null;
    }

    private void removeTail() {
        if(tail == null) return;

        if(tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        tail = null;
        head = null;
    }
}
