package recursion;
import list.*;

public class Document extends Item
{
    DocType type;

    public Document(String name, DocType type)
    {
        super(name);
        this.type = type;
    }

    public List<Document> getAllDocs()
    {
        List<Document> list = new ArrayList<>();
        list.add(this);
        return list;
    }

    public String toString()
    {
        return name + " (" + type + ")";
    }
}
