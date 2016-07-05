/**
 * Your implementation of a SinglyLinkedList
 *
 * @author Julia Redston
 * @version 1.0
 */
public class SinglyLinkedList<T> implements LinkedListInterface<T> {

    // Do not add new instance variables.
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size = 0;

    

 

    @Override
    public void addToFront(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException();
        }
        head = new LinkedListNode<T>(data, head);
        size++;
        if (size == 1) {
            tail = head;
        }

    }

    @Override
    public void addToBack(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException();
        }
        LinkedListNode<T> newData = new LinkedListNode<T>(data, null);
        if (head == null) {
            head = newData;
            tail = newData;

        } else {
            LinkedListNode<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newData);
            tail = newData;
        }
        size++;

    }

    @Override
    public T removeFromFront() {
        if (head == null) {
            tail = null;
            return null;

        }
        if (size == 1) {
            tail = null;
        }
        T deletedData = head.getData();
        head = head.getNext();
        size--;
        return deletedData;

    }

    @Override
    public T removeFromBack() {
        if (head == null) {
            return null;
        }
        if (head.getNext() == null) {
            T deletedData = head.getData();
            head = null;
            tail = null;
            size--;
            return deletedData;
        }

        LinkedListNode<T> current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        T deletedData = current.getNext().getData();
        current.setNext(null);
        tail = current;
        size--;
        return deletedData;
    }

   
    @Override
    public boolean isEmpty() {
        return head == null;

    }

    @Override
    public int size() {
        return size;

    }

    
    @Override
    public LinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }

    @Override
    public LinkedListNode<T> getTail() {
        // DO NOT MODIFY!
        return tail;
    }

}
