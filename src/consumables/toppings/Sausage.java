package consumables.toppings;

import consumables.decorators.Consumable;
import consumables.decorators.ToppingDecorator;

public class Sausage extends ToppingDecorator
{
    public Sausage(Consumable parent)
    {
        super(parent);
    }
    
    @Override
    public String getName()
    {
        return parent.getName() + " Sausage";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }
}