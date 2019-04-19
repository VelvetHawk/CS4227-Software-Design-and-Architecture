package consumables.drinks;

import consumables.Size;
import consumables.decorators.Consumable;
import consumables.decorators.DrinkDecorator;
import visitor.ConsumableVisitor;

public class DietCocaCola extends DrinkDecorator
{
    public DietCocaCola(Consumable parent)
    {
        super(parent);
    }

    public DietCocaCola(Consumable parent, Size size)
    {
        super(parent, size);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Diet Coca Cola";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }

    @Override
    public double getStockCost()
    {
        return parent.getCost();
    }

    @Override
    public String accept(ConsumableVisitor conVisitor)
    {
        return conVisitor.visit(this);
    }

    @Override
    public Object clone()
    {
        return new DietCocaCola(this.parent);
    }
}
