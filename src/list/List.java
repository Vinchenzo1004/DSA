package list;

/**
 * An ordered Collection
 * Duplicates permitted
 *
 * @author SDB & Vincent Vaccaro
 */
public interface List<E>
{
    /**
     * @return the value at given ndx
     * @param 0 <= ndx < size
     */
    E get(int ndx);

    /**
     * Change the value at given ndx, to the given value
     *
     * @return the old value
     * @param 0 <= ndx < size
     */
    E set(int ndx, E value);

    /**
     * Add given value at end of List
     */
    void add(E value);

    /**
     * Insert the given value at given ndx in this List
     */
    void add(int ndx, E value);

    /**
     * Remove the value at given ndx from this List
     *
     * @return the value that was removed
     * @param 0 <= ndx < size
     */
    E remove(int ndx);

    /**
     * @return the size of this List
     */
    int size();

    /**
     * @return true iff this List is empty
     */
    boolean isEmpty();

    /**
     * Clear this List
     */
    void clear();

    /**
     * @return the index of the given object in this List, or -1 if not found
     * */
    int indexOf(Object obj);

    /**
     * @return true iff this List contains the given object
     * */
    boolean contains(Object obj);

    /**
     * @return an Iterator for this List
     */
    Iterator<E> iterator();

    /**
     * @return true iff the last value in this List is duplicated
     */
    boolean lastIsDuplicated();
}
