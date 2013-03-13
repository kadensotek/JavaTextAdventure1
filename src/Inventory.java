import java.util.ArrayList;

public class Inventory
{
    private boolean empty;
    private ArrayList<Item> items = new ArrayList<Item>();
    //private ArrayList<int> number = new ArrayList<int>();

    public Inventory()
    {
        empty = true;
    }

    public boolean isEmpty()
    {
        return this.empty;
    }

    public void addItem(Item item)
    {
        this.items.add(item);
    }

    public void useItem(Item item)
    {
        ;
    }

    public void printInventory()
    {
        for(int i=0; i<items.size(); i++)
        {
            System.out.printf("%d: %s\n", i+1, items.get(i).getName());
        }
    }
}
