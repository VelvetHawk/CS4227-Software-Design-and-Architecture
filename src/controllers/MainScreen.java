package controllers;

import controllers.frontController.FrontController;
import display.views.FrontControllScreens;
import display.views.Screens;
import framework.context.Context;
import framework.context.ScreenSwitchContext;
import framework.states.statemachines.Login;
import framework.states.statemachines.Register;
import javafx.event.ActionEvent;
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
            instance = new MainScreen();
        return instance;
    }
    public void show(){
        System.out.println("Main Screen Page");
    }



      //frontController.dispatchRequest("STUDENT");

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // empty
    }
    
    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;
        FrontController frontController = new FrontController();
        //myController.getFrontController().dispatchRequest("HOME"); //front controller pattern, tracking the
        //frontController.dispatchRequest("HOME"); //front controller pattern, tracking the
        frontController.dispatchRequest(FrontControllScreens.MAIN); //front controller pattern, tracking the
    }

    
    @FXML
    private void goToLogin(ActionEvent event)
    {
        //myController.setScreen(Screens.LOGIN);
        myController.setState(Login.getInstance());
	    myController.getState().executeState(new Context("Idle"));
        myController.executeState(new ScreenSwitchContext(
            "Switching to Login Screen",
	        Screens.LOGIN
        ));
        FrontController frontController = new FrontController();
        //frontController.dispatchRequest("LOGIN"); //front controller pattern, tracking the
        frontController.dispatchRequest(FrontControllScreens.LOGIN); //front controller pattern, tracking the
    }
    
    @FXML
    private void goToRegistration(ActionEvent event)
    {
        //myController.setScreen(Screens.REGISTRATION);
        myController.setState(Register.getInstance());
	    myController.getState().executeState(new Context("Idle"));
	    myController.executeState(new ScreenSwitchContext(
            "Switching to Registration Screen",
		    Screens.REGISTRATION
	    ));
        FrontController frontController = new FrontController();
        //frontController.dispatchRequest("REGISTRATION"); //front controller pattern, tracking the
        frontController.dispatchRequest(FrontControllScreens.REGISTRATION); //front controller pattern, tracking the
    }
}