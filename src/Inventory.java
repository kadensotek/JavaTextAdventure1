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
        if(isEmpty())
        {
            this.empty = false;
        }

        this.items.add(item);
    }

    public void useItem(Item item)
    {
       // uses item
       // calls useItem function in Item class
    }

    public void printInventory()
    {
        if(!isEmpty())
        {
            for(int i=0; i<items.size(); i++)
            {
                System.out.printf("%d: %s\n", i+1, items.get(i).getName());
            }
        }
        else
        {
            System.out.printf("Inventory is empty.\n");
        }
    }
}
