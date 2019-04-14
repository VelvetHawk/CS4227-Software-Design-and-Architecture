package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import consumables.decorators.*;
import consumables.factories.FactoryProducer;
import consumables.toppings.Toppings;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ToppingsController implements Initializable, ControlledScreen
{
    ScreensController myController;
	private ConsumableFactory toppingFactory;
    private static ToppingsController instance; // create a static controller instance,

    public ToppingsController() { instance = this; } // no arg constructor


    public static ToppingsController getInstance() // get instance of the controller
    {
        if (instance == null)
        {
            instance = new ToppingsController();
            return instance;
        }
        else
            return instance;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
	    toppingFactory = FactoryProducer.getFactory(Consumables.TOPPING);
    }    
    
    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;
    }
    
    @FXML
    private void goToStatic(ActionEvent event)
    {
        ((Button)event.getTarget()).getScene().getWindow().hide();
    }
    
    @FXML
    private void getBeef(ActionEvent event)
    {
	    addTopping(Toppings.BEEF);
    }
    
    @FXML
    private void getCheese(ActionEvent event)
    {
	    addTopping(Toppings.CHEESE);
    }
    
    @FXML
    private void getChicken(ActionEvent event)
    {
	    addTopping(Toppings.CHICKEN);
    }
    
    @FXML
    private void getHam(ActionEvent event)
    {
	    addTopping(Toppings.HAM);
    }
    
    @FXML
    private void getMushroom(ActionEvent event)
    {
	    addTopping(Toppings.MUSHROOM);
    }
    
    @FXML
    private void getPepperoni(ActionEvent event)
    {
	    addTopping(Toppings.PEPPERONI);
    }
    
    @FXML
    private void getPineapple(ActionEvent event)
    {
	    addTopping(Toppings.PINEAPPLE);
    }
    
    @FXML
    private void getSausage(ActionEvent event)
    {
	    addTopping(Toppings.SAUSAGE);
    }
    
    // Adds the selected topping to the last item in the food list
    private void addTopping(Toppings topping)
    {
	    ArrayList<Consumable> food = myController.getCustomerOrder().getFood();
	    if (food.size() > 0) // If the list is not empty (ie, at least one food item has been added)
	    {
		    Consumable lastFoodItem = food.get(food.size()-1);
	    	lastFoodItem = toppingFactory.addTopping(topping, lastFoodItem);
	    	food.set(food.size()-1, lastFoodItem);
	    	// UI doesn't update until another object added otherwise
	    	myController.getCustomerOrder().notifyAllObservers();
	    }
    }
}
