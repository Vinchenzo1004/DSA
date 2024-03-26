package tree;

/**
 * An Expr may have left and right operands, each of which is an Expr
 *
 * @author SDB & Vincent Vaccaro
 */
public abstract class Expr
{
    Expr left, right;

    public Expr(Expr left, Expr right)
    {
        this.left = left;
        this.right = right;
    }

    /**
     * @return the value of this Expr, if it has one
     */
    public abstract int eval();

    /**
     * @return true iff this Expr is the same as obj
     */
    public abstract boolean equals(Object obj);

    /**
     * @return simplified version of this Expr, if possible
     */
    public abstract Expr simplify();
}
