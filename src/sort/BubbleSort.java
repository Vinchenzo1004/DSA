package sort;
import list.*;

/**
 * BubbleSort Algorithm
 * Use an ArrayList
 *
 * @author SDB & Vincent Vaccaro
 */
public class BubbleSort<E extends Comparable> implements Sorter<E>
{
    List<E> list;

    private void swap(int x, int y)
    {
        E temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp); //O(1)
    }

    public void sort(List<E> list)
    {
        this.list = list;
        boolean isLoop = false;

        for(int i = 0; i < list.size() - 1; i++)
        {
            for(int j = 0; j < list.size() - i - 1; j++)
            {
                E left = list.get(j);
                E right = list.get(j + 1);
                if(left.compareTo(right) > 0)
                {
                    isLoop = false;
                    swap(j, j + 1);
                }
            }
            if(isLoop)
            {
                return;
            }
            isLoop = true;
        }
    }
}
