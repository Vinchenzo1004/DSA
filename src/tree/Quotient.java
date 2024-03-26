package tree;

/**
 * A Quotient, division, has two operands, each of which is an Expr
 *
 * @author Vincent Vaccaro
 */
public class Quotient extends Expr
{
    public Quotient(Expr left, Expr right)
    {
        super(left, right);
    }

    public int eval()
    {
        return left.eval() / right.eval();
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Quotient))
        {
            return false;
        }

        Quotient other = (Quotient) obj;
        return left.equals(other.left) && right.equals(other.right);  //x / y = x / y
    }

    public Expr simplify()
    {
        left = left.simplify();
        right = right.simplify();
        if(right instanceof Constant && right.equals(new Constant(0)))
        {
            System.err.println("Cannot have zero as the right operand");
        }

        if(left instanceof Constant && left.equals(new Constant(0)))  //x / 0 = 0
        {
            return new Constant(0);
        }

        if(left.equals(right))  //x / x = 1
        {
            return new Constant(1);
        }

        return this;
    }
    public String toString()
    {
        return "(" + left + " / " + right + ")";
    }
}
