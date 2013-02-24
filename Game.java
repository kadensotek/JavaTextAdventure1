import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    public ArrayList<Monster> monsterList = new ArrayList<Monster>();
    //public Map map = new Map();
    public MonsterCreator createMonster = new MonsterCreator();
    public Player player = new Player();
    public Scanner scanner = new Scanner(System.in);

    public Game()
    {
        initialize();
    }

    public void gameLoop()
    {
        boolean quit = false;
        String userInput = "";
        String userInputLowerCase = "";

        while(!quit)
        {
            userInput = getUserInput(userInput);
            userInputLowerCase = userInput.toLowerCase();

            quit = commandSwitch(userInputLowerCase, quit);
        }
    }

    public String getUserInput(String userInput)
    /* Gets user commands */
    {
        System.out.printf("\nEnter a command:\n");
        System.out.printf("> ");

        userInput = scanner.next();

        userInput = userInput.replaceAll("\\W", ""); /* Strips punctuation from string */
        System.out.println();

        return userInput;
    }

    public boolean commandSwitch(String userInputLC, boolean quit)
    /* Processes user commands with switch*/
    {
         switch(userInputLC)
         {
             case "attack":
             //              attack(player, monster);
                           attack();
                           break;
             case "clear":
                           clear();
                           break;
             case "go to": case "goto":
                           go_to();
                           break;
             case "help":
                           printHelp();
                           break;
             case "locations":
                           locations();
                           break;
             case "monsters":
                           monsters();
                           //monsters(monsterList);
                           break;
             case "stats":
                           stats(player);
                           break;
             case "quit":
                           System.out.printf("Quitting.\n");
                           quit = true;
                           break;
             default:
                           System.out.printf("Default case.\n");
                           break;
        }

        return quit;
    }

    public void initialize()
    {
        //TO DO: generate monsters

        System.out.printf("Please enter your name, %s:\n> ", player.getName());
        String userName = scanner.nextLine();

        player.setName(userName);

        System.out.printf("\nThank you, %s.\n", player.getName());
    }

    /* Commands */
    public void attack()
    {
        System.out.printf("Attacking\n");
    }

    public void clear()
    {
        System.out.printf("Clearing\n");
    }

    public void go_to()
    {
        System.out.printf("Going to <location>\n");
    }

    public void printHelp()
    {
        System.out.println("Commands");
        System.out.println("##################################");
        System.out.println("- Attack:\t\tAttack enemy.");
        System.out.println("- Clear:\t\tClears the screen.");
        System.out.println("- Go to <location>\tTakes you to <location>.");
        System.out.println("- Locations:\t\tGives you a list of locations.");
        System.out.println("- Monsters:\t\tTells you if any monsters are nearby.");
        System.out.println("- Stats:\t\tShows your player stats.");
        System.out.println("- Quit:\t\t\tExits the game.");
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
        System.out.printf("\n--------------------------------------------------------------------\n\n");
        System.out.printf("Name:\t%s\n", player.getName());
        System.out.printf("Gold:\t%d\n", player.getGold());
        System.out.printf("Health:\t%d/%d\n", player.getCurrentHealth(), player.getMaxHealth());
        System.out.printf("Damage:\t%.2f\n", player.getDamage());
        //System.out.printf("Location:\t%s\n", player.getLocation());
        //System.out.printf("Inventory:\n");
    }
}
