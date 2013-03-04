First attempt at a Java text based game


To do list:


    Map:

        Create map object

        Populate map by linking locations

    Location:

        Links to other locations

        Holds items

        Has function that describes location

        Flesh out movement code

        Add getters/setters for neswPaths.

    Game:

        move function

        Generate map

        Locations function

        Monsters function

        create command parsing

        remove attack function

    Item:

        Assign items for itemID

        Add item names corresponging to itemID

        Some items can hold other items?

        Boolean for usable items

    Monster:

        Give different creatures different attributes and attacks

        Generate experience value of enemy

    MonsterCreator:

        Pass map location to monster creator to create monsters specific to environment

        Give monsters different base stats

        Create experience reward for each monster

        Generate name first; then generate stats based on type of monster and level of player

    BattleEngine:

        Refine attack function

        Adjust defense modifier
