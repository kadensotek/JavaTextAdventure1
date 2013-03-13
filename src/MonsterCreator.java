import java.util.ArrayList;
import java.util.Random;

public class MonsterCreator
{
    Random randGen = new Random();

    public Monster Generate(int level, Location currentLoc)
    {
        // generate random monster based on location and level
        // all stats should be based on level

        Monster monster = new Monster();

        monster.setLevel(level);
        monster = GenerateMonster(monster, currentLoc);
        monster.setMaxHealth((int)GenerateHealth(monster.getLevel())); /* uses level to calculate health*/
        monster.setCurrentHealth(monster.getMaxHealth());

        monster.setDefense(GenerateDefense());
        monster.setAttack(GenerateAttack());

        return monster;
    }

    private Monster GenerateMonster(Monster monster, Location currentLoc)
    {
        String name = "MissingNo";
        String choice = "";
        int max = 3;   /* sets default max of random generator */
        int temp;      /* stores temp value for choosing monster */

        if(currentLoc.getType().equals("forest"))
        {
            temp = randGen.nextInt(max);

            if(temp==0)
            {
                choice = "spider";
            }
            else if(temp==1)
            {
                choice = "wolf";
            }
            else
            {
                choice = "bandit";
            }
        }
        else if(currentLoc.getType().equals("swamp"))
        {
            temp = randGen.nextInt(max);

            if(temp==0)
            {
                choice = "slime";
            }
            else if(temp==1)
            {
                choice = "zombie";
            }
            else
            {
                choice = "skeleton";
            }
        }
        else if(currentLoc.getType().equals("town"))
        {
            temp = randGen.nextInt(max);

            if(temp==0)
            {
                choice = "rat";
            }
            else if(temp==1)
            {
                choice = "bandit";
            }
            else
            {
                choice = "spider";
            }
        }
        else if(currentLoc.getType().equals("cave"))
        {
            max = 4;    /* four monsters to choose from here */
            temp = randGen.nextInt(max);

            if(temp==0)
            {
                choice = "troll";
            }
            else if(temp==1)
            {
                choice = "bugbear";
            }
            else if(temp==2)
            {
                choice = "goblin";
            }
            else
            {
                choice = "bat";
            }
        }
        else if(currentLoc.getType().equals("desert"))
        {
            temp = randGen.nextInt(max);

            if(temp==0)
            {
                choice = "nomad";
            }
            else if(temp==1)
            {
                choice = "spider";
            }
            else
            {
                choice = "giant";
            }
        }
        else if(currentLoc.getType().equals("mountain"))
        {
            temp = randGen.nextInt(max);

            if(temp==0)
            {
                choice = "troll";
            }
            else if(temp==1)
            {
                choice = "giant";
            }
            else
            {
                choice = "bandit";
            }
        }
        else
        {
            System.out.printf("Invalid location.\n");
        }


        if(choice.equals("rat"))
        {
            monster.setName("Rat");
        }
        else if(choice.equals("bat"))
        {
            monster.setName("Bat");
        }
        else if(choice.equals("spider"))
        {
            monster.setName("Spider");
        }
        else if(choice.equals("slime"))
        {
            monster.setName("Slime");
        }
        else if(choice.equals("goblin"))
        {
            monster.setName("Goblin");
        }
        else if(choice.equals("wolf"))
        {
            monster.setName("Wolf");
        }
        else if(choice.equals("skeleton"))
        {
            monster.setName("Skeleton");
        }
        else if(choice.equals("zombie"))
        {
            monster.setName("Zombie");
        }
        else if(choice.equals("bugbear"))
        {
            monster.setName("Bugbear");
        }
        else if(choice.equals("troll"))
        {
            monster.setName("Troll");
        }
        else if(choice.equals("bandit"))
        {
            monster.setName("Bandit");
        }
        else if(choice.equals("nomad"))
        {
            monster.setName("Nomad");
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
