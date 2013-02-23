import java.util.ArrayList;

public class Entity
{
    private int maxHealth;
    private int currentHealth;
    private String name;
    private int level;
    private int gold;
    private double damage;
    private int armor;
    private ArrayList<Item> backpack;

    public Entity()
    {
        this.maxHealth = 100;
        this.currentHealth = this.maxHealth;
        this.name = "initialized";
        this.gold = 0;
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

    public int getGold()
    {
        return this.gold;
    }

    public void setGold(int newGold)
    {
        this.gold = newGold;
    }

    public double getDamage()
    {
        return this.damage;
    }

    public void setDamage(double newDamage)
    {
        this.damage = newDamage;
    }

    public int getArmor()
    {
        return this.armor;
    }

    public void setArmor(int newArmor)
    {
        this.armor = newArmor;
    }

    public void addBackpack(Item item)
    {
        backpack.add(item);
    }

    public void removeBackpack(Item item)
    {
        backpack.remove(item);
    }

    //attacks

    //dies
}
