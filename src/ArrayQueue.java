/**
 * Your implementation of a Queue backed by an array.
 *
 * @author Hao Zhang
 * @version 1.0
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    // DO NOT ALTER OR ADD INSTANCE VARIABLES
    private T[] backingArray;
    private int size;
    private int back;
    private int front;

    /**
     * Constructs a Queue with an initial capacity of {@code INITIAL_CAPACITY}.
     *
     * You must use constructor chaining to implement this constructor.
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        this(INITIAL_CAPACITY);
    }

    /**
     * Constructs a Queue with the specified initial capacity of
     * {@code initialCapacity}.
     *
     * @param initialCapacity the initial capacity of the backing array
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        backingArray = (T[]) new Object[initialCapacity];
    }

    /**
     * Enqueues a node with the given data to the back of your queue.
     *
     * For the array-backed implementations, if the array is completely filled
     * when trying to enqueue, double the size of the array first and then
     * enqueue.  When enqueuing into the doubled array, you should enqueue as if
     * enqueuing into a new Queue ie. start from index 0 again.
     *
     * This method should be implemented in O(1) time for the linked list-backed
     * implementation and amortized O(1) time for the array-backed
     * implementation.
     *
     * @param data the data to add
     * @throws IllegalArgumentException if {@code data} is null
     */
    @Override
    @SuppressWarnings("unchecked")
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        if (size < backingArray.length) {
            backingArray[back % (backingArray.length)] = data;
            size += 1;
            back += 1;
        } else {
            T[] backingArray2 = (T[]) new Object[size * 2];
            int i = front;
            int j = 0;
            while (i < back) {
                backingArray2[j] = backingArray[i % size];
                i++;
                j++;
            }
            backingArray = backingArray2;
            back = size;
            backingArray[back % (backingArray.length)] = data;
            size += 1;
            back += 1;
        }
    }

    /**
     * De-queues a node from the front of your queue.
     *
     * For array-backed implementations:
     * - you should not shrink the backing array.
     * - you must put {@code null} in the de-queued element's spot.
     *
     * Do NOT reset your {@code front} and {@code back} variables to their
     * initial values if the queue happens to become empty. In other words, for
     * the array-backed implementation, if I enqueue, dequeue, then enqueue,
     * then index 0 should be {@code null}, and index 1 should contain the
     * second enqueued item.
     *
     * This method should be implemented in O(1) time.
     *
     * @return the data from the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        } else {
            T data = backingArray[front];
            backingArray[front] = null;
            front += 1;
            size -= 1;
            return data;
        }
    }

    /**
     * Returns the size of the queue as an integer.
     *
     * This method should be implemented in O(1) time.
     *
     * @return number of items in the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     *
     * This method should be implemented in O(1) time.
     *
     * @return boolean representing whether the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    // DO NOT ALTER OR USE ANYTHING BEYOND THIS POINT!


    /**
     * Used for testing and grading purposes.
     * DO NOT USE THIS METHOD IN YOUR IMPLEMENTATION!
     *
     * @return the backing array of this queue
     */
    public Object[] getBackingArray() {
        return backingArray;
    }

}
