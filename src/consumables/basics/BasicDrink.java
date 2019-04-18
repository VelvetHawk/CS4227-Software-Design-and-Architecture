package consumables.basics;

import consumables.decorators.Consumable;

public class BasicDrink implements Consumable
{
	@Override
	public String getName()
	{
		return "";
	}
	
	@Override
	public double getCost()
	{
		return 2.00;
	}

	@Override
	public double getStockCost()
	{
		return .5;
	}
}
