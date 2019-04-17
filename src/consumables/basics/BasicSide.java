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
	public String accept(ConsumableVisitor conVisitor){
		String description = conVisitor.visit(this);
		return description;
	}
}
