package sort;
import list.*;

/**
 * Arrange the values in a List in ascending, or descending, order
 *
 * @author SDB & Vincent Vaccaro
 */
public interface Sorter<E extends Comparable>
{
    /**
     * sort the given list
     */
    void sort(List<E> list);
}
