import java.util.Random;

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
    private int choice;         /* Holds player choice */
    private int temp;           /* Holds misc. temp values */
    private Random mLevelGen;   /* generates monster level */
    private final int P_MAX_DAMAGE[] = {0,30,40,50,60,70,80,90,100,110,120,130,140,150,160}; /* max damages for player, based on level */
    private final int M_MAX_DAMAGE[] = {0,5,15,20,30,35,50,55,65,70,75,80,85};  /* max damages for monster, based on level */

    //private double wDamage[] = {stuff};  /* weapon damage multiplier */
    //private Random engine;

    public BattleEngine()
    {
        mLevelGen = new Random();
    }

    public void battle(Player player, Monster monster)
    {
        battleInit(player, monster);

        battleLoop();

        battleEnd();
    }

    public void battleInit(Player player, Monster monster)
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
            health = 50 + ((mLevel-1) * 30);
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

        System.out.printf("\nYou have encountered a level %d %s!\n", mLevel, mName);
    }    

    public void battleLoop()
    {
       System.out.printf("\nBattle begins.\n"); 
    }

    public void battleEnd()
    {
       System.out.printf("\nBattle ends.\n"); 
    }
}
