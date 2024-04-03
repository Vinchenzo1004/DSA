package tree;

/**
 * A Product, multiplication, has two operands, each of which is an Expr
 *
 * @author SDB & Vincent Vaccaro
 */
public class Product extends Expr
{
    //Constructor
    public Product(Expr left, Expr right)
    {
        super(left, right);
    }

    public int eval()
    {
        return left.eval() * right.eval();
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Product))
        {
            return false;
        }

        Product other = (Product) obj;
        return left.equals(other.left) && right.equals(other.right)  //x * y = x * y
                || left.equals(other.right) && right.equals(other.left);  //x * y = y * x
    }

    public Expr simplify()
    {
        left = left.simplify();
        right = right.simplify();
        if(right instanceof Quotient)
        {
            Quotient q = (Quotient) right;
            if (left.equals(q.right))
            {
                return q.left;
            }
        }

        if(left instanceof Constant && left.equals(new Constant(1)))  //1 * x = x
        {
            return right;
        }

        if(right instanceof Constant && right.equals(new Constant(1)))  //x * 1 = x
        {
            return left;
        }

        if(left instanceof Constant && left.equals(new Constant(0)))  //0 * x = 0
        {
            return new Constant(0);
        }

        if(right instanceof Constant && right.equals(new Constant(0)))  //x * 0 = 0
        {
            return new Constant(0);
        }

        return this;
    }

    public String toString()
    {
        return "(" + left + " * " + right + ")";
    }
}
