package consumables.basics;

import consumables.decorators.Consumable;
import visitor.ConsumableVisitor;

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

	@Override
	public String accept( ConsumableVisitor conVisitor){
		return conVisitor.visit(this);
	}
	@Override
	public Object clone()
	{
		return new BasicDrink();
	}
}
