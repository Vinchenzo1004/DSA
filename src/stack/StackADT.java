package stack;

/**
 * A LIFO List
 *
 * @author SDB & Vincent Vaccaro
 */
public interface StackADT<E>
{
    /**
     * Put a value on top of this StackADT
     *
     * @return the value
     */
    E push(E value);

    /**
     * @return value on top of this StackADT
     * Pre: This StackADT is not empty
     */
    E peek();

    /**
     * Remove the value on top of this StackADT
     *
     * @return the value removed
     * Pre: This StackADT is not empty
     */
    E pop();

    /**
     * @return true iff this Stack is empty
     */
    boolean isEmpty();

    /**
     * @return clear the Queue
     */
    void clear();
}
