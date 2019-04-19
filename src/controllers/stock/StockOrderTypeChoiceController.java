package controllers.stock;

import controllers.ControlledScreen;
import controllers.ScreensController;
import display.views.PopUpScreens;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class StockOrderTypeChoiceController implements Initializable, ControlledScreen
{
    @FXML
    private AnchorPane rootPane;
    @FXML private Label paneTitle;
    @FXML private VBox foodChoice;
    @FXML private VBox sideChoice;
    @FXML private VBox drinkChoice;
    @FXML private Button backButton;
    private ScreensController myController;
    private static StockOrderTypeChoiceController instance; // create a static controller instance,

    public StockOrderTypeChoiceController() { instance = this; } // no arg constructor


    public static StockOrderTypeChoiceController getInstance() // get instance of the controller
    {
        if (instance == null)
        {
            instance = new StockOrderTypeChoiceController();
            return instance;
        }
        else
            return instance;
    }

    @Override
    public void initialize( URL url, ResourceBundle rb)
    {
        // empty
    }

    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;
    }

    @FXML
    private void foodChoiceClicked( MouseEvent event)
    {
        myController.setPopUpScreen(PopUpScreens.STOCK_FOOD);
    }

    @FXML
    private void toppingsChoiceClicked(MouseEvent event)
    {
        myController.setPopUpScreen(PopUpScreens.STOCK_TOPPING);
    }
//
    @FXML
    private void sideChoiceClicked(MouseEvent event)
    {
        myController.setPopUpScreen(PopUpScreens.STOCK_SIDE);
    }

    @FXML
    private void drinkChoiceClicked(MouseEvent event)
    {
        myController.setPopUpScreen(PopUpScreens.STOCK_DRINK);
    }

    @FXML
    private void backButtonClicked( ActionEvent event)
    {
        ((Button)event.getTarget()).getScene().getWindow().hide();
    }
}
