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
        monster.setMaxHealth((int)GenerateHealth());
        monster.setCurrentHealth(monster.getMaxHealth());

        monster.setDefense(GenerateDefense());
        monster.setAttack(GenerateAttack());
        monster.setName(GenerateName());

        return monster;
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

    private String GenerateName()
    {
        String name = "MissingNo";
        int temp = randGen.nextInt(15);

        if(temp <= 5)
        {
            name = "Bugbear";
        }
        else if(temp > 5 && temp <= 10)
        {
            name = "Goblin";
        }
        else
        {
            name = "Troll";
        }

        return name;
    }
}
