import java.util.ArrayList;

public class Entity
{
    private int maxHealth;
    private int currentHealth;
    private String name;
    private int level;
    private int experience;
    private int gold;
    private double attack;
    private int defense;
    private ArrayList<Item> backpack;

    public Entity()
    {
        this.maxHealth = 100;
        this.currentHealth = this.maxHealth;
        this.name = "MissingNo";
        this.gold = 0;
        this.experience = 0;
        this.backpack = new ArrayList<Item>();
    }

    public int getMaxHealth()
    {
        return this.maxHealth;
    }

    public void setMaxHealth(int newHealth)
    {
        this.maxHealth = newHealth;
    }

    public int getCurrentHealth()
    {
        return this.currentHealth;
    }

    public void setCurrentHealth(int newHealth)
    {
        this.currentHealth = newHealth;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public int getLevel()
    {
        return this.level;
    }

    public void setLevel(int newLevel)
    {
        this.level = newLevel;
    }

    public int getExperience()
    {
        return this.experience;
    }

    public void setExperience(int newExperience)
    {
        this.experience = newExperience;
    }

    public int getGold()
    {
        return this.gold;
    }

    public void setGold(int newGold)
    {
        this.gold = newGold;
    }

    public double getAttack()
    {
        return this.attack;
    }

    public void setAttack(double newAttack)
    {
        this.attack = newAttack;
    }

    public int getDefense()
    {
        return this.defense;
    }

    public void setDefense(int newDefense)
    {
        this.defense = newDefense;
    }

    public void addBackpack(Item item)
    {
        backpack.add(item);
    }

    public void removeBackpack(Item item)
    {
        backpack.remove(item);
    }

    public void attack(Entity attacker, Entity defender)
    {
        double a_Attack = attacker.getAttack();
        int d_Defense = defender.getDefense();
        int d_Health = defender.getCurrentHealth();
        int baseDefense = 100;
        double defenseFactor;

        /* damage calculations*/
        defenseFactor = 0.12 * (baseDefense + d_Defense) / 100;
        d_Health = d_Health - (int)(a_Attack * (1 - defenseFactor));		

        /* set defender health to new health */
        defender.setCurrentHealth(d_Health);
    }

    public ArrayList<Item> die()
    {
        System.out.println(this.name + " has died. Oh look, he dropped:" );

        for (Item item : this.backpack)
        {
            System.out.println(item.getName());
        }

        return this.backpack;
    }
}
