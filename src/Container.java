import java.util.ArrayList;

public class Container
{
    private boolean empty;
    private ArrayList<Item> contents = new ArrayList<Item>();

    public Container()
    {
        this.isEmpty = true;
    }

    public boolean isEmpty()
    {
        return this.empty;
    }

    public Item getItem(int index)
    {
        if(this.isEmpty() == true)
        {
            Item item = contents.getItem(index);
            contents.remove(index);
            return item;
        }
    }

    public void addItem(Item newItem)
    {
        contents.add(newItem);
    }
}
