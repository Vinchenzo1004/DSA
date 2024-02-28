package recursion;

public class Recursion
{
    /**
     * @param x is not negative, y is positive
     * @return the integer quotient when x is divided by y, using recursion.
     */
    public int div(int x, int y)
    {
        if (x < y)
        {
            return 0;
        }
        else
        {
            return 1 + div(x - y, y);
        }
    }

    /**
     * @return the remainder when x is divided by y
     * Pre: x >= 0, y > 0
     */
    public int mod(int x, int y)
    {
        if (x < y)
        {
            return x;
        }
        else
        {
            return mod(x - y, y);
        }
    }
}
