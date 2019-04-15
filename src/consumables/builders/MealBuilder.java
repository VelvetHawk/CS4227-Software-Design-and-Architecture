package consumables.builders;

import consumables.decorators.Consumable;
import consumables.decorators.ConsumableFactory;
import consumables.decorators.Consumables;
import consumables.drinks.CocaCola;
import consumables.drinks.Drinks;
import consumables.factories.FactoryProducer;
import consumables.food.Food;
import consumables.side.Sides;
import controllers.ScreensController;

public class MealBuilder {
    private ScreensController myController;
    private ConsumableFactory drinkFactory;
    private ConsumableFactory foodFactory;
    private ConsumableFactory sideFactory;

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
        food = foodFactory.addFood(Food.CHICKENBURGER, food);
        chickenMeal.addItem(food);
        return chickenMeal;

    }

    public Meal prepareBeefBurgerMeal(){
        Meal beefBurgerMeal = new Meal();
        drinkFactory = FactoryProducer.getFactory(Consumables.DRINK);
        Consumable drink = drinkFactory.getDrink();
        drink = drinkFactory.addDrink(Drinks.COCACOLA, drink);
        beefBurgerMeal.addItem(drink);
        foodFactory = FactoryProducer.getFactory(Consumables.FOOD);
        Consumable food = foodFactory.getFood();
        food = foodFactory.addFood(Food.BURGER, food);
        beefBurgerMeal.addItem(food);
        sideFactory = FactoryProducer.getFactory(Consumables.SIDE);
        Consumable side = sideFactory.getSide();
        side = sideFactory.addSide(Sides.CHIPS, side);
        beefBurgerMeal.addItem(side);
        return beefBurgerMeal;
    }

    public Meal prepareKebabMeal(){
        Meal kebabMeal = new Meal();
        drinkFactory = FactoryProducer.getFactory(Consumables.DRINK);
        Consumable drink = drinkFactory.getDrink();
        drink = drinkFactory.addDrink(Drinks.COCACOLA, drink);
        kebabMeal.addItem(drink);
        foodFactory = FactoryProducer.getFactory(Consumables.FOOD);
        Consumable food = foodFactory.getFood();
        food = foodFactory.addFood(Food.KEBAB, food);
        kebabMeal.addItem(food);
        return kebabMeal;
    }


}


