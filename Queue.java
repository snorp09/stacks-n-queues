import java.util.LinkedList;

public class Queue<T> {
    
    //  a Linked List is the simpliest easiest way of creating a Queue
    //  this is because Linked Lists come prepackaged with the methods needed for Queue operations
    private LinkedList<T> q = new LinkedList<>();

    //  Constructor for Queue data structure
    public Queue() {
    }

    //  adds item to the end if the queue (last item)
    public void enqueue(T item) {
        this.q.addLast(item);
    }

    //  removes the item at the start of the queue (first item)
    //  also returns the item being removed
    public T dequeue() {
        T temp = this.q.getFirst();
        this.q.removeFirst();
        return temp;
    }

    // returns the item at the start of the queue
    public T peek() {
        return this.q.getFirst();
    }

    //  returns the amount of items in the queue
    public int getSize() {
        return this.q.size();
    }
}
