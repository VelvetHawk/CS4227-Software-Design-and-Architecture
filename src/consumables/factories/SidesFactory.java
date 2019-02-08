package consumables.factories;

import consumables.basics.BasicTopping;
import consumables.decorators.Consumable;
import consumables.decorators.ConsumableFactory;
import consumables.drinks.Drinks;
import consumables.food.Food;
import consumables.side.*;
import consumables.toppings.*;

public class SidesFactory extends ConsumableFactory
{
    @Override
    public Consumable getSide()
    {
        return new BasicTopping();
    }

    @Override
    public Consumable addSide(Sides type, Consumable addTo)
    {
        switch (type)
        {
            case BEANS:
                return new Beans(addTo);
            case CHIPS:
                return new Chips(addTo);
            case COLESLAW:
                return new Coleslaw(addTo);
            case GARLICBREAD:
                return new GarlicBread(addTo);
            case ONIONRINGS:
                return new OnionRings(addTo);
            default:
                return null;
        }
    }

    @Override
    public Consumable getTopping()
    {
        return null;
    }

    @Override
    public Consumable addTopping(Toppings type, Consumable addTo)
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
