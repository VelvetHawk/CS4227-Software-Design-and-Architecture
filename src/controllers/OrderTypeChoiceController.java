package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import display.views.PopUpScreens;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class OrderTypeChoiceController implements Initializable , ControlledScreen
{
	@FXML private AnchorPane rootPane;
	@FXML private Label paneTitle;
	@FXML private VBox foodChoice;
	@FXML private VBox sideChoice;
	@FXML private VBox drinkChoice;
	@FXML private Button backButton;
	private ScreensController myController;
	private static OrderTypeChoiceController instance; // create a static controller instance,

	public OrderTypeChoiceController() { instance = this; } // no arg constructor


	public static OrderTypeChoiceController getInstance() // get instance of the controller
	{
		if (instance == null)
		{
			instance = new OrderTypeChoiceController();
			return instance;
		}
		else
			return instance;
	}

    @Override
    public void initialize(URL url, ResourceBundle rb)
	{
		// empty
    }
    
    public void setScreenParent(ScreensController screenParent)
	{
        myController = screenParent;
    }
	
    @FXML
    private void foodChoiceClicked(MouseEvent event)
    {
	    myController.setPopUpScreen(PopUpScreens.SELECT_FOOD);
    }
    
	@FXML
	private void sideChoiceClicked(MouseEvent event)
	{
		myController.setPopUpScreen(PopUpScreens.SELECT_SIDE);
	}
	
	@FXML
	private void drinkChoiceClicked(MouseEvent event)
	{
		myController.setPopUpScreen(PopUpScreens.SELECT_DRINK);
	}

	@FXML
	private void mealChoiceClicked(MouseEvent event){ myController.setPopUpScreen(PopUpScreens.SELECT_MEAL); }

    @FXML
    private void backButtonClicked(ActionEvent event)
    {
	    ((Button)event.getTarget()).getScene().getWindow().hide();
    }
}
