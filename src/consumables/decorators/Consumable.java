package consumables.decorators;

import visitor.ConsumableVisitor;

public interface Consumable
{
	public String getName();
	public double getCost();
	//public String getDescription();
	public String accept(ConsumableVisitor conVisitor);
}
