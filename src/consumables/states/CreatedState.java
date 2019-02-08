package consumables.states;

import consumables.Order;

public class CreatedState implements State
{
    @Override
    public void processOrder(Order order)
    {
        System.out.println("Order is in Created state");
        order.setOrderState(this);
    }

    public String toString()
    {
        return "Created State";
    }
}
