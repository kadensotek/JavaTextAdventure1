public class Location
{
    // used as nodes on map
    // links to other locations
    // function to describe location
    // items like chests and drawers (possibly create a container class like backpack?"

    private String name;
    private String type;
    private boolean northFlag;
    private boolean eastFlag;
    private boolean southFlag;
    private boolean westFlag;

    public Location(String name, String type)
    {
        this.name = name;
        this.type = type;
    }

    public void addConnection()
    {
        //set boolean for direction
        //add connection in given direction
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
