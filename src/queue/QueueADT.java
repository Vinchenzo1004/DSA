package queue;

/**
 * A FIFO List
 *
 * @author SDB & Vincent Vaccaro
 */
public interface QueueADT<E> //ADT - Abstract Data Type
{
    /**
     * Add the given value at the back of this Queue
     */
    void add(E value);

    /**
     * @return the value at the front of this Queue,
     * or a null reference if this Queue is empty
     */
    E peek();

    /**
     * Remove the value at front of this QueueADT
     *
     * @return the value removed
     * Pre: This QueueADT is not empty
     */
    E remove();

    /**
     * @return true iff this QueueADT is empty
     */
    boolean isEmpty();

    /**
     * @return clear the queue
     */
    void clear();
}
