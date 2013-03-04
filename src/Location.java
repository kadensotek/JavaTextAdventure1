public class Location
{
    // used as nodes on map
    // links to other locations
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

    /* possbily add getters and setters for path direction */

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
            this.northPath = location;
            this.northFlag = true;
        }
        else if(direction == 'e')
        {
            this.eastPath = location;
            this.eastFlag = true;
        }
        else if(direction == 's')
        {
            this.southPath = location;
            this.southFlag = true;
        }
        else if(direction == 'w')
        {
            this.westPath = location;
            this.westFlag = true;
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
            location = this.northPath;
        }
        else if(direction.equals("east")
        {
            location = this.eastPath;
        }
        else if(direction.equals("south")
        {
            location = this.southPath;
        }
        else if(direction.equals("west")
        {
            location = westPath;
        }

        return location;
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
