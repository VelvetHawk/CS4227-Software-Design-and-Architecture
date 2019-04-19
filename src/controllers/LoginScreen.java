package controllers;

import display.views.Screens;
import framework.context.Context;
import framework.context.LoginContext;
import framework.context.ScreenSwitchContext;
import framework.states.entry.Idle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable, ControlledScreen
{
    @FXML private TextField username;
    @FXML private PasswordField password;
    private ScreensController myController;

    private static LoginScreen instance; // create a static controller instance,

    public LoginScreen() { instance = this; } // no arg constructor


    public static LoginScreen getInstance() // get instance of the controller
    {
        if (instance == null)
            instance = new LoginScreen();
        return instance;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // empty
    }

    public void setUsername(String uName)
    {
        username.setText(uName);
    }

    public void setPassword(String pass)
    {
        password.setText(pass);
    }

    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;
    }
    
    public void setMessage(String message)      // get the dialog box for any errors in the validations
    {
        System.out.println(message);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login");
        alert.setHeaderText("Login, Information");
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    //Called when back button pressed
    @FXML
    private void goToMainScreen(ActionEvent event)
    {
    	// only if the user press back this will return the user to the Main screen
        //myController.setScreen(Screens.MAIN);
	    myController.setState(Idle.getInstance());
	    myController.getState().executeState(new Context("Idle"));
	    myController.executeState(new ScreenSwitchContext(
            "Going back to main menu",
		    Screens.MAIN
        ));
	    
    }
    
    //Called when user attempts to log-in
    @FXML
    private void goToMainMenu(ActionEvent event)
    {
    	// only if the user is successfully logged in then, it'll take the user to the Main menu
        String user = username.getText();
        String userPassword = password.getText();
        
        if(user.isEmpty() || userPassword.length() == 0)
            setMessage("Please enter your username and password");
        else
        {
        	// Pass Login Context to state machine
	        LoginContext loginContext = new LoginContext(user, userPassword);
        	myController.getState().executeState(loginContext);
        }
    }
}
