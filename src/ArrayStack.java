/**
 * Your implementation of a Stack backed by an array.
 *
 * @author YOUR NAME HERE
 * @version 1.0
 */
public class ArrayStack<T> implements StackInterface<T> {

    // DO NOT ALTER OR ADD INSTANCE VARIABLES
    private T[] backingArray;
    private int size;

    /**
     * Constructs a Stack with an initial capacity of {@code INITIAL_CAPACITY}.
     *
     * You must use constructor chaining to implement this constructor.
     */
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }


    /**
     * Constructs a Stack with the specified initial capacity of
     * {@code initialCapacity}.
     *
     * @param initialCapacity the initial capacity of the backing array
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        backingArray = (T[]) new Object[initialCapacity];
    }


    @Override
    @SuppressWarnings("unchecked")
    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        if (size < backingArray.length) {
            backingArray[size] = data;
            size += 1;
            System.out.println("size" + data);
            System.out.println("size" + size);
        } else {
            T[] backingArray2 = (T[]) new Object[size * 2];
            for (int i = 0; i < size; i++) {
                backingArray2[i] = backingArray[i];
            }
            backingArray = backingArray2;
            backingArray[size] = data;
            size += 1;
        }
    }


    @Override
    public T pop() {
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        T data = backingArray[size - 1];
        backingArray[size - 1] = null;
        size -= 1;
        return data;
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    // DO NOT ALTER OR USE ANYTHING BEYOND THIS POINT!


    /**
     * Used for testing and grading purposes.
     * DO NOT USE THIS METHOD IN YOUR IMPLEMENTATION!
     *
     * @return the backing array of this stack
     */
    public Object[] getBackingArray() {
        return backingArray;
    }
}