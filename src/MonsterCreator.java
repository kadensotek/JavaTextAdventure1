import java.util.ArrayList;
import java.util.Random;

public class MonsterCreator
{
    Random randGen = new Random();

    public void Generate(ArrayList<Monster> monsterList)
    {
        Monster monster = new Monster();

        monster.setMaxHealth((int)GenerateHealth());
        monster.setCurrentHealth(monster.getMaxHealth());

        monster.setDefense(GenerateDefense());
        monster.setAttack(GenerateAttack());
        monster.setName(GenerateName());

        monsterList.add(monster);
    }

    private float GenerateHealth()
    {
        float health = 100;
        randGen = new Random();

        health = randGen.nextInt(100);

        return health;
    }

    private int GenerateDefense()
    {
        int defense = 1;
        randGen = new Random();

        defense = randGen.nextInt(100);

        return defense;
    }

    private double GenerateAttack()
    {
        double attack = 1;
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
