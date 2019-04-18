package consumables.food;

import consumables.Size;
import consumables.decorators.Consumable;
import consumables.decorators.FoodDecorator;
import visitor.ConsumableVisitor;

public class Burger extends FoodDecorator
{
    public Burger(Consumable parent)
    {
        super(parent);
    }

    public Burger(Consumable parent, Size size)
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
    @Override
    public double getStockCost()
    {
        return parent.getCost() + .5;
    }

    @Override
    public String accept(ConsumableVisitor conVisitor){
        String description = conVisitor.visit(this);
        return description;
    }
    @Override
    public Object clone()
    {
        return new Burger(this.parent);
    }
}