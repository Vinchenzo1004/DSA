package tree;

/**
 * A Constant has an int value
 *
 * @author SDB & Vincent Vaccaro
 */
public class Constant extends Expr
{
    int value;

    //Constructor
    public Constant(int value)
    {
        super(null, null);  //no operands
        this.value = value;
    }

    public int eval()
    {
        return value;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Constant))
        {
            return false;
        }

        Constant other = (Constant) obj;
        return this.value == other.value;
    }

    public Expr simplify()
    {
        return this;
    }

    public String toString()
    {
        return value + "";
    }
}
