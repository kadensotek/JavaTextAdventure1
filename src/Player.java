import java.util.Random;

public class Player extends Entity
{
    public Player()
    {
        Random randGen = new Random();
        String name = "Stranger";
        boolean alive = true;
        int rand;
        int maxHealth = 20;
        int defense = 0;
        int experience = 0;
        double attack = 0;
        double attackIncrement;

        for(int i=0; i<120; i++)
        {
            rand = randGen.nextInt(3);

            if(rand == 0)
            {
                maxHealth++;
            }
            else if(rand == 1)
            {
                defense++;
            }
            else
            {
                attackIncrement = (randGen.nextDouble() * 2.2);
                attack += attackIncrement;
            }
        }

        attack = Math.round(attack * 4);
        attack /= 4;

        setName(name);
        setAlive(true);
        setMaxHealth(maxHealth);
        setCurrentHealth(maxHealth);
        setDefense(defense);
        setAttack(attack);
        setLevel(1);
    }

    public void levelUp()
    {
        Random randGen = new Random();
        int attackGain = randGen.nextInt(10)+5;
        int defenseGain = randGen.nextInt(10)+5;
        int maxHealthGain = randGen.nextInt(25)+10;

        setLevel(getLevel()+1);
        setAttack(getAttack()+attackGain);
        setDefense(getDefense()+defenseGain);
        setMaxHealth(getMaxHealth()+maxHealthGain);
        setCurrentHealth(getMaxHealth());

        System.out.printf("\nYou reached level %d!\n", getLevel());
        System.out.printf("Attack:  %.2f\n", getAttack());
        System.out.printf("Defense: %d\n", getDefense());
        System.out.printf("Health:  %d/%d\n", getCurrentHealth(), getMaxHealth());
        System.out.println();
         
    }
}
