import java.util.Random;
import java.util.Scanner;

public class BattleEngine
{
    private String pName;       /* Player name */  
    private int pLevel;         /* Player level */
    private boolean pAlive;     /* Player is alive */
    private int pCurrentHealth; /* Player current health*/
    private int pMaxHealth;     /* Player max health */
    private int pAttack;        /* Player attack */
    private int pDefense;       /* Player defense */
    private String mName;       /* Monster name */
    private int mLevel;         /* Monster level */
    private boolean mAlive;     /* Monster is alive */
    private int mCurrentHealth; /* Monster current health */
    private int mMaxHealth;     /* Monster max health */
    private int mAttack;        /* Monster attack */
    private int mDefense;       /* Monster defense */

    private int choice = 0;     /* Holds player choice */
    private boolean valid;      /* Makes sure choice is in valid range */
    private int temp;           /* Holds misc. temp values */
    private Random randGen;

    //private double wDamage[] = {stuff};  /* weapon damage multiplier */

    public BattleEngine()
    {
        randGen = new Random();
    }

    public void battle(Player player, Location currentLoc)
    /* flow of battle */
    {
        Monster monster = battleInit(player, currentLoc);

        battleLoop();

        battleEnd(player);
    }

    public Monster battleInit(Player player, Location currentLoc)
    /* initializes battle stats */
    {
        MonsterCreator monsterCreator = new MonsterCreator();
        Monster monster;
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
        mLevel = randGen.nextInt(2)+(pLevel);

        monster = monsterCreator.Generate(mLevel, currentLoc);
        mName = monster.getName();
        mMaxHealth = monster.getMaxHealth();
        mCurrentHealth = monster.getCurrentHealth();
        mAttack = monster.getAttack();
        mDefense = monster.getDefense();
        mAlive = true;

        System.out.printf("\nYou have encountered a level %d %s!\n\n", mLevel, mName);

        return monster;
    }

    public void battleLoop()
    /* main loop for battle */
    {
        int damage;

        while((mCurrentHealth > 0) && (pCurrentHealth > 0))
        {
            damage = 0;

            printBattleHeader();

            choice = getInputInt(1,4);  /* gets user int input with min and max valid values specified */

            System.out.println();

            switch(choice)
            {
                case 1:  /* attack */
                         damage = attack(pAttack, mDefense, 'p');

                         mCurrentHealth-=damage;

                         /* temp monster turn */
                         if(mCurrentHealth > 0)
                         {
                             System.out.println();
                             damage = attack(mAttack, pDefense, 'm');
                             pCurrentHealth-=damage;
                         }

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

    public int attack(int attackerATK, int defenderDEF, char attacker)
    /* attacking engine */
    {
        int roll = 0;      /* holds value of random roll */
        int damage = 0;

        if((roll = (randGen.nextInt(20)+1)) == 1)  /* miss if roll == 1 */
        {
            if(attacker == 'p')
            {
                System.out.printf("You missed!\n");
            }
            else
            {
                System.out.printf("You dodged the attack!\n");
            }
        }
        else
        {
            double attackModifier = (double)attackerATK/4;
            double defenseModifier = (double)defenderDEF/4;
            damage = pAttack + roll;
            damage-= (int)defenseModifier;

            if(roll == 20)
            {
                damage*= 1.5;

                if(attacker == 'p')
                {
                    System.out.printf("You deliver a powerful strike, causing %d damage!\n", damage);
                }
                else
                {
                    System.out.printf("The %s delivers a powerful strike, causing %d damage!\n", mName.toLowerCase(), damage);
                }
            }
            else
            {
                if(attacker == 'p')
                {
                    System.out.printf("The strike connects, causing %d damage!\n", damage);
                }
                else
                {
                    System.out.printf("The %s hits you, causing %d damage!\n", mName.toLowerCase(), damage);
                }

            }
        }

        return damage;        
    }

    public void printBattleHeader()
    /* Prints header for each turn */
    {
            System.out.printf("%s health: %d/%d\n", pName, pCurrentHealth, pMaxHealth);
            System.out.printf("%s health: %d/%d\n\n", mName, mCurrentHealth, mMaxHealth);
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
            player.setExperience(player.getExperience()+10);
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
