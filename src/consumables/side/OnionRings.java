package consumables.side;

import consumables.decorators.Consumable;
import consumables.decorators.SideDecorator;
import visitor.ConsumableVisitor;

public class OnionRings extends SideDecorator
{
    public OnionRings(Consumable parent)
    {
        super(parent);
    }

    @Override
    public String getName()
    {
        return parent.getName() + " Onion Rings";
    }

    @Override
    public double getCost()
    {
        return parent.getCost() + 1;
    }

    @Override
    public String accept(ConsumableVisitor conVisitor){
        String description = conVisitor.visit(this);
        return description;
    }
}
