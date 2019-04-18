package consumables.side;

import consumables.decorators.Consumable;
import consumables.decorators.SideDecorator;

public class Beans extends SideDecorator
{
    public Beans(Consumable parent)
    {
        super(parent);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Beans";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }
    @Override
    public double getStockCost()
    {
        return parent.getCost() + 5;
    }
}