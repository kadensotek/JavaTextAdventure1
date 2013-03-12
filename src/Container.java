import java.util.ArrayList;

public class Container
{
    private boolean empty;
    private ArrayList<Item> contents = new ArrayList<Item>();

    public Container()
    {
        this.empty = true;
    }

    public boolean isEmpty()
    {
        return this.empty;
    }

    public void setEmpty(boolean empty)
    {
        this.empty = empty;
    }

    public Item getItem(int index)
    {
        Item item = contents.get(index);
        contents.remove(index);

        if(contents.isEmpty())
        {
            setEmpty(true);
        }

        return item;
    }

    public void addItem(int itemID)
    {
        Item item = new Item(itemID);
        contents.add(item);

        if(isEmpty())
        {
            setEmpty(false);
        }
    }
}
