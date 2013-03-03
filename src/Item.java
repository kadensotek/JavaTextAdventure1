public class Item
{
    private String itemName;
    private int itemID;

/*
 *   Health potion
 *   Poison antidote
 *   Key
 *   Health increase
 *   Defense increase
 *
 *   boolean for usable items
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
