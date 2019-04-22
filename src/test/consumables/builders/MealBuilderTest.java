package consumables.builders;

import consumables.decorators.Consumable;
import framework.Framework;
import framework.context.ErrorContext;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MealBuilderTest
{
    @Test
    public void testChickenMeal()
    {
        //Build and test chicken meal
        MealBuilder mealBuilder = new MealBuilder();
        Meal chickenMeal = mealBuilder.prepareChickenMeal();
        assertEquals(7.50, chickenMeal.getCost(), 0);
    }

    @Test
    public void testBeefBurgerMeal()
    {
        //Build and test beefburger meal
        MealBuilder mealBuilder = new MealBuilder();
        Meal beefBurgerMeal = mealBuilder.prepareBeefBurgerMeal();
        assertEquals(8.75, beefBurgerMeal.getCost(), 0 );
    }

    @Test
    public void testKebabBurgerMeal()
    {
        //Build and test beefburger meal
        MealBuilder mealBuilder = new MealBuilder();
        Meal kebabMeal = mealBuilder.prepareKebabMeal();
        assertEquals(8.75, kebabMeal.getCost(), 0 );

    }

    @Test
    public void testMealClone()
    {
        MealBuilder mealBuilder = new MealBuilder();
        Meal kebabMeal = mealBuilder.prepareKebabMeal();
        Meal cloneKebabMeal;
        try {
            cloneKebabMeal = (Meal)kebabMeal.clone();
            assertEquals(kebabMeal.getCost(), cloneKebabMeal.getCost(), 0);
        }
        catch(Exception e){
            Framework.getInstance().onLogEvent(
                new ErrorContext(
                    "Error during test meal clone",
                    e
                )
            );
        }
    }

    @Test
    public void testMealIterator(){
        MealBuilder mealBuilder = new MealBuilder();
        Meal beefBurgerMeal = mealBuilder.prepareBeefBurgerMeal();


    }
}