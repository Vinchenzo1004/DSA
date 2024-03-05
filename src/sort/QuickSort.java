package sort;
import list.*;

/**
 * QuickSort algorithm; apply to an ArrayList
 *
 * @author SDB & Vincent Vaccaro
 */
public class QuickSort<E extends Comparable> implements Sorter<E>
{
    List<E> list;

    /**
     * Select a value as the pivot.
     * @param start and end specify the portion of the list to be partitioned
     * Post: p is position of pivot
     *                  list[start...p-1] < pivot
     *                  list[p+1...end] > pivot
     * @return p position of pivot
     */
    private int partition(int start, int end)
    {    //choose start as Pivot
        int p = start;
        E pivot = list.get(p);
        for(int i = start + 1; i <= end; i++)
        {
            if(list.get(i).compareTo(pivot) < 0)
            {
                list.set(p, list.get(i));
                p++;
                list.set(i, list.get(p));
            }
        }
        list.set(p, pivot);
        return p;
    }
    private void qSort(int start, int end)
    {
        if(end - start <= 0)
        {
            return;
        }

        int p = partition(start, end);
        qSort(start, p - 1);   //sort left part
        qSort(p + 1, end);     //sort right part
    }
    public void sort(List<E> list)
    {
        this.list = list;
        qSort(0, list.size() - 1);
    }
}
