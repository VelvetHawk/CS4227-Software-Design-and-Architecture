package controllers.stock;

import consumables.decorators.*;
import consumables.factories.FactoryProducer;
import consumables.toppings.Toppings;
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

public class StockToppingsController implements Initializable, ControlledScreen
{
    private ScreensController myController;
    private ConsumableFactory toppingFactory;
    private static StockToppingsController instance; // create a static controller instance,
    @FXML private TextField beefInput;
    @FXML private TextField cheeseInput;
    @FXML private TextField chickenInput;
    @FXML private TextField hamInput;
    @FXML private TextField pepperoniInput;
    @FXML private TextField pineappleInput;
    @FXML private TextField sausageInput;
    @FXML private TextField mushroomInput;

    private boolean isTextFieldEmpty = true;
    private String numberRegex = "^[0-9]*$"; // only digits

    public StockToppingsController() { instance = this; } // no arg constructor


    public static StockToppingsController getInstance() // get instance of the controller
    {
        if (instance == null)
        {
            instance = new StockToppingsController();
            return instance;
        }
        else
            return instance;
    }

    @Override
    public void initialize( URL url, ResourceBundle rb)
    {
        toppingFactory = FactoryProducer.getFactory(Consumables.TOPPING);
    }

    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;
    }

    @FXML
    private void goToStatic( ActionEvent event)
    {
        ((Button)event.getTarget()).getScene().getWindow().hide();
    }

    @FXML
    private void getBeef(ActionEvent event)
    {
        checkInput(beefInput.getText());
        if(!isTextFieldEmpty)
            addStockToppings(Toppings.BEEF, beefInput.getText());
    }

    @FXML
    private void getCheese(ActionEvent event)
    {
        checkInput(cheeseInput.getText());
        if(!isTextFieldEmpty)
            addStockToppings(Toppings.CHEESE, cheeseInput.getText());
    }

    @FXML
    private void getChicken(ActionEvent event)
    {
        checkInput(chickenInput.getText());
        if(!isTextFieldEmpty)
            addStockToppings(Toppings.CHICKEN, chickenInput.getText());
    }

    @FXML
    private void getHam(ActionEvent event)
    {
        checkInput(hamInput.getText());
        if(!isTextFieldEmpty)
            addStockToppings(Toppings.HAM, hamInput.getText());
    }

    @FXML
    private void getMushroom(ActionEvent event)
    {
        checkInput(mushroomInput.getText());
        if(!isTextFieldEmpty)
            addStockToppings(Toppings.MUSHROOM, mushroomInput.getText());
    }

    @FXML
    private void getPepperoni(ActionEvent event)
    {
        checkInput(pepperoniInput.getText());
        if(!isTextFieldEmpty)
            addStockToppings(Toppings.PEPPERONI, pepperoniInput.getText());
    }

    @FXML
    private void getPineapple(ActionEvent event)
    {
        checkInput(pineappleInput.getText());
        if(!isTextFieldEmpty)
            addStockToppings(Toppings.PINEAPPLE, pineappleInput.getText());
    }

    @FXML
    private void getSausage(ActionEvent event)
    {
        checkInput(sausageInput.getText());
        if(!isTextFieldEmpty)
            addStockToppings(Toppings.SAUSAGE, sausageInput.getText());
    }

    private void addStockToppings( Toppings toppingType, String quantity)
    {
        myController.getStockOrder().addTopping(
                (ToppingDecorator) toppingFactory.addTopping(toppingType, toppingFactory.getTopping()),
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
