package recursion;
import list.*;

public abstract class Item
{
    String name;

    public Item(String name)
    {
        this.name = name;
    }

    /**
     * @return A list of all the documents making up this Item
     * (and all contained folders) in any order
     */
    public abstract List<Document> getAllDocs();
}
