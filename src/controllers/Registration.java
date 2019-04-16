package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import controllers.memento.RegistrationCaretaker;
import controllers.memento.RegistrationMemento;
import display.views.Screens;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import data.models.RegisterModel;

public class Registration implements Initializable , ControlledScreen
{
    private RegisterModel model;
    @FXML private TextField nameTextField;
    @FXML private TextField surnameTextField;
    @FXML private TextField usernameTextField;
    @FXML private TextField emailTextField;
    @FXML private TextField addressTextField;
    @FXML private TextField phoneTextField;
    @FXML private PasswordField password_Field;
    @FXML private PasswordField password_Field1;
    private ScreensController myController;
    private String nameString;
    private String surnameString;
    private String usernameString;
    private String emailString;
    private String addressString;
    private String phoneString;
    int counter = 0 ;

    private static Registration instance; // create a static controller instance,

    RegistrationCaretaker caretaker = new RegistrationCaretaker();


    public Registration() { instance = this; } // no arg constructor


    public static Registration getInstance() // get instance of the controller
    {
        if (instance == null) {
            instance = new Registration();
            return instance;
        } else
            return instance;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            model = new RegisterModel();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;
    }

    public void checkRegistration(String name,
                                  String surname,
                                  String user,
                                  char[] pass,
                                  String email,
                                  String address,
                                  String phone) throws Exception
    {
        try
        {
            boolean alreadyRegistered = model.checkRegistered(user, pass);
            if (!alreadyRegistered)
            {
                //User is not already registered, so register them
                model.registerUser(name, surname, user, pass, email, address, phone);
                boolean registered = model.getRegistered();
                if (registered)
                {
                    setMessage("Successfuly registered");
                    // when the user is successfully registered, the login page will be loaded
                    myController.setScreen(Screens.LOGIN);
                }
                else
                    setMessage("Error registering");
            }
            else
                setMessage("User already exists");
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
    }
    
    public void clearForm() // Clear form input
    {
        nameTextField.setText("");
        surnameTextField.setText("");
        emailTextField.setText("");
        addressTextField.setText("");
        phoneTextField.setText("");
        usernameTextField.setText("");
        password_Field.setText("");
        password_Field1.setText("");
    }

    public void setMessage(String message)
    {
        System.out.println(message);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void goToLogin(ActionEvent event) throws Exception
    {
        String name = nameTextField.getText();
        String surname = surnameTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String phone = phoneTextField.getText();
        String password = password_Field.getText();
        String username = usernameTextField.getText();
        char[] passwordChar = password.toCharArray();

        if(name.isEmpty() || surname.isEmpty() || email.isEmpty() || address.isEmpty() ||
	        phone.isEmpty() || password.isEmpty() || username.isEmpty() || passwordChar.length == 0)
        {
            setMessage("Please complete the form before press the button"); // popup message
        }
        else if (!password_Field.getText().equals(password_Field1.getText()))
        {
            setMessage("Password field not matched");
        }
        else
        {
            // account type is setup as default to Customers.
            checkRegistration(name, surname, username, passwordChar, email, address, phone);
            clearForm();// clear the form once user is registered
        }
    }

    // Save to memento
    public RegistrationMemento saveToMemento() {
        return new RegistrationMemento(nameString,surnameString,usernameString);
    }

    // Undo from memento
    public void undoFromMemento(RegistrationMemento memento)
    {
        String s1 = memento.getNameString();
        String s2 = memento.getSurnameString();
        String s3 = memento.getUsernameString();
        printToTextField(s1,s2,s3);
    }

    public void printToTextField(String a, String b, String c) {
        nameTextField.setText(a);
        surnameTextField.setText(b);
        usernameTextField.setText(c);
    }

    @FXML
    public void undoButton()
    {
        counter--;
        undoFromMemento(caretaker.getMemento(counter));
    }

    @FXML
    public void saveButton()
    {
        String s1 = nameTextField.getText();
        String s2 = surnameTextField.getText();
        String s3 = usernameTextField.getText();

        nameString = s1;
        surnameString = s2;
        usernameString = s3;

        caretaker.addMemento(instance.saveToMemento());
        counter++;
    }

    @FXML
    public void redoButton(ActionEvent event)
    {
        System.out.println("redo");
    }

    @FXML
    private void goToMainScreen(ActionEvent event) throws Exception
    {
        myController.setScreen(Screens.MAIN);
    }

    public void printMementos() {
        caretaker.printTheDifferentMementosCurrentlyStored();
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public void setSurnameString(String surnameString) {
        this.surnameString = surnameString;
    }

    public void setUsernameString(String usernameString) {
        this.usernameString = usernameString;
    }

    public void setEmailString(String emailString) {
        this.emailString = emailString;
    }

    public void setAddressString(String addressString) {
        this.addressString = addressString;
    }

    public void setPhoneString(String phoneString) {
        this.phoneString = phoneString;
    }
}
