package consumables.decorators;

import visitor.ConsumableVisitor;

public interface Consumable extends Cloneable
{
	public String getName();
	public double getCost();
	public double getStockCost();
	//public String getDescription();
	public String accept(ConsumableVisitor conVisitor);
	public Object clone() throws CloneNotSupportedException;
}
