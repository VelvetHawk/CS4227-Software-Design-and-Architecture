package consumables.factories;

import consumables.basics.BasicFood;
import consumables.basics.BasicTopping;
import consumables.decorators.Consumable;
import consumables.decorators.ConsumableFactory;
import consumables.drinks.Drinks;
import consumables.food.*;
import consumables.side.*;
import consumables.toppings.*;

public class FoodFactory extends ConsumableFactory
{
    @Override
    public Consumable getFood()
    {
        return new BasicFood();
    }

    @Override
    public Consumable addFood(Food type, Consumable addTo) {
        switch (type)
        {
            case BURGER:
                return new Burger(addTo);
            case KEBAB:
                return new Kebab(addTo);
            case PIZZA:
                return new Pizza(addTo);
            case CHICKENBURGER:
                return new ChickenBurger(addTo);
            default:
                return null;
        }
    }

    @Override
    public Consumable getTopping()
    {
        return new BasicTopping();
    }

    @Override
    public Consumable addTopping(Toppings type, Consumable addTo)
    {
        return null;
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
}
