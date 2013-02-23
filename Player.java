import java.util.Random;

public class Player extends Entity
{
    public Player()
    {
        //super(name);
        Random randGen = new Random();
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
                System.out.printf("maxHealth = %d\n", maxHealth);
            }
            else if(rand == 1)
            {
                defense++;
                System.out.printf("defense = %d\n", defense);
            }
            else
            {
                damageIncrement = (randGen.nextDouble() * 2.2);
                damage += damageIncrement;

                System.out.printf("damageIncrement = %f\n", damageIncrement);
            }
        }

        System.out.printf("damage = %f\n", damage);

        damage = Math.round(damage * 4);
        System.out.printf("Rounded damage = %f\n", damage);
        damage /= 4;
        System.out.printf("Divided damage = %f\n", damage);

        setMaxHealth(maxHealth);
        setDefense(defense);
        setDamage(damage);
        setLevel(1);
    }
}
