package consumables.factories;

import consumables.decorators.ConsumableFactory;
import consumables.decorators.Consumables;

public class FactoryProducer
{
    private FactoryProducer()
    {

    }

    public static ConsumableFactory getFactory(Consumables type)
    {
        switch (type)
        {
            case TOPPING:
                return new ToppingsFactory();
            case DRINK:
                return new DrinksFactory();
            case FOOD:
                return new FoodFactory();
            case SIDE:
                return new SidesFactory();
            default:
                return null;
        }
    }
}
