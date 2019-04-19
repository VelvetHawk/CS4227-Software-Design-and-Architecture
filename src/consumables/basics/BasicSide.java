package consumables.basics;

import consumables.decorators.Consumable;
import visitor.ConsumableVisitor;

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

	@Override
	public String accept(ConsumableVisitor conVisitor)
	{
		return conVisitor.visit(this);
	}

	@Override
	public Object clone()
	{
		return new BasicSide();
	}
}
