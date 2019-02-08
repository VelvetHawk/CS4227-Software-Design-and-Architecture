package consumables.states;

import consumables.Order;

@FunctionalInterface
public interface State
{
    public void processOrder(Order order);
}