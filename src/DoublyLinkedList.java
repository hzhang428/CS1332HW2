
/**
 * Your implementation of a DoublyLinkedList. Note the slightly different
 * time complexities from a SinglyLinkedList in the interface.
 *
 * @author YOUR NAME HERE
 * @version 1.0
 */
public class DoublyLinkedList<T> implements LinkedListInterface<T> {

    // DO NOT ALTER OR ADD INSTANCE VARIABLES
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;

    @Override
    public void add(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (size == 0) {
            head = new LinkedListNode<T>(data, null, null);
            tail = head;
        } else {
            LinkedListNode<T> node = new LinkedListNode<T>(data, tail, null);
            tail.setNext(node);
            tail = node;
        }
        size += 1;

    }

    @Override
    public void addToFront(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (size == 0) {
            head = new LinkedListNode<T>(data, null, null);
            tail = head;
        } else {
            LinkedListNode<T> node = new LinkedListNode<T>(data, null, head);
            head.setPrev(node);
            head = node;
        }
        size += 1;
    }


    @Override
    public T remove() {
        if (this.isEmpty()) {
            return null;
        } else if (size == 1) {
            T data = head.getData();
            head = null;
            tail = null;
            size -= 1;
            return data;
        } else {
            T data = tail.getData();
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
            size -= 1;
            return data;
        }
    }


    @Override
    public T removeFromFront() {
        if (this.isEmpty()) {
            return null;
        } else if (size == 1) {
            T data = head.getData();
            head = null;
            tail = null;
            size -= 1;
            return data;
        } else {
            T data = head.getData();
            head.getNext().setPrev(null);
            head = head.getNext();
            size -= 1;
            return data;
        }
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public int size() {
        return size;
    }


    // DO NOT MODIFY CODE OR USE CODE BEYOND THIS POINT.


    @Override
    public LinkedListNode<T> getHead() {
        return head;
    }


    @Override
    public LinkedListNode<T> getTail() {
        return tail;
    }
}
