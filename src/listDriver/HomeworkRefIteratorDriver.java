package listDriver;
import list.*;

/**
 * Test the Iterator ADT.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class HomeworkRefIteratorDriver
{
    public static void main(String [] args)
    {   
    String name;
    List <String> names;

    System.out.println ("Testing Iterators for LinkedLists");
     names = new LinkedList <String> ();
     names.add ("jim");
     names.add ("mary");
     names.add ("joe");
     names.add ("sue");
     names.add ("mary");
   
   System.out.println (names);  // should be [jim,mary,joe,sue,mary]
   Iterator<String> itty = names.iterator();
   
   while (itty.hasNext())
    {    
        name = itty.next();
         if (name.length() > 3) 
            itty.remove();
    }
    System.out.println (names); // should be [jim,joe,sue]
}
}
