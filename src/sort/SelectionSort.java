package sort;
import list.*;

/**
 * Selection Sort Algorithm
 *
 * @author SDB & Vincent Vaccaro
 */
public class SelectionSort<E extends Comparable> implements Sorter<E>
{
    List<E> list;

    private int posSmallest(int start)
    {
        int result = start;
        E value, smallValue = list.get(result);
        for(int i = start + 1; i < list.size(); i++)
        {
            value = list.get(i);
            if(value.compareTo(smallValue) < 0)
            {
                result = i;
                smallValue = list.get(result);
            }
        }
        return result;
    }

    /**
     * Exchange the values at given positions
     */
    private void swap(int x, int y)
    {
        E temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp); //O(1)
    }

    public void sort(List<E> list) //O(n^2)
    {
        this.list = list;

        for(int i = 0; i < list.size() - 1; i++)
        {
            swap(i, posSmallest(i));
        }
    }
}
