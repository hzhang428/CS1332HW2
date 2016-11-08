/**
 * Your implementation of a Queue backed by a LinkedList.
 *
 * @author YOUR NAME HERE
 * @version 1.0
 */
public class LinkedListQueue<T> implements QueueInterface<T> {

    // DO NOT ALTER OR ADD INSTANCE VARIABLES
    private LinkedListInterface<T> backingList;

    /**
     * Constructs an empty Queue.
     */
    public LinkedListQueue() {
        backingList = new DoublyLinkedList<>();
    }


    @Override
    public void enqueue(T data) {
        backingList.add(data);
    }


    @Override
    public T dequeue() {
        if (backingList.isEmpty()) {
            throw new java.util.NoSuchElementException();
        } else {
            return backingList.removeFromFront();
        }
    }


    @Override
    public int size() {
        return backingList.size();
    }


    @Override
    public boolean isEmpty() {
        return backingList.isEmpty();
    }


    // DO NOT ALTER OR USE ANYTHING BEYOND THIS POINT!


    /**
     * Used for testing and grading purposes.
     * DO NOT USE THIS METHOD IN YOUR IMPLEMENTATION!
     *
     * @return the backing list of this queue
     */
    public LinkedListInterface<T> getBackingList() {
        return backingList;
    }

}
