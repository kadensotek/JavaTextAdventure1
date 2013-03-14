First attempt at a Java text based game


To do list:

    Container:

        Drawer, chest, etc

    Map:

        Create map object

        Populate map by linking locations

    Location:

        Holds items

        Add unlockable doors

    Inventory idea:

       Combine items if duplicate

       Create parallel list to hold number of items in inventory

           Decrement amount if amount > 1 or remove item if amount == 1

    Game:

        create command parsing

    Item:

        Add new items

        Give items a use

        Implement key to open locked areas

    Monster:

        Give different creatures different attributes and attacks

        Generate experience value of enemy

    MonsterCreator:

        Give monsters different base stats

        Create experience reward for each monster

        Generate name first; then generate stats based on type of monster and level of player

    BattleEngine:

        Refine attack function

        Adjust defense modifier

        Remove auto level up
