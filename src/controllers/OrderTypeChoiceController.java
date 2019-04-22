package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import consumables.food.Food;
import controllers.frontController.FrontController;
import display.views.FrontControllScreens;
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
	public void show(){
		System.out.println("Order Type choice Screen Page");
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
		FrontController.getInstance().dispatchRequest(FrontControllScreens.SELECT_FOOD);// front controller pattern
    }
    
	@FXML
	private void sideChoiceClicked(MouseEvent event)
	{
		myController.setPopUpScreen(PopUpScreens.SELECT_SIDE);
		FrontController.getInstance().dispatchRequest(FrontControllScreens.SELECT_SIDE);// front controller pattern
	}
	
	@FXML
	private void drinkChoiceClicked(MouseEvent event)
	{
		myController.setPopUpScreen(PopUpScreens.SELECT_DRINK);
		FrontController.getInstance().dispatchRequest(FrontControllScreens.SELECT_DRINK);// front controller pattern
	}

	@FXML
	private void mealChoiceClicked(MouseEvent event){
		myController.setPopUpScreen(PopUpScreens.SELECT_MEAL);
		FrontController.getInstance().dispatchRequest(FrontControllScreens.SELECT_MEAL);
	}

    @FXML
    private void backButtonClicked(ActionEvent event)
    {
	    ((Button)event.getTarget()).getScene().getWindow().hide();
	    FrontController.getInstance().dispatchRequest(FrontControllScreens.MAKE_ORDER);// front controller pattern
    }
}
