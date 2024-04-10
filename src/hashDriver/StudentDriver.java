package hashDriver;
import hash.*;

public class StudentDriver
{
    public static void main(String [] args)
    {
        HashTable<Student> school = new HashTable<Student>();
        school.put(new Student("Mohg, Lord of Blood", 18389, 4.0, "mohg17@lordofblood.edu"));
        school.put(new Student("Malenia, Blade of Miquella", 33251, 4.0, "malenia17@bladeofmiquella.edu"));
        school.put(new Student("Hoarah Loux, Warrior", 21903, 2.5, "hoarahloux17@warrior.edu"));

        System.out.println(school);

        for(int i = 0; i < school.size() - 1; i++)
        {
            int hash = school.getList(i).hashCode();
            for(int j = school.size() - 1; j > i; j--)
            {
                int hash2 = school.getList(j).hashCode();
                if(hash % 10 == hash2 % 10)
                {
                    System.out.println("Collision detected with " + hash + " and " + hash2);
                }
            }
        }
    }
}
