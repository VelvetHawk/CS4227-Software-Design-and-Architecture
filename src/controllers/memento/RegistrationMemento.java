package controllers.memento;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationMemento {

    private String nameString;
    private String surnameString;
    private String usernameString;

    public RegistrationMemento(String nameString, String surnameString, String usernameString) {
        this.nameString = nameString;
        this.surnameString = surnameString;
        this.usernameString = usernameString;
    }

    public String getNameString() {
        return nameString;
    }

    public String getSurnameString() {
        return surnameString;
    }

    public String getUsernameString() {
        return usernameString;
    }
}


