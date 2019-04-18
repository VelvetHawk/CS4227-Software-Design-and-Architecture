package consumables.basics;

import consumables.decorators.Consumable;

public class BasicSide implements Consumable
{
	@Override
	public String getName()
	{
		return "";
	}
	
	@Override
	public double getCost()
	{
		return 1.50;
	}

	@Override
	public double getStockCost()
	{
		return 1.0;
	}
}
