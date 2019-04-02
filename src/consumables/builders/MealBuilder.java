package consumables.builders;

import consumables.decorators.Consumable;
import consumables.decorators.ConsumableFactory;
import consumables.decorators.Consumables;
import consumables.drinks.CocaCola;
import consumables.drinks.Drinks;
import consumables.factories.FactoryProducer;
import consumables.food.Food;
import controllers.ScreensController;

public class MealBuilder {
    private ScreensController myController;
    private ConsumableFactory drinkFactory;
    private ConsumableFactory foodFactory;

    public void sayHello(){
        System.out.println("This is the MealBuilder");
    }
    public String getType(){
        return "veg";
    }

    public Meal prepareVegMeal(){
        Meal vegMeal = new Meal();
        return vegMeal;
    }

    public Meal prepareChickenMeal(){
        Meal chickenMeal = new Meal();
        //chickenMeal.addItem(new CocaCola() );
        drinkFactory = FactoryProducer.getFactory(Consumables.DRINK);
        Consumable drink = drinkFactory.getDrink();
        drink = drinkFactory.addDrink(Drinks.COCACOLA, drink);
        chickenMeal.addItem(drink);
        foodFactory = FactoryProducer.getFactory(Consumables.FOOD);
        Consumable food = foodFactory.getFood();
        food = foodFactory.addFood(Food.KEBAB, food);
        chickenMeal.addItem(food);
        return chickenMeal;

    }
}


