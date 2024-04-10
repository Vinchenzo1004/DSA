package hashDriver;

public class Book
{
    String title;
    String author;
    int pageCount;
    Date copyRight;

    public Book(String title, String author, int pageCount, Date copyRight)
    {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.copyRight = copyRight;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public int pageCount()
    {
        return pageCount;
    }

    public Date copyRight()
    {
        return copyRight;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Book))
        {
            return false;
        }
        Book other = (Book) obj;
        return title.equals(other.title) && author.equals(other.author) && copyRight.equals(other.copyRight);
    }

    public int hashCode()
    {
        int code = 17;
        code += title.hashCode() * 31;
        code += author.hashCode() * 31;
        code += copyRight.hashCode() * 31;
        return code;
    }

    public String toString()
    {
        return "[Book '" + title + "' by " + author + ", Pages: " + pageCount + ", Date: " + copyRight + "]";
    }
}
