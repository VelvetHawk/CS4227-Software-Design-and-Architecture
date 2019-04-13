package consumables.food;

import consumables.Size;
import consumables.decorators.Consumable;
import consumables.decorators.FoodDecorator;

public class ChickenBurger extends FoodDecorator
{
    public ChickenBurger(Consumable parent)
    {
        super(parent);
    }

    public ChickenBurger(Consumable parent, Size size)
    {
        super(parent, size);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Burger";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }
}
