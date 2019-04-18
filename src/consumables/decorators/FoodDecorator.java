package consumables.decorators;

import consumables.Size;

import javax.jws.Oneway;

public abstract class FoodDecorator implements Consumable
{
	// Decorator chain
	protected Consumable parent;
	protected Size size;

	public FoodDecorator(Consumable parent)
	{
		this.parent = parent;
		size = Size.SMALL; // Default
	}
	
	public FoodDecorator(Consumable parent, Size size)
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
    public abstract Object clone();
}
