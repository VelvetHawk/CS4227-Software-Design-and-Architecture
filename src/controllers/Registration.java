package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import controllers.frontController.FrontController;
import display.views.FrontControllScreens;
import memento.RegistrationCaretaker;
import memento.RegistrationMemento;
import display.views.Screens;
import framework.context.RegisterContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class Registration implements Initializable , ControlledScreen
{
    @FXML private TextField nameTextField;
    @FXML private TextField surnameTextField;
    @FXML private TextField emailTextField;
    @FXML private TextField usernameTextField;
    @FXML private TextField addressTextField;
    @FXML private TextField phoneTextField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField passwordField1;
    @FXML private Button undoButton;
    @FXML private Button redoButton;
    private ScreensController myController;
    private int mementoIndexCounter = 0;
    private int mementoTotalCounter = 0;

    private static Registration instance; // create a static controller instance,

    private RegistrationCaretaker caretaker = new RegistrationCaretaker();

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

    public void show(){
        System.out.println("Registration Screen Page");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        undoButton.setDisable(true);
        redoButton.setDisable(true);
    }
    
    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;
    }

    private void checkRegistration(String name,
                                  String surname,
                                  String user,
                                  String pass,
                                  String email,
                                  String address,
                                  String phone)
    {
        RegisterContext registerContext = new RegisterContext(
	        name, surname, user, pass, email, address, phone
        );
        // Pass to state machine
        myController.getState().executeState(registerContext);
    }
    
    private void clearForm() // Clear form input
    {
        nameTextField.setText("");
        surnameTextField.setText("");
        emailTextField.setText("");
        addressTextField.setText("");
        phoneTextField.setText("");
        usernameTextField.setText("");
        passwordField.setText("");
        passwordField1.setText("");
    }

    public void setMessage(String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void goToLogin(ActionEvent event)
    {
        String name = nameTextField.getText();
        String surname = surnameTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String phone = phoneTextField.getText();
        String password = passwordField.getText();
        String username = usernameTextField.getText();

        if(name.isEmpty() || surname.isEmpty() || email.isEmpty() || address.isEmpty() ||
	        phone.isEmpty() || password.isEmpty() || username.isEmpty())
        {
            setMessage("Please complete the form before press the button"); // popup message
        }
        else if (!passwordField.getText().equals(passwordField1.getText()))
        {
            setMessage("Password field not matched");
        }
        else
        {
            // account type is setup as default to Customers.
            checkRegistration(name, surname, username, password, email, address, phone);
            clearForm();// clear the form once user is registered
            FrontController frontController = new FrontController();
            //frontController.dispatchRequest("LOGIN"); //front controller pattern, tracking the
            frontController.dispatchRequest(FrontControllScreens.LOGIN); //front controller pattern, tracking the
        }
    }

    // Save to memento
    private RegistrationMemento saveToMemento()
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
    private void undoFromMemento(RegistrationMemento memento)
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

    private void printToTextField(String name,
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
        if (mementoIndexCounter >= 1)
        {
            mementoIndexCounter--;
            undoFromMemento(caretaker.getMemento(mementoIndexCounter));
            redoButton.setDisable(false);
        }
        else
            undoButton.setDisable(true);
    }

    @FXML
    public void saveButton()
    {
        caretaker.addMemento(saveToMemento());
        undoButton.setDisable(false);
        redoButton.setDisable(false);
        mementoIndexCounter++;
        mementoTotalCounter++;
    }

    @FXML
    public void redoButton(ActionEvent event)
    {
        if ((mementoTotalCounter - 1) > mementoIndexCounter)
        {
            mementoIndexCounter++;
            redoButton.setDisable(false);
            undoFromMemento(caretaker.getMemento(mementoIndexCounter));
            undoButton.setDisable(false);
        }
        else
            redoButton.setDisable(true);
    }

    @FXML
    private void goToMainScreen(ActionEvent event)
    {
        myController.setScreen(Screens.MAIN);
        FrontController frontController = new FrontController();
//        frontController.dispatchRequest("HOME"); //front controller pattern, tracking the
        frontController.dispatchRequest(FrontControllScreens.MAIN); //front controller pattern, tracking the
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
