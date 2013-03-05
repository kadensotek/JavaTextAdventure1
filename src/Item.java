public class Item
{
    private String itemName;
    private int itemID;
    private boolean usable;

/*
 *   1. Health potion
 *   2. Poison antidote
 *   3. Health increase
 *   4. Attack increase
 *   5. Defense increase
 *   6. Key
 *
 */


    public Item(int itemID)
    {
        //TO DO: Assign items for itemID
        this.itemID = itemID;
        this.itemName = "defaultItem";
    }

    //public String getName()
    public String getName()
    {
        return itemName;
    }
}
