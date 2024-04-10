package hashDriver;

public class Date
{
    int day;
    int month;
    int year;

    public Date(int month, int day, int year)
    {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Date))
        {
            return false;
        }
        Date other = (Date) obj;
        return (this.month == other.month) && (this.day == other.day) && (this.year == other.year);
    }

    public int hashCode()
    {
        int code = 17;
        code += month * 31;
        code += day * 31;
        code += year * 31;
        return code;
    }

    public String toString()
    {
        switch(month)
        {
            case 1: return "(January " + day + ", " + year + ")";
            case 2: return "(February " + day + ", " + year + ")";
            case 3: return "(March " + day + ", " + year + ")";
            case 4: return "(April " + day + ", " + year + ")";
            case 5: return "(May " + day + ", " + year + ")";
            case 6: return "(June " + day + ", " + year + ")";
            case 7: return "(July " + day + ", " + year + ")";
            case 8: return "(August " + day + ", " + year + ")";
            case 9: return "(September " + day + ", " + year + ")";
            case 10: return "(October " + day + ", " + year + ")";
            case 11: return "(November " + day + ", " + year + ")";
            case 12: return "(December " + day + ", " + year + ")";
        }
        return "";
    }
}
