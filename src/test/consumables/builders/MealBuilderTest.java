package consumables.builders;

import consumables.decorators.Consumable;
import org.junit.Test;
import prototype.Prototype;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MealBuilderTest {

    @Test
    public void testChickenMeal() {
        //Build and test chicken meal
        MealBuilder mealBuilder = new MealBuilder();
        Meal chickenMeal = mealBuilder.prepareChickenMeal();
        assertEquals(7.50, chickenMeal.getCost(), 0);
        ArrayList<Consumable> expectedContents = new ArrayList();
        //expectedContents.add();
        //assertEquals(chickenMeal.getContents(), expectedContents);


    }

    @Test
    public void testBeefBurgerMeal(){
        //Build and test beefburger meal
        MealBuilder mealBuilder = new MealBuilder();
        Meal beefBurgerMeal = mealBuilder.prepareBeefBurgerMeal();
        assertEquals(7.50, beefBurgerMeal.getCost(), 0 );


    }
    @Test
    public void testKebabBurgerMeal(){
        //Build and test beefburger meal
        MealBuilder mealBuilder = new MealBuilder();
        Meal kebabMeal = mealBuilder.prepareKebabMeal();
        assertEquals(7.50, kebabMeal.getCost(), 0 );
        ArrayList<Consumable> contents =  kebabMeal.getContents();
        for(int i=0;i<contents.size();i++){
            System.out.println(contents.get(i));
        }


    }

    @Test
    public void testMealClone(){
        MealBuilder mealBuilder = new MealBuilder();
        Meal kebabMeal = mealBuilder.prepareKebabMeal();
        Meal cloneKebabMeal;
        try {
            cloneKebabMeal = (Meal)kebabMeal.clone();
            assertEquals(kebabMeal.getContents(), cloneKebabMeal.getContents());
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}