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

    @Override
    public Object clone() {
        return new CancelledState();
    }

    public String toString()
    {
        return "Order cancelled State";
    }
}
