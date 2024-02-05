package list;

/**
 * An Iterator for Lists, which can move in either direction.
 * Initially ^ a b c d
 *
 * @author SDB & Vincent Vaccaro
 */

//The "extends" keyword is used to create a subclass that inherits the properties and behaviors of a superclass.
// It establishes an "is-a" relationship between the subclass and the superclass.
public interface ListIterator<E> extends Iterator<E>
{
    /**
     * @return true iff there is a previous() value
     */
    boolean hasPrevious();

    /**
     * @return the value to the left of the implicit cursor. Move implicit cursor to the left
     * Pre: hasPrevious() is true
     */
    E previous();

    /**
     * Remove last value obtained by a call to next() or previous()
     *
     * Pre: next() or previous() was called since the last call to remove()
     */
    void remove();
}
