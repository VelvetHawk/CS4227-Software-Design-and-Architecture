package consumables.side;

import consumables.decorators.Consumable;
import consumables.decorators.SideDecorator;

public class Chips extends SideDecorator
{
    public Chips(Consumable parent)
    {
        super(parent);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Chips";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }
}