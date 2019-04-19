package consumables.states;

import consumables.Order;

public class InProgressState implements State
{
    @Override
    public void processOrder(Order order)
    {
        order.setOrderState(this);
    }

    @Override
    public Object clone()
    {
        return new InProgressState();
    }

    public String toString()
    {
        return "Progress State";
    }
}
