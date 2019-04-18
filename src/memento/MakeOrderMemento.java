package memento;

import consumables.Order;

public class MakeOrderMemento
{
    private Order order;

    public MakeOrderMemento(Order order)
    {
        this.order = order;
    }

    public Order getOrder()
    {
        return order;
    }
}
