import java.util.Random;

public class Player extends Entity
{
    public Player()
    {
        Random randGen = new Random();
        String name = "Default";
        int maxHealth = 20;
        int defense = 0;
        int rand;
        double damage = 0;
        double damageIncrement;

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
                damageIncrement = (randGen.nextDouble() * 2.2);
                damage += damageIncrement;
            }
        }

        damage = Math.round(damage * 4);
        damage /= 4;

        setName(name);
        setMaxHealth(maxHealth);
        setCurrentHealth(maxHealth);
        setDefense(defense);
        setDamage(damage);
        setLevel(1);
    }
}
