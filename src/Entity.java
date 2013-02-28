import java.util.ArrayList;

public class Entity
{
    private boolean alive;
    private int maxHealth;
    private int currentHealth;
    private String name;
    private int level;
    private int experience;
    private int gold;
    private int attack;
    private int defense;
    private ArrayList<Item> backpack;

    public Entity()
    {
        this.alive = true;
        this.maxHealth = 100;
        this.currentHealth = this.maxHealth;
        this.name = "MissingNo";
        this.gold = 0;
        this.experience = 0;
        this.backpack = new ArrayList<Item>();
    }

    public boolean isAlive()
    {
        return this.alive;
    }

    public void setAlive(boolean state)
    {
       this.alive = state;
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

    public int getAttack()
    {
        return this.attack;
    }

    public void setAttack(int newAttack)
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

    public ArrayList<Item> die()
    {
        this.setAlive(false);

        System.out.println(this.name + " has died. Oh look, he dropped:" );

        for (Item item : this.backpack)
        {
            System.out.println(item.getName());
        }

        return this.backpack;
    }
}
