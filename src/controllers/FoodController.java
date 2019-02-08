package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import consumables.Size;
import consumables.decorators.*;
import consumables.factories.FactoryProducer;
import consumables.food.Food;
import display.views.PopUpScreens;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FoodController implements Initializable, ControlledScreen
{
    private ScreensController myController;
    private ConsumableFactory foodFactory;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
	    foodFactory = FactoryProducer.getFactory(Consumables.FOOD);
    }    
    
    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;
    }

    @FXML
    private void goToMainMenu(ActionEvent event)
    {
        ((Button)event.getTarget()).getScene().getWindow().hide();
    }

    @FXML
    private void getLargeBurger(ActionEvent event)
    {
	    addFood(Food.BURGER, Size.LARGE);
    }

    @FXML
    private void getMediumBurger(ActionEvent event)
    {
	    addFood(Food.BURGER, Size.MEDIUM);
    }

    @FXML
    private void getSmallBurger(ActionEvent event)
    {
	    addFood(Food.BURGER, Size.SMALL);
    }

    @FXML
    private void getLargeKebab(ActionEvent event)
    {
	    addFood(Food.KEBAB, Size.LARGE);
    }

    @FXML
    private void getMediumKebab(ActionEvent event)
    {
	    addFood(Food.KEBAB, Size.MEDIUM);
    }

    @FXML
    private void getSmallKebab(ActionEvent event)
    {
	    addFood(Food.KEBAB, Size.SMALL);
    }

    @FXML
    private void getLargePizza(ActionEvent event)
    {
	    addFood(Food.PIZZA, Size.LARGE);
    }

    @FXML
    private void getMediummPizza(ActionEvent event)
    {
	    addFood(Food.PIZZA, Size.MEDIUM);
    }

    @FXML
    private void getSmallPizza(ActionEvent event)
    {
	    addFood(Food.PIZZA, Size.SMALL);
    }
    
    @FXML
    private void getPizzaTopping(ActionEvent event)
    {
        myController.setPopUpScreen(PopUpScreens.SELECT_TOPPING);
    }
	
	private void addFood(Food foodType, Size size)
	{
		Consumable food = foodFactory.getFood();
		food = foodFactory.addFood(foodType, food);
		myController.getCustomerOrder().addFood((FoodDecorator) food, size);
	}
}
