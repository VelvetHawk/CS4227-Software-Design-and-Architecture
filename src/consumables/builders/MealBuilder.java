package consumables.builders;

import consumables.decorators.Consumable;
import consumables.decorators.ConsumableFactory;
import consumables.decorators.Consumables;
import consumables.drinks.Drinks;
import consumables.factories.FactoryProducer;
import consumables.food.Food;
import consumables.side.Sides;

public class MealBuilder
{
    private ConsumableFactory drinkFactory;
    private ConsumableFactory foodFactory;
    private ConsumableFactory sideFactory;

    public Meal prepareChickenMeal()
    {
        Meal chickenMeal = new Meal();

        drinkFactory = FactoryProducer.getFactory(Consumables.DRINK);
        foodFactory = FactoryProducer.getFactory(Consumables.FOOD);

        Consumable drink = drinkFactory.getDrink();
        Consumable food = foodFactory.getFood();

        food = foodFactory.addFood(Food.CHICKENBURGER, food);
        drink = drinkFactory.addDrink(Drinks.COCACOLA, drink);

        chickenMeal.addItem(drink);
        chickenMeal.addItem(food);

        return chickenMeal;
    }

    public Meal prepareBeefBurgerMeal()
    {
        Meal beefBurgerMeal = new Meal();

        drinkFactory = FactoryProducer.getFactory(Consumables.DRINK);
        foodFactory = FactoryProducer.getFactory(Consumables.FOOD);
        sideFactory = FactoryProducer.getFactory(Consumables.SIDE);

        Consumable drink = drinkFactory.getDrink();
        Consumable food = foodFactory.getFood();
        Consumable side = sideFactory.getSide();

        drink = drinkFactory.addDrink(Drinks.COCACOLA, drink);
        food = foodFactory.addFood(Food.BURGER, food);
        side = sideFactory.addSide(Sides.CHIPS, side);

        beefBurgerMeal.addItem(food);
        beefBurgerMeal.addItem(drink);
        beefBurgerMeal.addItem(side);

        return beefBurgerMeal;
    }

    public Meal prepareKebabMeal()
    {
        Meal kebabMeal = new Meal();

        drinkFactory = FactoryProducer.getFactory(Consumables.DRINK);
        foodFactory = FactoryProducer.getFactory(Consumables.FOOD);
        sideFactory = FactoryProducer.getFactory(Consumables.SIDE);

        Consumable drink = drinkFactory.getDrink();
        Consumable food = foodFactory.getFood();
        Consumable side = sideFactory.getSide();

        drink = drinkFactory.addDrink(Drinks.COCACOLA, drink);
        food = foodFactory.addFood(Food.KEBAB, food);
        side = sideFactory.addSide(Sides.CHIPS, side);

        kebabMeal.addItem(food);
        kebabMeal.addItem(drink);
        kebabMeal.addItem(side);

        return kebabMeal;
    }
}


