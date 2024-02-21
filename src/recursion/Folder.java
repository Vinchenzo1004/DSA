package recursion;
import list.*;

public class Folder extends Item
{
    ArrayList<Item> list;

    public Folder(String name)
    {
        super(name);
        list = new ArrayList<>();
    }

    /**
     * Add the given Item to this Folder
     */
    public void addItem (Item item)
    {
        list.add(item);
    }

    public List<Document> getAllDocs() 
    {
        ArrayList<Document> temp = new ArrayList<>();
        for(int i = 0; i < list.size(); i++)
        {
            temp.addAll(list.get(i).getAllDocs());
        }
        return temp;
    }
}
