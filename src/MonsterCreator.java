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
        monster.setName(GenerateName());
        monster.setMaxHealth((int)GenerateHealth());
        monster.setCurrentHealth(monster.getMaxHealth());

        monster.setDefense(GenerateDefense());
        monster.setAttack(GenerateAttack());

        return monster;
    }

    private String GenerateName()
    {
        // pass location for monster creation eventually
        String name = "MissingNo";
        int temp = randGen.nextInt(12);

        if(temp==0)
        {
            name = "Rat";
        }
        else if(temp==1)
        {
            name = "Bat";
        }
        else if(temp==2)
        {
            name = "Spider";
        }
        else if(temp==3)
        {
            name = "Slime";
        }
        else if(temp==4)
        {
            name = "Goblin";
        }
        else if(temp==5)
        {
            name = "Wolf";
        }
        else if(temp==6)
        {
            name = "Skeleton";
        }
        else if(temp==7)
        {
            name = "Zombie";
        }
        else if(temp==8)
        {
            name = "Skeleton";
        }
        else if(temp==9)
        {
            name = "Bugbear";
        }
        else if(temp==10)
        {
            name = "Troll";
        }
        else
        {
            name = "Giant";
        }

        return name;
    }

    private int GenerateHealth()
    {
        int health = 1;
        randGen = new Random();

        health = randGen.nextInt(70);

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
