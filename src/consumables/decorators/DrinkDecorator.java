package consumables.decorators;

import consumables.Size;

public abstract class DrinkDecorator implements Consumable
{
	// Decorator chain
	protected Consumable parent;
	protected Size size;
	
	public DrinkDecorator(Consumable parent)
	{
		this.parent = parent;
		size = Size.SMALL; // Default
	}
	
	public DrinkDecorator(Consumable parent, Size size)
	{
		this.parent = parent;
		this.size = size;
	}
	
	public Size getSize()
	{
		return size;
	}
	
	public void setSize(Size size)
	{
		this.size = size;
	}
	
	@Override
	public abstract String getName();
	
	@Override
	public abstract double getCost();
}
