package sort;
import list.*;

/**
 * BubbleSort Algorithm, efficient for LinkedLists
 *
 * @author SDB & Vincent Vaccaro
 */
public class BubbleSortLinked<E extends Comparable<E>> implements Sorter<E>
{
    List<E> list;

    public void sort(List<E> list)
    {
        this.list = list;
        E left, right;
        ListIterator<E> lit;

        for(int i = 0; i < list.size() - 1; i++)
        {
            lit = list.listIterator();
            right = lit.next();

            for(int j = 0; j < list.size() - i - 1; j++)
            {
                left = right;
                right = lit.next();
                if(left.compareTo(right) > 0)
                { //swap
                    lit.remove();    //right value
                    lit.previous();  //back up
                    lit.add(right);  //insert right value
                    right = lit.next();
                }
            }  //inner loop
        }  //outer loop
    }  //sort method
}  //class
