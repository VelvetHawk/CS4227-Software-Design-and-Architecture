package consumables.basics;

import consumables.decorators.Consumable;

public class BasicTopping implements Consumable
{
	@Override
	public String getName()
	{
		return "";
	}
	
	@Override
	public double getCost()
	{
		return 0.25;
	}
}
