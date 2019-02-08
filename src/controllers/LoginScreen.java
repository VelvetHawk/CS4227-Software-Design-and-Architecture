package controllers;

import display.views.Screens;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import data.models.LoginModel;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable, ControlledScreen
{
    private LoginModel model;
    private boolean loginValid = false;
    @FXML private TextField username;
    @FXML private PasswordField password;
    private ScreensController myController;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        model = new LoginModel();
    }

    public void setUsername(String uName)
    {
        username.setText(uName);
    }

    public void setPassword(String pass)
    {
        password.setText(pass);
    }

    public void setScreenParent( ScreensController screenParent)
    {
        myController = screenParent;
    }

    private void checkCredentials(String username, char[] password)
    {
        try
        {   // check username and password in model wiht login validations method that's a void method.
            model.loginValidation(username, password);
            loginValid = model.getLogin();
            if(!loginValid)
            {
                setMessage("invalid name or password");
                clear_loging_textFields();  // clear users input
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public boolean getLoginValid()
    {
        return this.loginValid;
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

    // clear text fields
    public void clear_loging_textFields()
    {
        username.setText("");
        password.setText("");
    }
    
    //Called when back button pressed
    @FXML
    private void goToMainScreen(javafx.event.ActionEvent event)
    {
    	// only if the user press back this will return the user to the main screen
        myController.setScreen(Screens.MAIN);
    }
    
    //Called when user attempts to log-in
    @FXML
    private void goToMainMenu(javafx.event.ActionEvent event)
    {
    	// only if the user is successfully logged in then, it'll take the user to the main menu
        String user = username.getText();
        String userpassword = password.getText();
        char [] password1 = userpassword.toCharArray();
        //char [] password =password_field.getText();
        if(user.isEmpty() || password1.length == 0)
            setMessage("Please enter your username and password");
        else
        {
        	// check in the login controller if the user and password are correct.
            checkCredentials(user, password1);
            if(getLoginValid())
                myController.setScreen(Screens.MAIN_MENU);
        }
    }
}
