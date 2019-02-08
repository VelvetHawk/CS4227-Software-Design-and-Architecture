package consumables.decorators;

import consumables.drinks.Drinks;
import consumables.food.Food;
import consumables.side.Sides;
import consumables.toppings.Toppings;

public abstract class ConsumableFactory
{
    public abstract Consumable getTopping();
    public abstract Consumable addTopping(Toppings type, Consumable addTo);
    public abstract Consumable getSide();
    public abstract Consumable addSide(Sides type, Consumable addTo);
    public abstract Consumable getDrink();
    public abstract Consumable addDrink(Drinks type, Consumable addTo);
    public abstract Consumable getFood();
    public abstract Consumable addFood(Food type, Consumable addTo);
}
