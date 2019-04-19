package command;

import consumables.decorators.DrinkDecorator;
import consumables.drinks.Drinks;
import consumables.factories.DrinksFactory;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class StockTest {
    private Stock stockOrder = new Stock();
    private DrinksFactory drinksFactory = new DrinksFactory();
    private Drinks drinkType = Drinks.CLUBORANGE;

    @Test
    public void addDrink() {
        DrinkDecorator firstKey = (DrinkDecorator)drinksFactory.addDrink(drinkType, drinksFactory.getDrink());

        stockOrder.addDrink(firstKey, Integer.parseInt("4"));

        HashMap<DrinkDecorator, Integer> drinks = stockOrder.getDrinks();
        HashMap<DrinkDecorator, Integer> drinksExpected = new HashMap<>();

        DrinkDecorator secondKey = (DrinkDecorator) drinksFactory.addDrink(drinkType, drinksFactory.getDrink());
        drinksExpected.put(secondKey, 4);


        //System.out.println(drinks.get(firstKey) + "  " + drinksExpected.get(secondKey));
        assertEquals(drinks.get(firstKey), drinksExpected.get(secondKey));

    }

}