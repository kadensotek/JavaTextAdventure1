import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    public ArrayList<Monster> monsterList = new ArrayList<Monster>();
    //public Map map = new Map();
    public MonsterCreator createMonster = new MonsterCreator();
    public Player player = new Player();
    public Scanner scanner = new Scanner(System.in);
    public Monster monster;

    public Game()
    {
        initialize();
    }

    public void gameLoop()
    {
        boolean quit = false;
        String userInput = "";

        while(!quit)
        {
            userInput = getUserInput(userInput);

            quit = commandProcessing(userInput, quit);
        }
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

    public boolean commandProcessing(String userInput, boolean quit)
    /* processes user commands */
    {

       if(userInput.startsWith("attack"))
       {
           attack(player, monster);
       }
       else 

       if(userInput.startsWith("clear"))
       {
           clear();
       }
       else if(userInput.startsWith("go"))
       {
           go(userInput);
       }
       else if(userInput.startsWith("help"))
       {
           printHelp();
       }
       else if(userInput.startsWith("look"))
       {
           look();
       }
       else if(userInput.startsWith("locations"))
       {
           locations();
       }
       else if(userInput.startsWith("monsters"))
       {
           monsters();
           //monsters(monsterList);
       }
       else if(userInput.startsWith("stats"))
       {
           stats(player);
       }
       else if(userInput.startsWith("quit"))
       {
           System.out.printf("Quitting.\n");
           quit = true;
       }
       else
       { 
           System.out.printf("Default case.\n");
       }

       return quit;
    }

    public void initialize()
    {
        //TO DO: generate monsters
        createMonster.Generate(monsterList);

        monster = monsterList.get(0);

        System.out.printf("Please enter your name, %s:\n> ", player.getName());
        String userName = scanner.nextLine();

        player.setName(userName);

        System.out.printf("\nThank you, %s.\n", player.getName());
    }

    /* Commands */
    public void attack(Entity player, Entity monster)
    {
        System.out.println("----------------------------------");

	System.out.println("p_damage: " + player.getDamage());
	System.out.println("m_armour: " + monster.getDefense());

	System.out.println("mh_before: " + monster.getCurrentHealth());
	player.attack(player, monster);
	System.out.println("mh_after: " + monster.getCurrentHealth());

	System.out.println("----------------------------------");

	System.out.println("----------------------------------");

	System.out.println("m_damage: " + monster.getDamage());
	System.out.println("p_armour: " + player.getDefense());

	System.out.println("ph_before: " + player.getCurrentHealth());
	monster.attack(monster, player);
	System.out.println("ph_after: " + player.getCurrentHealth());

	System.out.println("----------------------------------");
    }

    public void clear()
    {
        for(int i=0; i<50; i++)
        {
            System.out.println();
        }
    }

    public void go(String userInput)
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
            move(direction);
        }
    }

    public void move(String direction)
    {
        System.out.printf("Moving %s\n", direction);
    }

    public void printHelp()
    {
        System.out.printf("\nCommands\n");
        System.out.printf("-------------------------------------------------------------------\n");
        System.out.printf("- Attack:\t\tAttack enemy.\n");
        System.out.printf("- Clear:\t\tClears the screen.\n");
        System.out.printf("- Go <direction>\tMoves in <direction> if available.\n");
        System.out.printf("- Look:\t\tLooks around current location.\n");
        System.out.printf("- Locations:\t\tGives you a list of locations.\n");
        System.out.printf("- Monsters:\t\tTells you if any monsters are nearby.\n");
        System.out.printf("- Stats:\t\tShows your player stats.\n");
        System.out.printf("- Quit:\t\t\tExits the game.\n");
        System.out.println();
    }

    public void look()
    {
        System.out.printf("Looking.\n");
    }

    public void locations()
    {
        System.out.printf("Locations\n");
    }

    public void monsters()
    //public void monsters(ArrayList<Monster> monsterList)
    {
        System.out.printf("Monsters\n");
    }

    public void stats(Player player)
    {
        System.out.printf("\nPlayer Stats\n");
        System.out.printf("--------------------------------------\n");
        System.out.printf("Name:\t  %s\n", player.getName());
        System.out.printf("Level:\t  %d\n", player.getLevel());
        System.out.printf("Exp:\t  %d\n", player.getExperience());
        System.out.printf("Gold:\t  %d\n", player.getGold());
        System.out.printf("Health:\t  %d/%d\n", player.getCurrentHealth(), player.getMaxHealth());
        System.out.printf("Damage:\t  %.2f\n", player.getDamage());
        System.out.printf("Def:\t  %d\n", player.getDefense());
        //System.out.printf("Location:\t%s\n", player.getLocation());
        //System.out.printf("Inventory:\n");
        System.out.println();
    }
}
