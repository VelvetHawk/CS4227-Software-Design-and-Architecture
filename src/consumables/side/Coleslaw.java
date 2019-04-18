package consumables.side;

import consumables.decorators.Consumable;
import consumables.decorators.SideDecorator;
import visitor.ConsumableVisitor;

public class Coleslaw extends SideDecorator
{
    public Coleslaw(Consumable parent)
    {
        super(parent);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Coleslaw";
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
        return new Coleslaw(this.parent);
    }
}