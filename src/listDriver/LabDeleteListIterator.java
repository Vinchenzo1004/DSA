package listDriver;
import list.*;

/**
 * 
 * @author (sdb and Vincent Vaccaro!)
 * @version (Feb 2018)
 */
public class LabDeleteListIterator
{
    
    static List <Student> roster;
    
    public static void main(String [] args)
    {   roster = new ArrayList<Student>();
        test();
        roster = new LinkedList<Student>();
        test();
    }
    
    private static void init()
    {   deleteFirstOfDup();
        roster.add (new Student ("mike", 2345));
        deleteFirstOfDup();
        roster.add (new Student ("jim", 2222));
        roster.add (new Student ("joseph", 2345));
        roster.add (new Student ("joe", 2345));
        roster.add (new Student ("mary", 3333));
        roster.add (new Student ("maryLou", 3333));
        System.out.println("Before deletions " + roster);
    }
    
    private static void test()
    {   
        init();
        deleteFirstOfDup();
        if (roster.size() != 5)
            System.err.println ("Deletion is incorrect");
        System.out.println ("Roster is " + roster + "\n");
    }
    
    /** Search the roster for the first pair of neighbors which are
     *  equal.  Delete the first member of that pair.
     */
    private static void deleteFirstOfDup()
    {
        ListIterator<Student> it = roster.listIterator();
        Student left = it.next();
        while(it.hasNext())
        {
            Student right = it.next();
            if(left.equals(right))
            {
                it.remove();
                left = right;
                right = it.next();
                return;
            }
        }
    }
}
