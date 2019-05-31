package organicpets;

public class OrganicDog extends OrganicPet {

	protected static final String[] PREFERRED_FOODS = { "dry food", "canned food", "chicken", "beef", "dog treat", "bone" };

	public OrganicDog(String name)
		{
		super(name);
		this.hungerRate = 5;
		this.thirstRate = 5;
		this.boredomRate = 7;
		this.minHungerCapacity = 0;
		this.maxHungerCapacity = getValueBetweenRange(50, 90);
		this.minThirstCapacity = 0;
		this.maxThirstCapacity = getValueBetweenRange(50, 90);
		this.minBoredomCapacity = 0;
		this.maxBoredomCapacity = getValueBetweenRange(70, 100);
		this.hunger = maxHungerCapacity;
		this.thirst = maxThirstCapacity;
		this.boredom = maxBoredomCapacity;
		this.favoriteFood = determineFavoriteFood();
		}

	public String getType()
		{
		return "Dog";
		}

	public void tick()
		{
		decreaseHunger(hungerRate);
		decreaseThirst(thirstRate);
		decreaseBoredom(boredomRate);
		decreaseTicksUntilSoiled();
		decreaseHealth(healthRate);
		String outputStr = null;
		if (boredom <= 0)
			{
			outputStr = name + " the " + getType() + " is extremely restless.";
			decreaseHealth(2);
			}
		if (soiled == true)
			{
			outputStr = name + " the " + getType() + " seems unhappy with its dirty cage.";
			decreaseHealth(5);
			}
		if (hunger <= 0)
			{
			outputStr = name + " the " + getType() + " woofs and licks its lips with hunger.";
			decreaseHealth(2);
			}
		if (thirst <= 0)
			{
			outputStr = name + " the " + getType() + " is panting with thirst.";
			decreaseHealth(1);
			}
		if (outputStr != null)
			{
			System.out.println(outputStr);
			}
		}

	protected boolean foodIsAmongPreferredFoods(String selectedFood)
		{
		for (int i = 0; i < PREFERRED_FOODS.length; i++)
			{
			if (selectedFood.equals(PREFERRED_FOODS[i]))
				{
				return true;
				}
			}
		return false;
		}

	public void feed(String selectedFood)
		{
		if (foodIsAmongPreferredFoods(selectedFood))
			{
			if (selectedFood.equals(favoriteFood))
				{
				hunger += 40;
				System.out.println(this.name + " says: woof! <3");
				}
			else
				{
				hunger += 30;
				}
			}
		else
			{
			System.out.println(this.name + " doesn't like " + selectedFood);
			}
		if (hunger >= maxHungerCapacity)
			{
			hunger = maxHungerCapacity;
			}
		}

	public static String[] getPreferredFoods()
		{
		return PREFERRED_FOODS;
		}

	protected static String determineFavoriteFood()
		{
		return PREFERRED_FOODS[getValueBetweenRange(0, PREFERRED_FOODS.length - 1)];
		}
}
