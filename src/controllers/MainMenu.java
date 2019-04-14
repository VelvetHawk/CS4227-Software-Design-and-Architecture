package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import display.views.Screens;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MainMenu implements Initializable, ControlledScreen
{
    private ScreensController myController;
    private static MainMenu instance; // create a static controller instance,

    public MainMenu() { instance = this; } // no arg constructor


    public static MainMenu getInstance() // get instance of the controller
    {
        if (instance == null)
        {
            instance = new MainMenu();
            return instance;
        }
        else
            return instance;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    
    }

    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;
    }

    @FXML
    private void goToMainScreen(ActionEvent event)
    {
        myController.setScreen(Screens.MAIN);
    }

    @FXML
    private void goToOrderScreen(ActionEvent event)
    {
        myController.setScreen(Screens.MAKE_ORDER);
    }
}
