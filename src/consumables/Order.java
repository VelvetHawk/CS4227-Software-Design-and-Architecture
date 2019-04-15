package consumables;

import consumables.decorators.*;
import consumables.states.State;
import data.Observer;
import data.Subject;
import java.util.ArrayList;

public class Order implements Subject
{
	private int orderNumber;
	private ArrayList<Consumable> food;
	private ArrayList<ToppingDecorator> toppings;
	private ArrayList<SideDecorator> sides;
	private ArrayList<DrinkDecorator> drinks;
	private State orderState;
	// Observers
	private ArrayList<Observer> observers;
	
	public Order()
	{
		food = new ArrayList<>();
		sides = new ArrayList<>();
		drinks = new ArrayList<>();

		observers = new ArrayList<>();
	}

	public double getTotalCost()
	{
		double total = 0.0;
		for (Consumable food : food)     total += food.getCost();
		for (SideDecorator side : sides)    total += side.getCost();
		for (DrinkDecorator drink : drinks) total += drink.getCost();
		return total;
	}

	public int getOrderNumber()
	{
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	public ArrayList<Consumable> getFood()
	{
		return food;
	}

	public void setFood(ArrayList<Consumable> food)
	{
		this.food = food;
	}

	public ArrayList<ToppingDecorator> getToppings()
	{
		return toppings;
	}

	public void setToppings(ArrayList<ToppingDecorator> toppings)
	{
		this.toppings = toppings;
	}

	public ArrayList<SideDecorator> getSides()
	{
		return sides;
	}

	public void setSides(ArrayList<SideDecorator> sides)
	{
		this.sides = sides;
	}

	public ArrayList<DrinkDecorator> getDrinks()
	{
		return drinks;
	}

	public void setDrinks(ArrayList<DrinkDecorator> drinks)
	{
		this.drinks = drinks;
	}

	public State getOrderState()
	{
		return orderState;
	}

	public void setOrderState(State orderState)
	{
		this.orderState = orderState;
	}
	
	public void addDrink(DrinkDecorator drink)
	{
		drinks.add(drink);
		notifyAllObservers();
	}
	
	public void removeDrink(Consumable drink)
	{
		drinks.remove(drink);
		notifyAllObservers();
	}
	
	public void addFood(FoodDecorator food)
	{
		this.food.add(food);
		notifyAllObservers();
	}
	
	public void addFood(FoodDecorator food, Size size)
	{
		food.setSize(size);
		this.food.add(food);
		notifyAllObservers();
	}
	
	public void removeFood(Consumable food)
	{
		this.food.remove(food);
		notifyAllObservers();
	}
	
	public void addSide(SideDecorator side)
	{
		sides.add(side);
		notifyAllObservers();
	}
	
	public void removeSide(Consumable side)
	{
		sides.remove(side);
		notifyAllObservers();
	}


	
	@Override
	public void notifyAllObservers()
	{
		observers.forEach(Observer::update);
	}
	
	@Override
	public void attach(Observer observer)
	{
		observers.add(observer);
	}
}
