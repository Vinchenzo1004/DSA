package tree;

/**
 * A Difference has two operands, each of which is an Expr
 *
 * @author Vincent Vaccaro
 */
public class Difference extends Expr
{
    public Difference(Expr left, Expr right)
    {
        super(left, right);
    }

    public int eval()
    {
        return left.eval() - right.eval();
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Difference))
        {
            return false;
        }

        Difference other = (Difference) obj;
        return left.equals(other.left) && right.equals(other.right);  //x - y = x - y
    }

    public Expr simplify()
    {
        left = left.simplify();
        right = right.simplify();
        if(left instanceof Constant && left.equals(new Constant(0)))  //0 - x = -x
        {
            return right;
        }

        if(right instanceof Constant && right.equals(new Constant(0)))  //x - 0 = x
        {
            return left;
        }

        if(left.equals(right))  //x - x = 0
        {
            return new Constant(0);
        }

        return this;
    }

    public String toString()
    {
        return "(" + left + " - " + right + ")";
    }
}
