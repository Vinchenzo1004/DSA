package listDriver;

/**
 * Class for a student
 *
 * @author Vincent Vaccaro
 */
public class Student
{
    String name;
    int id;

    public Student(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Student))
        {
            return false;
        }
        Student other = (Student)obj;
        return id == other.id;
    }

    public String toString()
    {
        return name + " " + id;
    }
}
