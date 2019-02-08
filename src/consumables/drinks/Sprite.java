package consumables.drinks;

import consumables.Size;
import consumables.decorators.Consumable;
import consumables.decorators.DrinkDecorator;

public class Sprite extends DrinkDecorator
{
    public Sprite(Consumable parent)
    {
        super(parent);
    }

    public Sprite(Consumable parent, Size size)
    {
        super(parent, size);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Sprite";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }
}