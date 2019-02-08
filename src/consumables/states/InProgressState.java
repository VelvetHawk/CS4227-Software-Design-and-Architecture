package consumables.states;

import consumables.Order;

public class InProgressState implements State
{
    @Override
    public void processOrder(Order order)
    {
        System.out.println("Order is in progress");
        order.setOrderState(this);
    }

    public String toString()
    {
        return "Progress State";
    }
}
