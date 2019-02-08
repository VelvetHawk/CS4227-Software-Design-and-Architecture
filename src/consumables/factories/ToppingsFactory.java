package consumables.factories;

import consumables.basics.BasicTopping;
import consumables.decorators.Consumable;
import consumables.decorators.ConsumableFactory;
import consumables.drinks.Drinks;
import consumables.food.Food;
import consumables.side.Sides;
import consumables.toppings.*;

public class ToppingsFactory extends ConsumableFactory
{
    @Override
    public Consumable getTopping()
    {
        return new BasicTopping();
    }

    @Override
    public Consumable addTopping(Toppings type, Consumable addTo)
    {
        switch (type)
        {
            case BEEF:
                return new Beef(addTo);
            case CHEESE:
                return new Cheese(addTo);
            case CHICKEN:
                return new Chicken(addTo);
            case HAM:
                return new Ham(addTo);
            case MUSHROOM:
                return new Mushroom(addTo);
            case PEPPERONI:
                return new Pepperoni(addTo);
            case PINEAPPLE:
                return new Pineapple(addTo);
            case SAUSAGE:
                return new Sausage(addTo);
            default:
                return null;
        }
    }

    @Override
    public Consumable getSide()
    {
        return null;
    }

    @Override
    public Consumable addSide(Sides type, Consumable addTo)
    {
        return null;
    }

    @Override
    public Consumable getDrink()
    {
        return null;
    }

    @Override
    public Consumable addDrink(Drinks type, Consumable addTo)
    {
        return null;
    }

    @Override
    public Consumable getFood()
    {
        return null;
    }

    @Override
    public Consumable addFood(Food type, Consumable addTo)
    {
        return null;
    }
}
