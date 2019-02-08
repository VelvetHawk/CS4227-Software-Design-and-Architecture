package consumables.drinks;

import consumables.Size;
import consumables.decorators.Consumable;
import consumables.decorators.DrinkDecorator;

public class PepsiMax extends DrinkDecorator
{
    public PepsiMax(Consumable parent)
    {
        super(parent);
    }

    public PepsiMax(Consumable parent, Size size)
    {
        super(parent, size);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Pepsi Max";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }
}