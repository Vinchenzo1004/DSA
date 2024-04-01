package sort;
import list.*;

/**
 * HeapSort algorithm.
 * ArrayList
 *
 * @author SDB & Vincent Vaccaro
 */
public class HeapSort<E extends Comparable> implements Sorter<E>
{
    List<E> list;

    public void sort(List<E> list)
    {
        this.list = list;
        heapify(0);
        int last = list.size() - 1;

        while(last > 0)
        {
            swap(0, last);
            last--;
            percDown(0, last);
        }
    }

    private void heapify(int root)
    {
        int max = list.size() - 1;

        if (root >= max)
        {
            return;
        }
        heapify(2 * root + 1);  //left
        heapify(2 * root + 2);  //right
        percDown(root, max);
    }

    private void percDown(int root, int max)
    {
        int bc = biggerChild(root, max);

        while(2 * root + 1 <= max && greater(bc, root))
        {
            swap(root, bc);
            root = bc;
            bc = biggerChild(root, max);
        }
    }

    /**
     * @param x
     * @param y
     * @return true iff value at position x > value at position y
     */
    private boolean greater(int x, int y)
    {
        return list.get(x).compareTo(list.get(y)) > 0;
    }

    /**
     * Pre: has at least one child
     * @return position of bigger child of root
     * @param disregard values beyond max
     */
    private int biggerChild(int root, int max)
    {
        int left = 2 * root + 1,
            right = left + 1;

        if(right > max)
        {
            return left;
        }

        if(greater(left, right))
        {
            return left;
        }
        return right;
    }

    private void swap(int x, int y)
    {
        E temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp); //O(1)
    }
}
