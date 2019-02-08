package consumables.toppings;

import consumables.decorators.Consumable;
import consumables.decorators.ToppingDecorator;

public class Cheese extends ToppingDecorator
{
    public Cheese(Consumable parent)
    {
        super(parent);
    }

    @Override
    public String getName()
    {
        return parent.getName() + "Cheese";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }
}