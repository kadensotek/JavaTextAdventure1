import java.util.ArrayList;
import java.util.Random;

public class MonsterCreator
{
    Random randGen = new Random();

    public Monster Generate(int level)
    {
        // generate random monster based on location and level
        // all stats should be based on level

        Monster monster = new Monster();

        monster.setLevel(level);
        monster = GenerateMonster(monster);
        monster.setMaxHealth((int)GenerateHealth(monster.getLevel())); /* uses level to calculate health*/
        monster.setCurrentHealth(monster.getMaxHealth());

        monster.setDefense(GenerateDefense());
        monster.setAttack(GenerateAttack());

        return monster;
    }

    private Monster GenerateMonster(Monster monster)
    {
        // pass location for monster creation eventually
        String name = "MissingNo";
        int temp = randGen.nextInt(12);

        if(temp==0)
        {
            monster.setName("Rat");
        }
        else if(temp==1)
        {
            monster.setName("Bat");
        }
        else if(temp==2)
        {
            monster.setName("Spider");
        }
        else if(temp==3)
        {
            monster.setName("Slime");
        }
        else if(temp==4)
        {
            monster.setName("Goblin");
        }
        else if(temp==5)
        {
            monster.setName("Wolf");
        }
        else if(temp==6)
        {
            monster.setName("Skeleton");
        }
        else if(temp==7)
        {
            monster.setName("Zombie");
        }
        else if(temp==8)
        {
            monster.setName("Skeleton");
        }
        else if(temp==9)
        {
            monster.setName("Bugbear");
        }
        else if(temp==10)
        {
            monster.setName("Troll");
        }
        else
        {
            monster.setName("Giant");
        }

        return monster;
    }

    private int GenerateHealth(int level)
    {
        int health = 1;

        if(level != 1)
        {
            health = 25 + ((level-1) * 20);
        }
        else
        {
            health = 25;
        }

        return health;
    }

    private int GenerateDefense()
    {
        int defense = 1;
        randGen = new Random();

        defense = randGen.nextInt(100);

        return defense;
    }

    private int GenerateAttack()
    {
        int attack = 1;
        randGen = new Random();

        attack = randGen.nextInt(100);

        return attack;
    }
}
