package recursionDriver;
import recursion.*;

public class RecursionTester
{
    public static void main(String[] args)
    {
        Recursion recursion = new Recursion();

        // Test the div method
        int result = recursion.div(10, 3);
        System.out.println("Result of div(10, 3): " + result);

        int result1 = recursion.div(25, 5);
        System.out.println("Result of div(25, 5): " + result1);

        int result2 = recursion.div(50, 2);
        System.out.println("Result of div(50, 2): " + result2);

        int result3 = recursion.mod(100, 10);
        System.out.println("Result of mod(100, 10): " + result3);

        int result4 = recursion.mod(101, 10);
        System.out.println("Result of mod(101, 10): " + result4);

        int result5 = recursion.mod(237, 10);
        System.out.println("Result of mod(237, 10): " + result5);
    }
}
