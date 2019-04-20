package prototype;

import consumables.builders.Meal;
import consumables.builders.MealBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class MealStoreTest {

    @Test
    public void testGetMeal(){
        MealStore mealStore = new MealStore();
        mealStore.load();

        MealBuilder mealBuilder = new MealBuilder();
        Meal chickenMeal = mealBuilder.prepareChickenMeal();

        Meal chickenMealClone = mealStore.getMeal("ChickenMeal");
        assertEquals(chickenMeal.getCost(), chickenMealClone.getCost(), 0);
    }

}