
/**
 * Your implementation of a Queue backed by an array.
 *
 * @author YOUR NAME HERE
 * @version 1.0
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    // Do not add instance variables.
    private T[] backingArray;
    private int size;
    private int front;
    private int back;

    /**
     * Construct a Queue with an initial capacity of {@code INITIAL_CAPACITY}.
     *
     * Use Constructor Chaining
     */

    public ArrayQueue() {
        this(INITIAL_CAPACITY);

    }

    /**
     * Construct a Queue with the specified initial capacity of
     * {@code initialCapacity}.
     * 
     * @param initialCapacity
     *            Initial capacity of the backing array.
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        backingArray = (T[]) new Object[initialCapacity];
        size = 0;

    }

    @SuppressWarnings("unchecked")
    @Override
    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        size++;
        if (back == front - 1) {
            T[] newArray = (T[]) new Object[(size - 1) * 2];
            for (int i = 0; i < (size - front - 1); i++) {

                newArray[i] = backingArray[i + front];
            }

            for (int i = 0; i < front; i++) {

                newArray[i + size - front - 1] = backingArray[i];
            }
            back = size - 2;
            front = 0;
            backingArray = newArray;
        }
        if (back == backingArray.length - 1) {
            if (size > backingArray.length) {
                T[] newArray = (T[]) new Object[(size - 1) * 2];
                for (int i = 0; i < size - 1; i++) {

                    newArray[i] = backingArray[i];
                }
                backingArray = newArray;
            } else {
                back = -1;
            }

        }
        if (size == 1) {

            front = 0;
            back = 0;
            backingArray[0] = item;
        } else {
            back++;

            backingArray[back] = item;

        }

    }

    @Override
    public T dequeue() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        size--;
        T result = backingArray[front];

        backingArray[front] = null;
        if (size != 0) {
            if (front == backingArray.length - 1) {
                front = 0;
            } else {
                front++;
            }
        }
        return result;
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
