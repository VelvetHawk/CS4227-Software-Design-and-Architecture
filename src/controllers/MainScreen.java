package controllers;

import display.views.Screens;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreen implements Initializable, ControlledScreen
{
    private ScreensController myController;
    private static MainScreen instance; // create a static controller instance,

    public MainScreen() { instance = this; } // no arg constructor


    public static MainScreen getInstance() // get instance of the controller
    {
        if (instance == null)
        {
            instance = new MainScreen();
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
    private void goToLogin(javafx.event.ActionEvent event)
    {
        myController.setScreen(Screens.LOGIN);
    }
    
    @FXML
    private void goToRegistration(javafx.event.ActionEvent event)
    {
        myController.setScreen(Screens.REGISTRATION);
    }
}