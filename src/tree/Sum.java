package tree;

import jdk.jshell.ExpressionSnippet;

/**
 * A Sum has two operands, each of which is an Expr
 *
 * @author SDB & Vincent Vaccaro
 */
public class Sum extends Expr
{
    //Constructor
    public Sum(Expr left, Expr right)
    {
        super(left, right);
    }

    public int eval()
    {
        return left.eval() + right.eval();
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Sum))
        {
            return false;
        }

        Sum other = (Sum) obj;
        return left.equals(other.left) && right.equals(other.right)  //x + y = x + y
                || left.equals(other.right) && right.equals(other.left);  //x + y = y + x
    }

    public Expr simplify()
    {
        left = left.simplify();
        right = right.simplify();
        if(left instanceof Constant && left.eval() == 0)  //0 + x = x
        {
            return right;
        }

        if(right instanceof Constant && right.eval() == 0)  //x + 0 = x
        {
            return left;
        }

        return this;
    }

    public String toString()
    {
        return "(" + left + " + " + right + ")";
    }
}
