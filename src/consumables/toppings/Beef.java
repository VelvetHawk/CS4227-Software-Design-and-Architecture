package consumables.toppings;

import consumables.decorators.Consumable;
import consumables.decorators.ToppingDecorator;
import visitor.ConsumableVisitor;

public class Beef extends ToppingDecorator
{
    public Beef(Consumable parent)
    {
        super(parent);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Beef";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }

    @Override
    public double getStockCost()
    {
        return parent.getCost() + 10;
    }

    @Override
    public String accept(ConsumableVisitor conVisitor){
        String description = conVisitor.visit(this);
        return description;
    }
    @Override
    public Object clone()
    {
        return new Beef(this.parent);
    }
}