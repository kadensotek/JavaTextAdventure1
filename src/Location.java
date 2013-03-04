public class Location
{
    // To add
    // function to describe location
    // items like chests and drawers (possibly create a container class like backpack?"

    private String name;    /* holds name of location */
    private String type;    /* holds type of location (ex. swamp, forest, etc) */
    //private boolean isLocked;  /* determines if location is open or not */
    private boolean northFlag;  /* flags determine if path exists */
    private boolean eastFlag;
    private boolean southFlag;
    private boolean westFlag;
    private Location northPath;  /* for potential paths */
    private Location eastPath;
    private Location southPath;
    private Location westPath;

    public Location(String name, String type, boolean locked)
    {
        this.name = name;
        this.type = type;
        this.isLocked = locked;

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

    public Location go(String direction)
    /* returns the new location for movement */
    {
        Location location = null;

        if(direction.equals("north")
        {
            location = getNorthPath();
        }
        else if(direction.equals("east")
        {
            location = getEastPath();
        }
        else if(direction.equals("south")
        {
            location = getSouthPath();
        }
        else if(direction.equals("west")
        {
            location = getWestPath();
        }

        return location;
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

    public void setWestFlag(boolean WestFlag)
    {
        this.westFlag = westFlag;
    }

    public boolean getWestFlag()
    {
        return this.westFlag;
    }

}
