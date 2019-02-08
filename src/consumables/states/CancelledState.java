package consumables.states;

import consumables.Order;

public class CancelledState implements State
{
    @Override
    public void processOrder(Order order)
    {
        System.out.println("Order is in cancelled state");
        order.setOrderState(this);
    }

    public String toString()
    {
        return "Order cancelled State";
    }
}
