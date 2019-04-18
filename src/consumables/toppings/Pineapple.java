package consumables.toppings;

import consumables.decorators.Consumable;
import consumables.decorators.ToppingDecorator;
import visitor.ConsumableVisitor;

public class Pineapple extends ToppingDecorator
{
    public Pineapple(Consumable parent)
    {
        super(parent);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Pineapple";
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

    @Override
    public String accept(ConsumableVisitor conVisitor){
        String description = conVisitor.visit(this);
        return description;
    }
    @Override
    public Object clone()
    {
        return new Pineapple(this.parent);
    }
}