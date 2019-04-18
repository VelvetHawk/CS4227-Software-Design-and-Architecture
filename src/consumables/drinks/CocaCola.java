package consumables.drinks;

import consumables.Size;
import consumables.decorators.Consumable;
import consumables.decorators.DrinkDecorator;
import visitor.ConsumableVisitor;

public class CocaCola extends DrinkDecorator
{
    public CocaCola(Consumable parent)
    {
        super(parent);
    }

    public CocaCola(Consumable parent, Size size)
    {
        super(parent, size);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Coca Cola";
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
    public String accept(ConsumableVisitor conVisitor){
        String description = conVisitor.visit(this);
        return description;
    }
    @Override
    public Object clone()
    {
        return new CocaCola(this.parent);
    }
}