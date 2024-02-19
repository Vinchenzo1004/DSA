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
            return 0;
        else
            return 1 + div(x - y, y);
    }
}
