import java.util.ArrayList;

public class Inventory
{
    private boolean empty;
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Integer> number = new ArrayList<Integer>();

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
        boolean duplicate = false;
        int index = 0;

        if(isEmpty())
        {
            this.empty = false;
        }

        for(index=0; index<items.size(); index++)
        {
            if(item.getItemID() == this.items.get(index).getItemID())
            {
                this.number.set(index, this.number.get(index)+1);
                duplicate = true;
                break;
            }
        }

        if(duplicate==false)
        {
            this.items.add(item);
            this.number.add(1);
        }
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
                if(number.get(i)==1)
                {
                    System.out.printf("%d: %s\n", i+1, items.get(i).getName());
                }
                else
                {
                    System.out.printf("%d: %s x%d\n", i+1, items.get(i).getName(), number.get(i));
                }
            }
        }
        else
        {
            System.out.printf("Inventory is empty.\n");
        }
    }
}
