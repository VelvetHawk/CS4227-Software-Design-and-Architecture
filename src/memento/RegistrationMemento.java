package memento;

import javafx.scene.control.TextField;

public class RegistrationMemento
{
    private TextField nameTextField;
    private TextField surnameTextField;
    private TextField usernameTextField;
    private TextField emailTextField;
    private TextField addressTextField;
    private TextField phoneTextField;

    public RegistrationMemento(TextField nameTextField,
                               TextField surnameTextField,
                               TextField emailTextField,
                               TextField usernameTextField,
                               TextField addressTextField,
                               TextField phoneTextField)
    {
        this.nameTextField = nameTextField;
        this.surnameTextField = surnameTextField;
        this.usernameTextField = usernameTextField;
        this.emailTextField = emailTextField;
        this.addressTextField = addressTextField;
        this.phoneTextField = phoneTextField;
    }

    public TextField getNameTextField()
    {
        return nameTextField;
    }

    public TextField getSurnameTextField()
    {
        return surnameTextField;
    }

    public TextField getUsernameTextField()
    {
        return usernameTextField;
    }

    public TextField getEmailTextField()
    {
        return emailTextField;
    }

    public TextField getAddressTextField()
    {
        return addressTextField;
    }

    public TextField getPhoneTextField()
    {
        return phoneTextField;
    }
}


