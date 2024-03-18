package tree;

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
    static boolean added;

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
}
