package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import consumables.decorators.*;
import consumables.factories.FactoryProducer;
import consumables.food.Food;
import consumables.toppings.Toppings;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import visitor.ConsumableDescriptionVisitor;

public class ItemDescriptionController implements Initializable, ControlledScreen
{
    ScreensController myController;
    private ConsumableFactory toppingFactory;
    private ConsumableFactory foodFactory;
    private static ItemDescriptionController instance; // create a static controller instance,

    //@FXML TextField descriptionText;
    @FXML private Label DescriptionText;

    public ItemDescriptionController() { instance = this; } // no arg constructor


    public static ItemDescriptionController getInstance() // get instance of the controller
    {
        if (instance == null)
        {
            instance = new ItemDescriptionController();
            return instance;
        }
        else
            return instance;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        toppingFactory = FactoryProducer.getFactory(Consumables.TOPPING);
        ConsumableDescriptionVisitor visitor = new ConsumableDescriptionVisitor();
        foodFactory = FactoryProducer.getFactory(Consumables.FOOD);
        Consumable food = foodFactory.getFood();
        food = foodFactory.addFood(Food.BURGER, food);
        String description = food.accept(visitor);
        DescriptionText.setText(description);

    }

    @FXML
    public void goToMainMenu(ActionEvent event){
        ((Button)event.getTarget()).getScene().getWindow().hide();
    }

    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;
    }



}
