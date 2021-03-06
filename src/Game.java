import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game
{
    private MapTest map         = new MapTest();
    private Player player       = new Player();
    private Inventory inventory = new Inventory();
    private Scanner scanner     = new Scanner(System.in);
    private Random randGen      = new Random();

    Location currentLoc = map.one;

    public Game()
    {
        initialize();
    }

    public void gameLoop()
    {
        boolean encounter = false;
        boolean quit = false;
        boolean successfulMove = false; /* indicates last choice was a successful change of location */
        String userInput = "";

        while(!quit)
        {
            if(successfulMove)
            /* if last choice was to change location */
            {
                encounter = encounterGen(false);   /* rolls for chance of monster encounter */
                successfulMove = false;
            }

            if(encounter)
            /* triggers encounter if true */
            {
                encounter();
                encounter = false;
            }

            if(player.isAlive())
            {
                userInput = getUserInput(userInput);

                successfulMove = commandProcessing(userInput);
            }
            else
            {
                System.out.printf("And so ends the tale of %s\n", player.getName());
                quit = true;
            }
        }
    }

    public boolean encounterGen(boolean encounter)
    {
        int i = randGen.nextInt(100);

        if(i >= 75)
        {
            encounter = true;
        }

        return encounter;
    }

    public void encounter()
    {
         BattleEngine battleEngine = new BattleEngine();
         battleEngine.battle(player, currentLoc);
    }

    public String getUserInput(String userInput)
    /* Gets user commands */
    {
        System.out.printf("\nEnter a command:\n");
        System.out.printf("> ");

        userInput = scanner.nextLine();

        userInput = userInput.toLowerCase();         /* Makes string lower case */
        userInput = userInput.replaceAll("\\W", ""); /* Strips punctuation from string */
        System.out.println();

        return userInput;
    }

    public boolean commandProcessing(String userInput)
    /* processes user commands */
    {
       boolean successfulMove = false;

       if(userInput.startsWith("clear"))
       {
           clear();
       }
       else if(userInput.startsWith("go"))
       {
           successfulMove = go(userInput);
       }
       else if(userInput.startsWith("help"))
       {
           printHelp();
       }
       else if(userInput.startsWith("look"))
       {
           look();
       }
       else if(userInput.startsWith("open"))
       {
           open(userInput);
       }
       else if(userInput.startsWith("stats"))
       {
           stats();
       }
       else if(userInput.startsWith("inventory"))
       {
           inventory();
       }
       else if(userInput.startsWith("spawn"))
       {
           encounter();
       }
       else if(userInput.startsWith("quit"))
       {
           System.out.printf("Quitting.\n");
           System.exit(0);
       }
       else
       { 
           System.out.printf("Default case.\n");
       }

       return successfulMove;
    }

    public void initialize()
    {

        System.out.printf("Please enter your name, %s:\n> ", player.getName());
        String userName = scanner.nextLine();

        player.setName(userName);

        System.out.printf("\nThank you, %s.\n", player.getName());
    }

    /* Commands */
    public void clear()
    {
        for(int i=0; i<50; i++)
        {
            System.out.println();
        }
    }

    public boolean go(String userInput)
    {
        String direction = "";
        boolean valid = true;

        if(userInput.matches(".*north.*"))
        {
           direction = "north"; 
        }
        else if(userInput.matches(".*east.*"))
        {
           direction = "east"; 
        }
        else if(userInput.matches(".*south.*"))
        {
           direction = "south"; 
        }
        else if(userInput.matches(".*west.*"))
        {
           direction = "west"; 
        }
        else
        {
            valid = false;
        }

        if(!valid)
        {
            System.out.printf("That's not a recognized direction.\n");
        }
        else
        {
            currentLoc = move(direction);
        }

        return valid;
    }

    public Location move(String direction)
    {
        Location newLocation = currentLoc.go(direction, currentLoc);

        return newLocation;
    }

    public void printHelp()
    {
        System.out.printf("\nCommands\n");
        System.out.printf("-------------------------------------------------------------------\n");
        System.out.printf("- Clear:\t\tClears the screen.\n");
        System.out.printf("- Go <direction>\tMoves in <direction> if available.\n");
        System.out.printf("- Look:\t\t\tLooks around current location.\n");
        System.out.printf("- Open <container>:\tOpens <container>.\n");
        System.out.printf("- Stats:\t\tShows your player stats.\n");
        System.out.printf("- Inventory:\t\tShows your inventory.\n");
        System.out.printf("- Quit:\t\t\tExits the game.\n");
        System.out.println();
    }

    public void look()
    {
        currentLoc.look();
    }

    public void open(String userInput)
    {
        if(userInput.matches(".*chest.*"))
        {
            if(currentLoc.isChest())
            {
                if(currentLoc.chestIsEmpty())
                {
                    System.out.printf("The chest is empty.\n");
                }
                else
                {
                    Item item = null;

                    while(!currentLoc.chestIsEmpty())
                    {
                        item = currentLoc.getChestItem(0);

                        inventory.addItem(item);

                        System.out.printf("You got a %s!\n", item.getName());
                    }
                }
            }
        }
    }

    public void stats()
    /* Prints player stats */
    {
        System.out.printf("\nPlayer Stats\n");
        System.out.printf("--------------------------------------\n");
        System.out.printf("Name:\t  %s\n", player.getName());
        System.out.printf("Level:\t  %d\n", player.getLevel());
        System.out.printf("Exp:\t  %d\n", player.getExperience());
        System.out.printf("Gold:\t  %d\n", player.getGold());
        System.out.printf("Health:\t  %d/%d\n", player.getCurrentHealth(), player.getMaxHealth());
        System.out.printf("Attack:\t  %d\n", player.getAttack());
        System.out.printf("Def:\t  %d\n", player.getDefense());
        System.out.println();
    }

    public void inventory()
    /* Prints player's inventory */
    {
        System.out.printf("\nInventory\n");
        System.out.printf("---------------------------\n");

        inventory.printInventory();

        System.out.println();
    }
}
