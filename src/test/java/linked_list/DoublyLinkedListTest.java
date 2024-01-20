package linked_list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    @DisplayName("Given an empty list, when add is called, then head and tail should point to the same node")
    void addFirstElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        assertEquals(list.getHead(), list.getTail());
    }

    @Test
    @DisplayName("Give a list with some elements, when add is called, then new node should be added to tail")
    void addElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(list.getTail().data, 3);
    }

    @Test
    @DisplayName("Given an empty list, when remove is called, then nothing should happen")
    void removeEmptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertNull(list.getHead());
        list.remove(list.getHead());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    @DisplayName("Given a list with one element, when remove is called, then head and tail should be null")
    void removeOneElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        assertEquals(list.getHead(), list.getTail());
        assertEquals(list.getHead().data, 1);
        list.remove(list.getHead());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    @DisplayName("Given a list with some elements, when remove is called on middle node, should delete that node")
    void removeMiddleElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(list.getHead().data, 1);
        assertEquals(list.getTail().data, 3);
        list.remove(list.getHead().next);
        assertEquals(list.getHead().data, 1);
        assertEquals(list.getTail().data, 3);
        assertEquals(list.getHead().next.data, 3);
        assertEquals(list.getTail().prev.data, 1);
    }


    @Test
    @DisplayName("Given an empty list, when size is called, then size should be 0")
    void sizeEmptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertEquals(list.size(), 0);
    }

    @Test
    @DisplayName("Given a list with some elements, when size is called, then size should be equal to number of elements")
    void size() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(list.size(), 3);
    }
}