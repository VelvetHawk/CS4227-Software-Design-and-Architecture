package controllers.stock;

import consumables.decorators.ConsumableFactory;
import consumables.decorators.Consumables;
import consumables.decorators.FoodDecorator;
import consumables.factories.FactoryProducer;
import consumables.food.Food;
import controllers.ControlledScreen;
import controllers.ScreensController;
import display.views.PopUpScreens;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class StockFoodController implements Initializable, ControlledScreen
{
    private ScreensController myController;
    private ConsumableFactory foodFactory;
    private boolean isTextFieldEmpty = true;
    private String numberRegex = "^[0-9]*$"; // only digits
    @FXML private TextField largeBurgerInput;
    @FXML private TextField mediumBurgerInput;
    @FXML private TextField smallBurgerInput;
    @FXML private TextField largeKebabInput;
    @FXML private TextField mediumKebabInput;
    @FXML private TextField smallKebabInput;
    @FXML private TextField largePizzaInput;
    @FXML private TextField mediumPizzaInput;
    @FXML private TextField smallPizzaInput;

    private static StockFoodController instance; // create a static controller instance,

    public StockFoodController() { instance = this; } // no arg constructor


    public static StockFoodController getInstance() // get instance of the controller
    {
        if (instance == null)
        {
            instance = new StockFoodController();
            return instance;
        }
        else
            return instance;
    }

    @Override
    public void initialize( URL url, ResourceBundle rb)
    {
        foodFactory = FactoryProducer.getFactory(Consumables.FOOD);
    }

    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;
    }

    @FXML
    private void goToMainMenu( ActionEvent event)
    {
        ((Button)event.getTarget()).getScene().getWindow().hide();
    }

    @FXML
    private void getLargeBurger(ActionEvent event)
    {
        // check the input, only accepts numbers not empty field and no char accepts
        checkInput(largeBurgerInput.getText());
        if(!isTextFieldEmpty)
            addStockFood(Food.BURGER, largeBurgerInput.getText());
    }

    @FXML
    private void getMediumBurger(ActionEvent event)
    {
        // check the input, only accepts numbers not empty field and no char accepts
        checkInput(mediumBurgerInput.getText());
        if(!isTextFieldEmpty)
            addStockFood(Food.BURGER, mediumBurgerInput.getText());
    }

    @FXML
    private void getSmallBurger(ActionEvent event)
    {
        // check the input, only accepts numbers not empty field and no char accepts
        checkInput(smallBurgerInput.getText());
        if(!isTextFieldEmpty)
            addStockFood(Food.BURGER, smallBurgerInput.getText());
    }

    @FXML
    private void getLargeKebab(ActionEvent event)
    {
        // check the input, only accepts numbers not empty field and no char accepts
        checkInput(largeKebabInput.getText());
        if(!isTextFieldEmpty)
            addStockFood(Food.KEBAB, largeKebabInput.getText());
    }

    @FXML
    private void getMediumKebab(ActionEvent event)
    {
        // check the input, only accepts numbers not empty field and no char accepts
        checkInput(mediumKebabInput.getText());
        if(!isTextFieldEmpty)
            addStockFood(Food.KEBAB, mediumKebabInput.getText());
    }

    @FXML
    private void getSmallKebab(ActionEvent event)
    {
        // check the input, only accepts numbers not empty field and no char accepts
        checkInput(smallKebabInput.getText());
        if(!isTextFieldEmpty)
            addStockFood(Food.KEBAB, smallKebabInput.getText());
    }

    @FXML
    private void getLargePizza(ActionEvent event)
    {
        // check the input, only accepts numbers not empty field and no char accepts
        checkInput(largePizzaInput.getText());
        if(!isTextFieldEmpty)
            addStockFood(Food.PIZZA, largePizzaInput.getText());
    }

    @FXML
    private void getMediummPizza(ActionEvent event)
    {
        // check the input, only accepts numbers not empty field and no char accepts
        checkInput(mediumPizzaInput.getText());
        if(!isTextFieldEmpty)
            addStockFood(Food.PIZZA, mediumPizzaInput.getText());
    }

    @FXML
    private void getSmallPizza(ActionEvent event)
    {
        // check the input, only accepts numbers not empty field and no char accepts
        checkInput(smallPizzaInput.getText());
        if(!isTextFieldEmpty)
            addStockFood(Food.PIZZA, smallPizzaInput.getText());
    }

    @FXML
    private void getPizzaTopping(ActionEvent event)
    {
        myController.setPopUpScreen(PopUpScreens.SELECT_TOPPING);
    }

    private void addStockFood(Food foodType, String quantity)
    {
        myController.getStockOrder().addFood(
                (FoodDecorator)foodFactory.addFood(foodType, foodFactory.getFood()),
                Integer.parseInt(quantity)
        );
        myController.getBroker();
        isTextFieldEmpty = true; // reset every single field for checking
    }

    // the method checks, he user input must be only number, and displays a dialog box.
    private void checkInput(String input)
    {
        if(input.isEmpty() || !(input.matches(numberRegex))) {
            isTextFieldEmpty = true;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("only quantity in this field, i.e. any digits!");

            alert.showAndWait();
        }else {
            isTextFieldEmpty = false;
        }
    }
}
