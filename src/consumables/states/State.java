package consumables.states;

import consumables.Order;

public interface State extends Cloneable
{
    public void processOrder(Order order);
    public Object clone();
}