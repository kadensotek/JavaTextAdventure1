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
            if(getNorthFlag() && !(getNorthPath().isLocked()))
            {
                System.out.printf("You go north.\n");
                location = getNorthPath();
            }
            else
            {
                System.out.printf("You can't go that way.\n");
            }
        }
        else if(direction.equals("east"))
        {
            if(getEastFlag() && !(getEastPath().isLocked()))
            {
                System.out.printf("You go east.\n");
                location = getEastPath();
            }
            else
            {
                System.out.printf("You can't go that way.\n");
            }
        }
        else if(direction.equals("south"))
        {
            if(getSouthFlag() && !(getSouthPath().isLocked()))
            {
                System.out.printf("You go south.\n");
                location = getSouthPath();
            }
            else
            {
                System.out.printf("You can't go that way.\n");
            }
        }
        else if(direction.equals("west"))
        {
            if(getWestFlag() && !(getWestPath().isLocked()))
            {
                System.out.printf("You go west.\n");
                location = getWestPath();
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
    }

    public String getName()
    {
        return this.name;
    }

    public String getType()
    {
        return this.type;
    }

    public void setLocked(boolean locked)
    {
        this.locked = locked;
    }

    public boolean isLocked()
    {
        return this.locked;
    }

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

}
