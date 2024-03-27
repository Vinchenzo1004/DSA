package tree;

/**
 * A Mod, modulo, has two operands, each of which is an Expr
 *
 * @author Vincent Vaccaro
 */
public class Mod extends Expr
{
    public Mod(Expr left, Expr right)
    {
        super(left, right);
    }

    public int eval()
    {
        return left.eval() % right.eval();
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Mod))
        {
            return false;
        }

        Mod other = (Mod) obj;
        return left.equals(other.left) && right.equals(other.right);  //x % y = x % y
    }

    public Expr simplify()
    {
        left = left.simplify();
        right = right.simplify();
        if(left instanceof Constant && right instanceof Constant)
        {
            if(left.equals(new Constant(0)))
            {
                return new Constant(0);
            }

            if(right.equals(new Constant(0)))
            {
                System.err.println("Cannot have zero as the right operand");
            }

            if(right.equals(new Constant(1)) || left.equals(right))
            {
                return new Constant(0);
            }
        }
        return this;
    }

    public String toString()
    {
        return "(" + left + " % " + right + ")";
    }
}
