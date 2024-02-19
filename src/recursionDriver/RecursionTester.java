package recursionDriver;
import recursion.*;

public class RecursionTester
{
    public static void main(String[] args)
    {
        Recursion recursion = new Recursion();

        // Test the div method
        int result = recursion.div(10, 5);
        System.out.println("Result of div(10, 5): " + result);

        int result1 = recursion.div(25, 5);
        System.out.println("Result of div(25, 5): " + result1);

        int result2 = recursion.div(50, 2);
        System.out.println("Result of div(50, 2): " + result2);
    }
}
