public class Item
{
    private String itemName;
    private int itemID;
    private boolean usable;

    public Item(int itemID)
    {
        //TO DO: Assign items for itemID
        this.itemID = itemID;
        this.itemName = "defaultItem";

        if(itemID == 1)
        {
            this.itemName = "Health Potion";
            this.usable = true;
        }
        else if(itemID == 2)
        {
            this.itemName = "Antidote";
            this.usable = true;
        }
        else if(itemID == 3)
        {
            this.itemName = "Health Increase";
            this.usable = true;
        }
        else if(itemID == 4)
        {
            this.itemName = "Attack Increase";
            this.usable = true;
        }
        else if(itemID == 5)
        {
            this.itemName = "Defense Increase";
            this.usable = true;
        }
        if(itemID == 6)
        {
            this.itemName = "Key";
            this.usable = true;
        }
    }

    public void useItem(Item item)
    {
        //determines the usage of item
    }

    public int getItemID()
    {
        return this.itemID;
    }

    public String getName()
    {
        return this.itemName;
    }

    public boolean getUsable()
    {
        return this.usable;
    }
}
