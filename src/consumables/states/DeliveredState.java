package consumables.states;

import consumables.Order;

public class DeliveredState implements State
{
    @Override
    public void processOrder(Order order)
    {
        System.out.println("Order is in delivered state");
        order.setOrderState(this);
    }

    public String toString()
    {
        return "Delivered State";
    }
}
