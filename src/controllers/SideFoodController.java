package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import consumables.decorators.*;
import consumables.factories.FactoryProducer;
import consumables.side.Sides;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class SideFoodController implements Initializable, ControlledScreen
{
    ScreensController myController;
    private ConsumableFactory sideFactory;
    private static SideFoodController instance; // create a static controller instance,

    public SideFoodController() { instance = this; } // no arg constructor


    public static SideFoodController getInstance() // get instance of the controller
    {
        if (instance == null)
        {
            instance = new SideFoodController();
            return instance;
        }
        else
            return instance;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
	    sideFactory = FactoryProducer.getFactory(Consumables.SIDE);
    }    
    
    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;
    }
    
    @FXML
    private void goToStatic(ActionEvent event)
    {
        ((Button)event.getTarget()).getScene().getWindow().hide();
    }

    @FXML
    private void getBeans(ActionEvent event)
    {
	    addSide(Sides.BEANS);
    }
    
    @FXML
    private void getChips(ActionEvent event)
    {
	    addSide(Sides.CHIPS);
    }
    
    @FXML
    private void getColeslaw(ActionEvent event)
    {
	    addSide(Sides.COLESLAW);
    }
    
    @FXML
    private void getGarlicbread(ActionEvent event)
    {
	    addSide(Sides.GARLICBREAD);
    }
    
    @FXML
    private void getOnionRings(ActionEvent event)
    {
        addSide(Sides.ONIONRINGS);
    }
	
	private void addSide(Sides sideType)
	{
		Consumable side = sideFactory.getSide();
		side = sideFactory.addSide(sideType, side);
		myController.getCustomerOrder().addSide((SideDecorator) side);
	}
}
