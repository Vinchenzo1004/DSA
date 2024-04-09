package hash;
import list.*;

/**
 * An Iterator for HashTables
 *
 * @author SDB & Vincent Vaccaro
 */
class TableIterator<K> implements Iterator<K>
{
    HashTable<K> table;
    Iterator<K> listIt;
    int ndx = 0;  //current LinkedList

    TableIterator(HashTable table)
    {
        this.table = table;
        setListIt(0);
    }

    /**
     * Set the listIt from the given ndx
     */
    public void setListIt(int ndx)
    {
        List<K> list = table.lists.get(ndx);
        listIt = list.iterator();
    }

    /**
     * @return index of next nonEmpty LinkedList or -1 if not found
     */
    private  int nextList()
    {
        for (int i = ndx + 1; i < table.lists.size(); i++)
        {
            List<K> list = table.lists.get(i);
            if (!list.isEmpty())
            {
                return i;
            }
        }
        return -1;
    }

    public boolean hasNext()
    {
        if(listIt.hasNext())
        {
            return true;
        }
        return nextList() > 0;
    }

    public K next()
    {
        if(!listIt.hasNext())
        {
            ndx = nextList();
            setListIt(ndx);
        }
        return listIt.next();
    }

    public void remove()
    {
        listIt.remove();
        table.size--;
    }
}
