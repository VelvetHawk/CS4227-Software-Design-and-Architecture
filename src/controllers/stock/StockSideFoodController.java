package controllers.stock;

import consumables.decorators.*;
import consumables.factories.FactoryProducer;
import consumables.side.Sides;
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

public class StockSideFoodController implements Initializable, ControlledScreen
{
    private ScreensController myController;
    private ConsumableFactory sideFactory;
    private static StockSideFoodController instance; // create a static controller instance,
    @FXML private TextField beansInput;
    @FXML private TextField coleslawInput;
    @FXML private TextField onionInput;
    @FXML private TextField chipsInput;
    @FXML private TextField garlicInput;
    private boolean isTextFieldEmpty = true;
    private String numberRegex = "^[0-9]*$"; // only digits

    public StockSideFoodController() { instance = this; } // no arg constructor


    public static StockSideFoodController getInstance() // get instance of the controller
    {
        if (instance == null)
        {
            instance = new StockSideFoodController();
            return instance;
        }
        else
            return instance;
    }

    @Override
    public void initialize( URL url, ResourceBundle rb)
    {
        sideFactory = FactoryProducer.getFactory(Consumables.SIDE);
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
    private void getBeans(ActionEvent event)
    {
        checkInput(beansInput.getText());
        if (!isTextFieldEmpty)
            addStockSideFood(Sides.BEANS, beansInput.getText());
    }

    @FXML
    private void getChips(ActionEvent event)
    {
        checkInput(chipsInput.getText());
        if(!isTextFieldEmpty)
            addStockSideFood(Sides.CHIPS, chipsInput.getText());
    }

    @FXML
    private void getColeslaw(ActionEvent event)
    {
        checkInput(coleslawInput.getText());
        if(!isTextFieldEmpty)
            addStockSideFood(Sides.COLESLAW, coleslawInput.getText());
    }

    @FXML
    private void getGarlicbread(ActionEvent event)
    {
        checkInput(garlicInput.getText());
        if(!isTextFieldEmpty)
            addStockSideFood(Sides.GARLICBREAD, garlicInput.getText());
    }

    @FXML
    private void getOnionRings(ActionEvent event)
    {
        checkInput(onionInput.getText());
        if(!isTextFieldEmpty)
            addStockSideFood(Sides.ONIONRINGS, onionInput.getText());
    }

    private void addStockSideFood( Sides sideType, String quantity)
    {

        myController.getStockOrder().addSideFood(
                (SideDecorator) sideFactory.addSide(sideType, sideFactory.getSide()),
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
