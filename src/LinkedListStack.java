/**
 * Your implementation of a Stack backed by a LinkedList.
 *
 * @author YOUR NAME HERE
 * @version 1.0
 */
public class LinkedListStack<T> implements StackInterface<T> {

    // Do not add new instance variables.
    // Do not modify this variable.
    private LinkedListInterface<T> backingList;

    /**
     * Initialize the Stack.
     */
    public LinkedListStack() {
        backingList = new SinglyLinkedList<T>();
    }

    @Override
    public void push(T item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        backingList.addToFront(item);
    }

    @Override
    public T pop() {
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
     * @return the backing list of this stack.
     */
    public LinkedListInterface<T> getBackingList() {
        return backingList;
    }

}
