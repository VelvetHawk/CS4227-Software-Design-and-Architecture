package consumables.basics;

import consumables.decorators.Consumable;
import visitor.ConsumableVisitor;

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

	@Override
	public String accept(ConsumableVisitor conVisitor){
		String description = conVisitor.visit(this);
		return description;
	}
}
