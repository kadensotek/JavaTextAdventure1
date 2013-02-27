import java.util.Random;
import java.util.Scanner;

public class BattleEngine
{
    private String pName;       /* Player name */  
    private int pLevel;         /* Player level */
    private boolean pAlive;     /* Player is alive */
    private int pCurrentHealth; /* Player current health*/
    private int pMaxHealth;     /* Player max health */
    private double pAttack;     /* Player attack */
    private int pDefense;       /* Player defense */
    private String mName;       /* Monster name */
    private int mLevel;         /* Monster level */
    private boolean mAlive;     /* Monster is alive */
    private int mCurrentHealth; /* Monster current health */
    private int mMaxHealth;     /* Monster max health */
    private double mAttack;     /* Monster attack */
    private int mDefense;       /* Monster defense */

    private int damage;         /* Holds damage done by attack */ 
    private int choice = 0;     /* Holds player choice */
    private boolean valid;      /* Makes sure choice is in valid range */
    private int temp;           /* Holds misc. temp values */
    private Random mLevelGen;   /* Generates monster level */
    private final int P_MAX_DAMAGE[] = {0,30,40,50,60,70,80,90,100,110,120,130,140,150,160}; /* max damages for player, based on level */
    private final int M_MAX_DAMAGE[] = {0,5,15,20,30,35,50,55,65,70,75,80,85};  /* max damages for monster, based on level */

    //private double wDamage[] = {stuff};  /* weapon damage multiplier */
    //private Random engine;

    public BattleEngine()
    {
        mLevelGen = new Random();
    }

    public void battle(Player player, Monster monster)
    /* flow of battle */
    {
        battleInit(player, monster);

        battleLoop();

        battleEnd(player);
    }

    public void battleInit(Player player, Monster monster)
    /* initializes battle stats */
    {
        int health;

        /* Sets player stats */
        pName = player.getName();
        pLevel = player.getLevel();
        pAlive = true;
        pCurrentHealth = player.getCurrentHealth();
        pMaxHealth = player.getMaxHealth();
        pAttack = player.getAttack();
        pDefense = player.getDefense();
        
        /* Sets monster stats */
        mName = monster.getName();
        mLevel = mLevelGen.nextInt(2)+(pLevel);

        if(mLevel != 1)
        {
            health = 50 + ((mLevel-1) * 20);
        }
        else
        {
            health = 50;
        }

        mAlive = true;
        mCurrentHealth = health;
        mMaxHealth = health;
        mAttack = monster.getAttack();
        mDefense = monster.getDefense();

        System.out.printf("\nYou have encountered a level %d %s!\n\n", mLevel, mName);
    }

    public void battleLoop()
    /* main loop for battle */
    {
        while((mCurrentHealth > 0) && (pCurrentHealth > 0))
        {
            printBattleHeader();

            choice = getInputInt(1,4);  /* gets user int input with min and max valid values specified */

            System.out.println();

            switch(choice)
            {
                case 1:  /* attack */
                         if(pCurrentHealth > 0)  mCurrentHealth-=20;
                         if(mCurrentHealth > 0)  pCurrentHealth-=20;
                         break;
                case 2:  /* defend */
                         System.out.printf("You defend.\n%s defends.\n", mName);
                         break;
                case 3:  /* item */
                         System.out.printf("You use item.\n%s defends.\n", mName);
                         break;
                case 4:  /* flee */
                         System.out.printf("You can't escape.\n");
                         break;
            }

            System.out.println();


        }
    }

    public void printBattleHeader()
    /* Prints header for each turn */
    {
            System.out.printf("%s health: %d/%d\n", pName, pCurrentHealth, pMaxHealth);
            System.out.printf("%s health: %d/%d\n", mName, mCurrentHealth, mMaxHealth);
            System.out.printf("What do you want to do?\n");
            System.out.printf("1. Attack\t2. Defend\n");
            System.out.printf("3. Item\t\t4. Flee\n");
            System.out.printf("> ");
    }

    public void battleEnd(Player player)
    /* wraps battle up after player or monster is slain */
    {
        if(mCurrentHealth<=0)
        {
            player.setCurrentHealth(pCurrentHealth);
            player.setExperience(10);
            System.out.printf("%s has been defeated!\n", mName);
            player.levelUp();
        }
        else
        {
            System.out.printf("%s has been slain.\n", pName);
            player.setAlive(false);
        }
    }

    public int getInputInt(int min, int max)
    /* gets user input interger for choice; specifies min and max valid values */
    {
        Scanner scanner = new Scanner(System.in);
        int ch = 0;
        String input = "";

        while(!input.matches("-?\\d+"))
        {
            input = scanner.nextLine();

            if(!input.matches("-?\\d+"))
            {
                System.out.printf("Please select again:\n> ");
            }
            else
            {
                ch = Integer.parseInt(input);

                valid = verifyChoice(ch, min, max);

                if(!valid)   /* resets string if invalid choice is made */
                {
                    input = "";
                    System.out.printf("Please select again:\n> ");
                }
            }
        }

        return ch;
    }

    public boolean verifyChoice(int ch, int min, int max)
    /* verifies that chosen int is within specified range */
    {
        boolean validChoice = false;

        if((ch >= min) && (ch <= max))
        {
            validChoice = true;
        }
        else
        {
            validChoice = false;
        }

        return validChoice;
    }
}
