package consumables.states;

import consumables.Order;

public class CreatedState implements State
{
    @Override
    public void processOrder(Order order)
    {
        order.setOrderState(this);
    }

    @Override
    public Object clone()
    {
        return new CreatedState();
    }

    public String toString()
    {
        return "Created State";
    }
}
