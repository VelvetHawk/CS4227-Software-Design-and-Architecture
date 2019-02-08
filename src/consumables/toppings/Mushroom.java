package consumables.toppings;

import consumables.decorators.Consumable;
import consumables.decorators.ToppingDecorator;

public class Mushroom extends ToppingDecorator
{
    public Mushroom(Consumable parent)
    {
        super(parent);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Mushroom";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }
}