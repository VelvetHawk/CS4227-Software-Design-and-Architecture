package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import controllers.memento.RegistrationCaretaker;
import controllers.memento.RegistrationMemento;
import display.views.Screens;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    @FXML private TextField emailTextField;
    @FXML private TextField usernameTextField;
    @FXML private TextField addressTextField;
    @FXML private TextField phoneTextField;
    @FXML private PasswordField password_Field;
    @FXML private PasswordField password_Field1;
    @FXML private Button undoButton;
    @FXML private Button redoButton;
    private ScreensController myController;
    private int counter = 0 ;

    private static Registration instance; // create a static controller instance,

    RegistrationCaretaker caretaker = new RegistrationCaretaker();

    public Registration() {
        instance = this;
    } // no arg constructor


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
    public RegistrationMemento saveToMemento()
    {
        return new RegistrationMemento(
                new TextField(nameTextField.getText()),
                new TextField(surnameTextField.getText()),
                new TextField(emailTextField.getText()),
                new TextField(usernameTextField.getText()),
                new TextField(addressTextField.getText()),
                new TextField(phoneTextField.getText())
        );
    }

    // Undo from memento
    public void undoFromMemento(RegistrationMemento memento)
    {
        String setTextName = memento.getNameTextField().getText();
        String setTextSurname = memento.getSurnameTextField().getText();
        String setTextEmail = memento.getEmailTextField().getText();
        String setTextUser = memento.getUsernameTextField().getText();
        String setTextAdd = memento.getAddressTextField().getText();
        String setTextPhone = memento.getPhoneTextField().getText();
        printToTextField(
                setTextName,
                setTextSurname,
                setTextEmail,
                setTextUser,
                setTextAdd,
                setTextPhone
        );
    }

    public void printToTextField(String name,
                                 String surname,
                                 String email,
                                 String user,
                                 String add,
                                 String phone)
    {
        nameTextField.setText(name);
        surnameTextField.setText(surname);
        emailTextField.setText(email);
        usernameTextField.setText(user);
        addressTextField.setText(add);
        phoneTextField.setText(phone);
    }

    @FXML
    public void undoButton()
    {
        counter--;
        if (counter < 0)
        {
            counter = 0;
            undoButton.setDisable(true);
        }
        else
            undoButton.setDisable(false);
        undoFromMemento(caretaker.getMemento(counter));
    }

    @FXML
    public void saveButton()
    {
        caretaker.addMemento(saveToMemento());
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

    public void setNameTextField(TextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public void setSurnameTextField(TextField surnameTextField) {
        this.surnameTextField = surnameTextField;
    }

    public void setUsernameTextField(TextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public void setEmailTextField(TextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public void setAddressTextField(TextField addressTextField) {
        this.addressTextField = addressTextField;
    }

    public void setPhoneTextField(TextField phoneTextField) {
        this.phoneTextField = phoneTextField;
    }
}
