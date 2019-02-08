package consumables.drinks;

import consumables.Size;
import consumables.decorators.Consumable;
import consumables.decorators.DrinkDecorator;

public class CocaCola extends DrinkDecorator
{
    public CocaCola(Consumable parent)
    {
        super(parent);
    }

    public CocaCola(Consumable parent, Size size)
    {
        super(parent, size);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Coca Cola";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }
}