First attempt at a Java text based game


To do list:

    Container:
        Create container object

        Holds items

        Drawer, chest, etc

        Remember to hide when empty

    Map:

        Create map object

        Populate map by linking locations

    Location:

        Holds items

    Game:

        Generate map

        create command parsing

    Item:

        Add new items

        Some items can hold other items?

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
