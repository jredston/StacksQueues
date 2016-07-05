/**
 * Your implementation of a Queue backed by a LinkedList.
 *
 * @author YOUR NAME HERE
 * @version 1.0
 */
public class LinkedListQueue<T> implements QueueInterface<T> {

    // Do not add new instance variables.
    // Do not modify this variable.
    private LinkedListInterface<T> backingList;

    /**
     * Initialize the Queue.
     */
    public LinkedListQueue() {
        backingList = new SinglyLinkedList<T>();

    }

    @Override
    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        backingList.addToBack(item);

    }

    @Override
    public T dequeue() {
        T result = backingList.removeFromFront();
        if (result == null) {
            throw new java.util.NoSuchElementException();
        } else {
            return result;
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

    /**
     * Used for testing your code. DO NOT USE THIS METHOD!
     *
     * @return the backing list of this queue.
     */
    public LinkedListInterface<T> getBackingList() {
        return backingList;
    }

}
