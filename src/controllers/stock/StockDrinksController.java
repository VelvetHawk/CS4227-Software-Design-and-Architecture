package controllers.stock;

import consumables.decorators.ConsumableFactory;
import consumables.decorators.Consumables;
import consumables.decorators.DrinkDecorator;
import consumables.drinks.Drinks;
import consumables.factories.FactoryProducer;
import controllers.ControlledScreen;
import controllers.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StockDrinksController implements Initializable, ControlledScreen
{
    private ScreensController myController;
    private ConsumableFactory drinksFactory;
    private boolean isTextFieldEmpty = true;

    private String numberRegex = "^[0-9]*$"; // only digits

    private static StockDrinksController instance; // create a static controller instance,

    @FXML private TextField clubOrangeInput;
    @FXML private TextField cocaColaInput;
    @FXML private TextField dietCocaColaInput;
    @FXML private TextField waterInput;
    @FXML private TextField sevenUpInput;
    @FXML private TextField spriteInput;
    @FXML private TextField pepsiInput;
    @FXML private TextField pepsiMaxInput;

    public StockDrinksController()
    {
        instance = this;
    } // no arg constructor


    public static StockDrinksController getInstance() // get instance of the controller
    {
        if (instance == null)
        {
            instance = new StockDrinksController();
            return instance;
        }
        else
            return instance;
    }

    @Override
    public void initialize( URL url, ResourceBundle rb)
    {
        drinksFactory = FactoryProducer.getFactory(Consumables.DRINK);
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
    private void getClubOrange(ActionEvent event)
    {
        checkInput(clubOrangeInput.getText()); // check the input, only accepts numbers not empty field and no char accepts
        if(!isTextFieldEmpty)
            addStockDrink(Drinks.CLUBORANGE, clubOrangeInput.getText());
    }

    @FXML
    private void getCocacola(ActionEvent event)
    {
        checkInput(cocaColaInput.getText());// check the input, only accepts numbers not empty field and no char accepts
        if(!isTextFieldEmpty)
            addStockDrink(Drinks.COCACOLA, cocaColaInput.getText());
    }

    @FXML
    private void getDietcocacola(ActionEvent event)
    {
        checkInput(dietCocaColaInput.getText());// check the input, only accepts numbers not empty field and no char accepts
        if(!isTextFieldEmpty)
            addStockDrink(Drinks.DIETCOCACOLA, dietCocaColaInput.getText());
    }

    @FXML
    private void getPepsi(ActionEvent event)
    {
        checkInput(pepsiInput.getText());// check the input, only accepts numbers not empty field and no char accepts
        if(!isTextFieldEmpty)
            addStockDrink(Drinks.PEPSI, pepsiInput.getText());
    }

    @FXML
    private void getPepsiMax(ActionEvent event)
    {
        checkInput(pepsiMaxInput.getText());// check the input, only accepts numbers not empty field and no char accepts
        if(!isTextFieldEmpty)
            addStockDrink(Drinks.PEPSIMAX, pepsiMaxInput.getText());
    }

    @FXML
    private void getSevenUp(ActionEvent event)
    {
        checkInput(sevenUpInput.getText());// check the input, only accepts numbers not empty field and no char accepts
        if(!isTextFieldEmpty)
            addStockDrink(Drinks.SEVENUP, sevenUpInput.getText());
    }

    @FXML
    private void getSprite(ActionEvent event)
    {
        checkInput(spriteInput.getText());// check the input, only accepts numbers not empty field and no char accepts
        if(!isTextFieldEmpty)
            addStockDrink(Drinks.SPRITE, spriteInput.getText());
    }

    @FXML
    private void getWater(ActionEvent event)
    {
        checkInput(waterInput.getText());// check the input, only accepts numbers not empty field and no char accepts
        if(!isTextFieldEmpty)
            addStockDrink(Drinks.WATER, waterInput.getText());
    }

    private void addStockDrink(Drinks drinkType, String quantity)
    {
        myController.getStockOrder().addDrink(
                (DrinkDecorator)drinksFactory.addDrink(drinkType, drinksFactory.getDrink()),
                Integer.parseInt(quantity)
        );

        myController.getBroker();
        isTextFieldEmpty = true; // reset every single field for checking
    }

    // the method checks, he user input must be only number, and displays a dialog box.
    private void checkInput(String input){
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
