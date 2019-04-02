package consumables.builders;

import consumables.decorators.Consumable;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MealBuilderTest {

    @Test
    public void sayHello() {
        MealBuilder mealBuilder = new MealBuilder();
        Meal chickenMeal = mealBuilder.prepareChickenMeal();
        ArrayList<Consumable> chickenItems = new ArrayList<Consumable>();
        assertEquals(7.50, chickenMeal.getCost(), 0);
        //assertEquals("veg", mealBuilder.getType());
    }
}