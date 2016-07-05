/**
 * Your implementation of a Stack backed by an array.
 *
 * @author YOUR NAME HERE
 * @version 1.0
 */
public class ArrayStack<T> implements StackInterface<T> {
    // Do not add any new instance variables!
    private T[] backingArray;
    private int size;

    /**
     * Construct a Stack with an initial capacity of {@code INITIAL_CAPACITY}.
     *
     * Use constructor chaining.
     */

    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    /**
     * Construct a Stack with the specified initial capacity of
     * {@code initialCapacity}.
     * 
     * @param initialCapacity
     *            Initial capacity of the backing array.
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        backingArray = (T[]) new Object[initialCapacity];
        size = 0;

    }

    @Override
    public void push(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        size++;
        if (size > backingArray.length) {
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[(size - 1) * 2];
            for (int i = 0; i < size - 1; i++) {
                newArray[i] = backingArray[i];
            }
            backingArray = newArray;
        }
        backingArray[size - 1] = item;

    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        T popItem = backingArray[size - 1];
        backingArray[size - 1] = null;
        size--;
        return popItem;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Used for testing your code. DO NOT USE THIS METHOD!
     *
     * @return the backing array of this queue.
     */
    public Object[] getBackingArray() {
        return backingArray;
    }
}
