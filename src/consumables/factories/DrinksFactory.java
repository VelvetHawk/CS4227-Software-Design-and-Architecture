package consumables.factories;

import consumables.basics.BasicDrink;
import consumables.decorators.Consumable;
import consumables.decorators.ConsumableFactory;
import consumables.drinks.*;
import consumables.food.Food;
import consumables.side.Sides;
import consumables.toppings.*;

public class DrinksFactory extends ConsumableFactory
{
    @Override
    public Consumable getDrink()
    {
        return new BasicDrink();
    }

    @Override
    public Consumable addDrink(Drinks type, Consumable addTo)
    {
        switch (type)
        {
            case CLUBORANGE:
                return new ClubOrange(addTo);
            case COCACOLA:
                return new CocaCola(addTo);
            case DIETCOCACOLA:
                return new DietCocaCola(addTo);
            case PEPSI:
                return new Pepsi(addTo);
            case PEPSIMAX:
                return new PepsiMax(addTo);
            case SEVENUP:
                return new SevenUp(addTo);
            case SPRITE:
                return new Sprite(addTo);
            case WATER:
                return new Water(addTo);
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
