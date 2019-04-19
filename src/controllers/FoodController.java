package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import consumables.Size;
import consumables.decorators.*;
import consumables.factories.FactoryProducer;
import consumables.food.Food;
import display.views.PopUpScreens;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import visitor.ConsumableDescriptionVisitor;

public class FoodController implements Initializable, ControlledScreen
{
    private ScreensController myController;
    private ConsumableFactory foodFactory;

    private static FoodController instance; // create a static controller instance,

    public FoodController() { instance = this; } // no arg constructor


    public static FoodController getInstance() // get instance of the controller
    {
        if (instance == null)
        {
            instance = new FoodController();
            return instance;
        }
        else
            return instance;
    }

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

    @FXML
    private void getPizzaDescription(ActionEvent event){

        System.out.println("i am pressed");
        ConsumableDescriptionVisitor visitor = new ConsumableDescriptionVisitor();
        Consumable food = foodFactory.getFood();
        food = foodFactory.addFood(Food.KEBAB, food);
        String description = food.accept(visitor);
        myController.setPopUpScreen(PopUpScreens.ITEM_DESCRIPTION);

        /*
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "itemDescription.fxml"));
            Parent root = (Parent) loader.load();

            Scene newScene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        */

    }
	
	private void addFood(Food foodType, Size size)
	{
		Consumable food = foodFactory.getFood();
		food = foodFactory.addFood(foodType, food);
		myController.getCustomerOrder().addFood((FoodDecorator) food, size);
	}
}
