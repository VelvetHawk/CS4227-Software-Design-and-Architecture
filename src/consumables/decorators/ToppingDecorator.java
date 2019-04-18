package consumables.decorators;

public abstract class ToppingDecorator implements Consumable
{
	// Decorator chain
	protected Consumable parent;
	
	public ToppingDecorator(Consumable parent)
	{
		this.parent = parent;
	}

	@Override
	public abstract Object clone();
}
