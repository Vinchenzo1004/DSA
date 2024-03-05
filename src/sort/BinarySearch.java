package sort;
import list.*;

/**
 * BinarySearch algorithm. ArrayList must be sorted in ascending order.
 *
 * @author SDB & Vincent Vaccaro
 */
public class BinarySearch<E extends Comparable>
{
    List<E> list;
    E target;

    //constructor
    public BinarySearch(List<E> list)
    {
        this.list = list;
    }

    /**
     * Search the list in this class for the given target.
     *
     * @return a position of the target or -1 if not found
     */
    public int search(E target)
    {
        this.target = target;
        return binSrch(0, list.size() - 1);
    }

    private int binSrch(int start, int end)
    {
        if(start > end)
        {
            return -1;  //not found
        }

        int mid = (start + end) / 2;
        int cmp = target.compareTo(list.get(mid));

        if(cmp == 0)
        {
            return mid; //found it
        }
        if(cmp < 0)
        {
            return binSrch(start, mid - 1);
        }
        return binSrch(mid + 1, end);
    }
}