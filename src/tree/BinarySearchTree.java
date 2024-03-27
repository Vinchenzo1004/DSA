package tree;
import list.*;

/**
 * A BinarySearchTree is a BinaryTree in which left child is smaller,
 * right child is larger, and each nonEmpty child is also a BinarySearchTree.
 *
 * @author SDB & Vincent Vaccaro
 */
public class BinarySearchTree<E extends Comparable<E>> implements BinaryTree<E>
{
    E value;
    BinaryTree<E> left = new EmptyBinarySearchTree<E>(),
            right = new EmptyBinarySearchTree<E>();
    int size = 1;
    static boolean added, removed;

    public BinarySearchTree(E value)
    {
        this.value = value;
    }

    public E getValue()
    {
        return this.value;
    }

    public boolean containsKey(Object obj)
    {
        try
        {
            E key = (E) obj;
            int cmp = value.compareTo(key);
            if (cmp == 0)
            {
                return true;
            }

            if (cmp < 0)
            {
                return right.containsKey(key);
            }
            else
            {
                return left.containsKey(key);
            }
        }
        catch(ClassCastException cce)
        {
            return false;
        }
    }

    public E get(E value)
    {
        int cmp = this.value.compareTo(value);
        if(cmp == 0)
        {
            return this.value;
        }

        if(cmp < 0)
        {
            return right.get(value);
        }
        else
        {
            return left.get(value);
        }
    }

    public BinaryTree<E> add(E value)
    {
        added = false;
        return addHelper(value);
    }

    public BinaryTree<E> addHelper(E value)
    {
        int cmp = this.value.compareTo(value);
        if(cmp < 0)
        {
            right = right.add(value);
        }

        if(cmp > 0)
        {
            left = left.add(value);
        }

        if(added)
        {
            size++;
        }
        return this;
    }

    public BinaryTree<E> remove(Object obj)
    {
        removed = false;
        try
        {
            E value = (E) obj;
            return removeHelper(value);
        }
        catch(ClassCastException cce)
        {
            return this;
        }
    }

    private BinaryTree<E> removeHelper(E value)
    {
        int cmp = this.value.compareTo(value);
        if(cmp == 0)  //found it
        {
            removed = true;
            List<BinaryTree<E>> kids = children();
            if (kids.isEmpty())
            {
                return new EmptyBinarySearchTree<E>();
            }

            if(kids.size() == 1)
            {
                return kids.get(0);
            }

            BinaryTree<E> successor = getSuccessor();
            removeHelper(successor.getValue());
            this.value = successor.getValue();
            return this;
        }

        //Two children
        if(cmp < 0)
        {
            right = right.remove(value);
        }

        if(cmp > 0)
        {
            left = left.remove(value);
        }

        if(removed)
        {
            size--;
        }
        return this;
    }

    private List<BinaryTree<E>> children()  //return a list of this BinaryTree's children
    {
        List<BinaryTree<E>> result = new ArrayList<BinaryTree<E>>();
        if(!left.isEmpty())
        {
            result.add(left);
        }

        if(!right.isEmpty())
        {
            result.add(right);
        }
        return result;
    }

    private BinaryTree<E> getSuccessor()  //return the successor of this BinaryTree
    {
        BinaryTree<E> result = right;
        while(!result.getLeft().isEmpty())
        {
            result = result.getLeft();
        }
        return result;
    }

    public BinaryTree<E> getLeft()
    {
        return left;
    }

    public BinaryTree<E> getRight()
    {
        return right;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return false;
    }

    public void setValue(E value)
    {
        this.value = value;
    }
    public void setLeft(BinaryTree<E> left)
    {
        this.left = left;
        size = left.size() + right.size() + 1;
    }

    public void setRight(BinaryTree<E> right)
    {
        this.right = right;
        size = left.size() + right.size() + 1;
    }

    public Iterator<E> iterator()
    {
        return new TreeIterator<E>(this);
    }

    public String toString()
    {
        Iterator<E> it = this.iterator();
        String out = "[" + it.next();
        while(it.hasNext())
        {
            out += ", " + it.next();
        }
        return out + "]";
    }
}
