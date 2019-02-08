package consumables.basics;

import consumables.decorators.Consumable;

public class BasicFood implements Consumable
{
	@Override
	public String getName()
	{
		return "";
	}
	
	@Override
	public double getCost()
	{
		return 3.50;
	}
}
