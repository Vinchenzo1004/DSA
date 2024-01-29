package list;

/**
 * Iterate through a Collection
 *
 * @author SDB & Vincent Vaccaro
 */
public interface Iterator<E>
{
    /**
     * @return true iff there are more values
     */
    boolean hasNext();

    /**
     * @return the next value from the Collection
     * Pre: hasNext() is true
     */
    E next();

    /**
     * Remove the last value returned by next() from the Collection
     * Pre: next() has been called at least once since last call to remove
     */
    void remove();
}
