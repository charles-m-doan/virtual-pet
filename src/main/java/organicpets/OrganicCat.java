package organicpets;

public class OrganicCat extends OrganicPet {

	protected static final String[] PREFERRED_FOODS = { "dry food", "canned food", "chicken", "tuna", "cat treat", "fish" };

	public OrganicCat(String name)
		{
		super(name);
		this.hungerRate = 3;
		this.thirstRate = 1;
		this.boredomRate = 2;
		this.minHungerCapacity = 0;
		this.maxHungerCapacity = getValueBetweenRange(30, 60);
		this.minThirstCapacity = 0;
		this.maxThirstCapacity = getValueBetweenRange(20, 50);
		this.minBoredomCapacity = 0;
		this.maxBoredomCapacity = getValueBetweenRange(30, 100);
		this.hunger = maxHungerCapacity;
		this.thirst = maxThirstCapacity;
		this.boredom = maxBoredomCapacity;
		this.favoriteFood = determineFavoriteFood();
		}

	public String getType()
		{
		return "Cat";
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
			outputStr = name + " the " + getType() + " seems more annoyed than usual.";
			decreaseHealth(1);
			}
		if (soiled == true)
			{
			outputStr = name + " the " + getType() + " looks disgusted with its dirty cage.";
			decreaseHealth(7);
			}
		if (hunger <= 0)
			{
			outputStr = name + " the " + getType() + " meows desperately with hunger.";
			decreaseHealth(2);
			}
		if (thirst <= 0)
			{
			outputStr = name + " the " + getType() + " is weak with thirst.";
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
				hunger += 30;
				System.out.println(this.name + " purrs <3");
				}
			else
				{
				hunger += 20;
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
