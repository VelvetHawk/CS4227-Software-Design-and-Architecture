package prototype;

import consumables.builders.Meal;
import consumables.builders.MealBuilder;

import java.util.Hashtable;

public class MealStore {

    private static Hashtable<String, Meal> mealMap = new Hashtable<String, Meal>();

    public static Meal getMeal(String mealId){
        Meal meal = mealMap.get(mealId);
        Meal mealClone = (Meal) meal.clone();
        return mealClone;
    }

    public static void load(){
        MealBuilder mealBuilder = new MealBuilder();

        Meal chickenMeal = mealBuilder.prepareChickenMeal();
        mealMap.put("ChickenMeal", chickenMeal);

        Meal beefBurgerMeal = mealBuilder.prepareBeefBurgerMeal();
        mealMap.put("Beef Burger Meal", beefBurgerMeal);

        Meal kebabMeal = mealBuilder.prepareKebabMeal();
        mealMap.put("Kebab Meal", kebabMeal);


    }
}
