package setDriver;
import set.*;
import java.util.HashSet;
import java.util.Set;
public class Test
{
    public static void main(String[] args)
    {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(4);

        HashSet<Integer> hashSet1 = new HashSet<>(set1);
        HashSet<Integer> hashSet2 = new HashSet<>(set2);

        System.out.println("Set 1: " + hashSet1);
        System.out.println("Set 2: " + hashSet2);

        Set<Integer> union = new HashSet<>(hashSet1);

        System.out.println("Set difference: " + union);
    }
}
