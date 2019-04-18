package command;

import consumables.decorators.*;
import data.Observer;
import data.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stock implements Subject
{
    private ArrayList<Observer> observers;
    private ArrayList<DrinkDecorator> drinkList;
    private ArrayList<FoodDecorator> foodList;
    private ArrayList<ToppingDecorator> toppingList;
    private ArrayList<SideDecorator> sideFoodList;

    private HashMap<DrinkDecorator, Integer> drinks;
    private HashMap<FoodDecorator, Integer> foods;
    private HashMap<ToppingDecorator, Integer> toppings;
    private HashMap<SideDecorator, Integer> sides;


    public Stock()
    {
        observers = new ArrayList<>();
        drinkList = new ArrayList<>();
        foodList = new ArrayList<>();
        toppingList = new ArrayList<>();
        sideFoodList= new ArrayList<>();
        drinks = new HashMap<>();
        foods = new HashMap<>();
        toppings = new HashMap<>();
        sides = new HashMap<>();
    }

    public HashMap<DrinkDecorator, Integer> getDrinks()
    {
        return drinks;
    }

    public HashMap<FoodDecorator, Integer> getFoods()
    {
        return foods;
    }
    public HashMap<ToppingDecorator, Integer> getToppings()
    {
        return toppings;
    }
    public HashMap<SideDecorator, Integer> getSides()
    {
        return sides;
    }

    public void buy()
    {
        notifyAllObservers();
    }
    public void sell()
    {
        // empty
    }

    // the function is where you buying stock stores each item with quantity
    public void addDrink(DrinkDecorator drinkType, int quantity )
    {
        drinks.put(drinkType, quantity);
    }

    // the function is where you buying stock stores each item with quantity
    public void addFood(FoodDecorator foodType, int quantity )
    {
        foods.put(foodType, quantity);
    }

    // the function is where you buying stock stores each item with quantity
    public void addTopping(ToppingDecorator toppingType, int quantity )
    {
        toppings.put(toppingType, quantity);
    }

    // the function is where you buying stock stores each item with quantity
    public void addSideFood(SideDecorator sideType, int quantity )
    {
        sides.put(sideType, quantity);
    }

    @Override
    public void notifyAllObservers()
    {
        observers.forEach(Observer::update);
    }

    @Override
    public void attach(Observer observer )
    {
        observers.add(observer);
    }

    public void removeDrink(Consumable drink)
    {
        drinks.remove(drink);
        notifyAllObservers();
    }
    public void removeFood(Consumable food)
    {
        foods.remove(food);
        notifyAllObservers();
    }
    public void removeTopping(Consumable topping)
    {
        toppings.remove(topping);
        notifyAllObservers();
    }
    public void removeSides(Consumable side)
    {
        sides.remove(side);
        notifyAllObservers();
    }

    public double getTotalCost()
    {
        double total = 0.0;
        for (HashMap.Entry<DrinkDecorator, Integer> entry : drinks.entrySet())
        {
            drinkList.add(entry.getKey());
            total += entry.getKey().getStockCost() * entry.getValue();

        }
        for(HashMap.Entry<FoodDecorator, Integer> entry : foods.entrySet())
        {
            foodList.add(entry.getKey());
            total += entry.getKey().getStockCost() * entry.getValue();
        }
        for(HashMap.Entry<ToppingDecorator, Integer> entry : toppings.entrySet())
        {
            toppingList.add(entry.getKey());
            total += entry.getKey().getStockCost() * entry.getValue();
        }
        for(HashMap.Entry<SideDecorator, Integer> entry : sides.entrySet())
        {
            sideFoodList.add(entry.getKey());
            total += entry.getKey().getStockCost() * entry.getValue();
        }
        return total;
    }
}