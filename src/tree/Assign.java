package tree;

/**
 * Assignment in Java is an operator, which has a side effect and produces a result.
 * The side effect is that it changes the value of the variable.
 * The result is the value assigned.
 *
 * @author Vincent Vaccaro
 */
public class Assign extends Expr
{
    public Assign(Expr left, Expr right)
    {
        super(left, right);
    }

    public int eval()
    {
        if(!(left instanceof Variable))
        {
            throw new IllegalArgumentException();
        }
        else
        {
            ((Variable) left).value = right.eval();
            return ((Variable) left).value;
        }
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Assign))
        {
            return false;
        }
        Assign other = (Assign) obj;
        return right.equals(other.right);
    }
    public Expr simplify()
    {
        this.left = left.simplify();
        this.right = right.simplify();
        return this;
    }

    public String toString()
    {
        return "(" + left + " = " + right + ")";
    }
}
