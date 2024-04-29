package set;
import list.*;

/**
 * A Collection with no duplicates.
 * No explicit ordering is required.
 *
 * @author SDB & Vincent Vaccaro
 */
public interface Set<E>
{
    /**
     * @return true iff this Set contains obj
     */
    boolean contains(Object obj);

    /**
     * Add the given value to this Set, if not already in this Set.
     *
     * @return true iff the value was added
     */
    boolean add(E value);

    /**
     * Remove given obj, if possible
     *
     * @return true iff the value was removed
     */
    boolean remove(Object obj);

    /**
     * @return an Iterator for this Set
     */
    Iterator<E> iterator();

    /**
     * @return the size of this Set
     */
    int size();

    /**
     * @return true iff this Set is empty
     */
    boolean isEmpty();

    /**
     * Clear this Set
     */
    void clear();

    /**
     * @return the difference: this Set - other Set
     */
    Set<E> difference(Set<E> other);
}
