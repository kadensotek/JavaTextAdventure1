public class Location
{
    // To add
    // function to describe location
    // items like chests and drawers (possibly create a container class like backpack?"

    private String name;    /* holds name of location */
    private String type;    /* holds type of location (ex. swamp, forest, etc) */
    private boolean locked;  /* determines if location is open or not */
    private boolean northFlag;  /* flags determine if path exists */
    private boolean eastFlag;
    private boolean southFlag;
    private boolean westFlag;
    private Location northPath;  /* for potential paths */
    private Location eastPath;
    private Location southPath;
    private Location westPath;
    private Chest chest;
    private boolean isChest;

    public Location(String name, String type)
    {
        this.name = name;
        this.type = type;
        this.locked = false;

        this.northFlag = false;
        this.eastFlag = false;
        this.southFlag = false;
        this.westFlag = false;

        this.northPath = null;
        this.eastPath = null;
        this.southPath = null;
        this.westPath = null;

        this.chest = null;
        this.isChest = false;
    }

    public void addConnection(char direction, Location location)
    /* adds connections between location, setting flags as needed */
    {
        if(direction == 'n')
        {
            setNorthPath(location);
            setNorthFlag(true);
        }
        else if(direction == 'e')
        {
            setEastPath(location);
            setEastFlag(true);
        }
        else if(direction == 's')
        {
            setSouthPath(location);
            setSouthFlag(true);
        }
        else if(direction == 'w')
        {
            setWestPath(location);
            setWestFlag(true);
        }
        else
        {
            ; // Not a valid direction to add
        }
    }

    public Location go(String direction, Location currentLocation)
    /* returns the new location for movement */
    {
        Location location = currentLocation;

        if(direction.equals("north"))
        {
            if(getNorthFlag() && !(getNorthPath().isLocked()))  /* if path exists and is not locked */
            {
                System.out.printf("You go north.\n");
                location = getNorthPath();
            }
            else if(getNorthFlag() && getNorthPath().isLocked())      /* if path exists but is locked */
            {
                System.out.printf("The way is blocked.\n");
            }
            else
            {
                System.out.printf("You can't go that way.\n");   /* if path does not exist */
            }
        }
        else if(direction.equals("east"))
        {
            if(getEastFlag() && !(getEastPath().isLocked()))  /* if path exists and is not locked */
            {
                System.out.printf("You go east.\n");
                location = getEastPath();
            }
            else if(getEastFlag() && getEastPath().isLocked())      /* if path exists but is locked */
            {
                System.out.printf("The way is blocked.\n");
            }
            else
            {
                System.out.printf("You can't go that way.\n");
            }
        }
        else if(direction.equals("south"))
        {
            if(getSouthFlag() && !(getSouthPath().isLocked()))  /* if path exists and is not locked */
            {
                System.out.printf("You go south.\n");
                location = getSouthPath();
            }
            else if(getSouthFlag() && getSouthPath().isLocked())      /* if path exists but is locked */
            {
                System.out.printf("The way is blocked.\n");
            }
            else
            {
                System.out.printf("You can't go that way.\n");
            }
        }
        else if(direction.equals("west"))
        {
            if(getWestFlag() && !(getWestPath().isLocked()))  /* if path exists and is not locked */
            {
                System.out.printf("You go west.\n");
                location = getWestPath();
            }
            else if(getWestFlag() && getWestPath().isLocked())      /* if path exists but is locked */
            {
                System.out.printf("The way is blocked.\n");
            }
            else
            {
                System.out.printf("You can't go that way.\n");
            }
        }
        else
        {
            System.out.printf("That's not a valid direction.\n");
        }

        return location;
    }

    public void look()
    {
        System.out.printf("Location name: %s\n", getName());
        System.out.printf("You are in a %s.\n", getType());

        if(getNorthFlag())
        {
            System.out.printf("There is a path to the north.\n");
        }

        if(getEastFlag())
        {
            System.out.printf("There is a path to the east.\n");
        }

        if(getSouthFlag())
        {
            System.out.printf("There is a path to the south.\n");
        }

        if(getWestFlag())
        {
            System.out.printf("There is a path to the west.\n");
        }

        if(isChest())
        {
            if(!chest.isEmpty())
            {
                System.out.printf("There is a full chest.\n");  /* Change when items are added. */
            }
            else
            {
                System.out.printf("There is an open chest.\n");
            }
        }

    }

    public String getName()
    {
        return this.name;
    }

    public String getType()
    {
        return this.type;
    }


   /********************************************
    *                                          *
    *  Functions related to locked locations   *
    *                                          *
    ********************************************/
    public void setLocked(boolean locked)
    {
        this.locked = locked;
    }

    public boolean isLocked()
    {
        return this.locked;
    }


   /*************************************************
    *                                               *
    *  Functions related to setting/getting paths   *
    *                                               *
    *************************************************/
    public void setNorthPath(Location location)
    {
        this.northPath = location;
    }

    public Location getNorthPath()
    {
        return this.northPath;
    }

    public void setEastPath(Location location)
    {
        this.eastPath = location;
    }

    public Location getEastPath()
    {
        return this.eastPath;
    }

    public void setSouthPath(Location location)
    {
        this.southPath = location;
    }

    public Location getSouthPath()
    {
        return this.southPath;
    }

    public void setWestPath(Location location)
    {
        this.westPath = location;
    }

    public Location getWestPath()
    {
        return this.westPath;
    }


   /**************************************
    *                                    *
    *  Functions related to path flags   *
    *                                    *
    **************************************/
    public void setNorthFlag(boolean northFlag)
    {
       this.northFlag = northFlag;
    }

    public boolean getNorthFlag()
    {
        return this.northFlag;
    }

    public void setEastFlag(boolean eastFlag)
    {
        this.eastFlag = eastFlag;
    }

    public boolean getEastFlag()
    {
        return this.eastFlag;
    }

    public void setSouthFlag(boolean southFlag)
    {
        this.southFlag = southFlag;
    }

    public boolean getSouthFlag()
    {
        return this.southFlag;
    }

    public void setWestFlag(boolean westFlag)
    {
        this.westFlag = westFlag;
    }

    public boolean getWestFlag()
    {
        return this.westFlag;
    }


   /**********************************
    *                                *
    *  Functions related to chests   *
    *                                *
    **********************************/
    public boolean isChest()
    {
        return this.isChest;
    }

    public void setIsChest(boolean isChest)
    {
        this.isChest = isChest;
    }

    public boolean chestIsEmpty()
    {
        return this.chest.isEmpty();
    }

    public void addChest()
    {
        this.chest = new Chest();
        this.isChest = true;
    }

    public void addChestItem(int itemID)
    {
        this.chest.addItem(itemID);
    }

    public Item getChestItem(int index)
    {
        Item item = this.chest.getItem(index);
        return item;
    }
}
