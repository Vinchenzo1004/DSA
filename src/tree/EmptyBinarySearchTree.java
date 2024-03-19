package tree;

/**
 * An EmptyBinarySearchTree has no value and no children.
 *
 * @author SDB & Vincent Vaccaro
 */
public class EmptyBinarySearchTree<E extends Comparable<E>> implements BinaryTree<E>
{
    public E getValue()
    {
        return null;
    }

    public E get(E value)
    {
        return null;
    }

    public boolean containsKey(Object obj)
    {
        return false;
    }

    public BinaryTree<E> add(E value)
    {
        BinarySearchTree.added = true;
        return new BinarySearchTree<E>(value);
    }

    public BinaryTree<E> remove(Object obj)
    {
        return this;
    }

    public BinaryTree<E> getLeft()
    {
        return null;
    }

    public BinaryTree<E> getRight()
    {
        return null;
    }

    public int size()
    {
        return 0;
    }

    public boolean isEmpty()
    {
        return true;
    }

    public void setValue(E value)
    {
        // do nothing
    }

    public void setLeft(BinaryTree<E> left)
    {
        // do nothing
    }

    public void setRight(BinaryTree<E> right)
    {
        // do nothing
    }


}
