package hashDriver;

public class Student
{
    String name;
    int id;
    double gpa;
    String email;

    public Student(String name, int id, double gpa, String email)
    {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public double getGpa()
    {
        return gpa;
    }

    public String getEmail()
    {
        return email;
    }

    /**
     * @return true iff obj is a Student and is equal to this Student
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Student))
        {
            return false;
        }
        Student other = (Student) obj;     // Cast the parameter as Student
        return name.equals(other.name) && id == other.id && email.equals(other.email);
    }

    public int hashCode()
    {
        int code = 17;
        code += name.hashCode() * 31;
        code += id * 31;
        code += email.hashCode();
        return code;
    }

    public String toString()
    {
        return "[Name: " + name + ", ID: " + id + ", GPA: " + gpa + ", Email: " + email + "]";
    }
}