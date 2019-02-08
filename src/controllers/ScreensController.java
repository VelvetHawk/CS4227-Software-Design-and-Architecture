package controllers;

import java.util.HashMap;
import consumables.Order;
import display.views.PopUpScreens;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import display.views.Screens;

public class ScreensController extends StackPane
{
    // The screens to be displayed
    private HashMap<Screens, Node> screens = new HashMap<>();
	private HashMap<PopUpScreens, Stage> popUpScreens = new HashMap<>();
	// Customer data
	private Order customerOrder;
	
    public ScreensController()
	{
        super();
		customerOrder = new Order();
    }
    
    public Order getCustomerOrder()
    {
    	return customerOrder;
    }
    
    public void completeCustomerOrder()
    {
        /*
            - Connect to DB, log order
            - Link it it customer
            - Create new order object
         */
    }

    //Add the screen to the collection
    public void addScreen(Screens name, Node screen)
    {
        screens.put((Screens) name, screen);
    }
    
    public void addPopUp(PopUpScreens name, Stage screen)
    {
	    popUpScreens.put((PopUpScreens) name, screen);
    }

    //Returns the Node with the appropriate name
    public Node getScreen(Screens name)
    {
    	return screens.get(name);
    }
    
    public void getPopUpScreen(PopUpScreens name)
    {
	    popUpScreens.get(name).show();
    }

    //Loads the fxml file, add the screen to the screens collection and
    //finally injects the screenPane to the controller.
    public boolean loadScreen(Screens name, String resource)
	{
        try
        {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController());
            myScreenControler.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean loadPopUpScreen(PopUpScreens name, String resource)
    {
	    try
	    {
		    FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
		    Parent root = (Parent) myLoader.load();
		    ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController());
		    myScreenControler.setScreenParent(this);
		    // Create a stage and add onClose functionality
		    Stage popUpWindow = new Stage();
		    popUpWindow.setScene(new Scene(root, 700, 500));
		    // Event logic
		    popUpWindow.setOnCloseRequest(closeEvent -> ((Stage)closeEvent.getTarget()).hide());
		    // Defaults
		    popUpWindow.initModality(Modality.APPLICATION_MODAL);
		    popUpWindow.hide(); // Default is hidden
		    // Add to list of popups
		    addPopUp(name, popUpWindow);
		    return true;
	    }
	    catch (Exception e)
	    {
		    System.out.println(e.getMessage());
		    return false;
	    }
    }

    //This method tries to displayed the screen with a predefined name.
    //First it makes sure the screen has been already loaded.  Then if there is more than
    //one screen the new screen is been added second, and then the current screen is removed.
    // If there isn't any screen being displayed, the new screen is just added to the root.
    public boolean setScreen(final Screens screen)
	{
	    if (screens.get(screen) != null)
	    {   //screen loaded
		    final DoubleProperty opacity = opacityProperty();
		    if (!getChildren().isEmpty())
		    {    //if there is more than one screen
			    Timeline fade = new Timeline(
				    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
				    new KeyFrame(new Duration(200), t ->
				    {
					    getChildren().remove(0);                    //remove the displayed screen
					    getChildren().add(0, screens.get(screen));     //add the screen
					    Timeline fadeIn = new Timeline(
						    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
						    new KeyFrame(new Duration(200), new KeyValue(opacity, 1.0)));
					    fadeIn.play();
				    }, new KeyValue(opacity, 0.0))
			    );
			    fade.play();
		    }
		    else
	        {
			    setOpacity(0.0);
			    getChildren().add(screens.get(screen));       //no one else been displayed, then just show
			    Timeline fadeIn = new Timeline(
				    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
				    new KeyFrame(new Duration(200), new KeyValue(opacity, 1.0))
			    );
			    fadeIn.play();
		    }
		    return true;
	    }
	    else
		    return false;
    }
    
    public void setPopUpScreen(PopUpScreens screen)
    {
	    popUpScreens.get(screen).show();
    }
}