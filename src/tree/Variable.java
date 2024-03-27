package tree;

/**
 * Every variable is an Expr, and every Expr has a name
 * Two variables are equal if they have the same name
 *
 * @author Vincent Vaccaro
 */
public class Variable extends Expr
{
    char name;
    Integer value;

    public Variable(char name)
    {
        super(null, null);
        this.name = name;
    }

    public int eval()
    {
        if(value == null)
        {
            throw new IllegalArgumentException();
        }
        return value;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Variable))
        {
            return false;
        }

        Variable other = (Variable) obj;
        return name == other.name;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public Expr simplify()
    {
        return this;
    }

    public String toString()
    {
        return name + "";
    }
}
