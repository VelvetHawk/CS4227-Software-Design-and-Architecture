package consumables.toppings;

import consumables.decorators.Consumable;
import consumables.decorators.ToppingDecorator;

public class Pepperoni extends ToppingDecorator
{
    public Pepperoni(Consumable parent)
    {
        super(parent);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Pepperoni";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }
}