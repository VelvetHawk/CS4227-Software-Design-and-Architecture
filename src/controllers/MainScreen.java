package controllers;

import display.views.Screens;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreen implements Initializable, ControlledScreen
{
    private ScreensController myController;
    
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