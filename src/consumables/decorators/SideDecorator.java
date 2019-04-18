package consumables.decorators;

public abstract class SideDecorator implements Consumable
{
	// Decorator chain
	protected Consumable parent;
	
	public SideDecorator(Consumable parent)
	{
		this.parent = parent;
	}

	@Override
	public abstract Object clone();
}
