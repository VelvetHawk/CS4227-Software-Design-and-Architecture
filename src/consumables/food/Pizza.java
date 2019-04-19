package consumables.food;

import consumables.Size;
import consumables.decorators.Consumable;
import consumables.decorators.FoodDecorator;
import visitor.ConsumableVisitor;

public class Pizza extends FoodDecorator
{
    public Pizza(Consumable parent)
    {
        super(parent);
    }

    public Pizza(Consumable parent, Size size)
    {
        super(parent, size);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Pizza";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }
    @Override
    public double getStockCost()
    {
        return parent.getCost() + .5;
    }

    @Override
    public String accept(ConsumableVisitor conVisitor)
    {
        return conVisitor.visit(this);
    }

    @Override
    public Object clone()
    {
        return new Pizza(this.parent);
    }
}