package consumables.toppings;

import consumables.decorators.Consumable;
import consumables.decorators.ToppingDecorator;

public class Beef extends ToppingDecorator
{
    public Beef(Consumable parent)
    {
        super(parent);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Beef";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }
}