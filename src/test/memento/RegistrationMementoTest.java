package test.memento;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.TextField;
import memento.RegistrationMemento;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegistrationMementoTest
{
    @Test
    public void testRegistrationMemento() throws Exception
    {
        JFXPanel fxPanel = new JFXPanel();
        TextField nameTextField = new TextField();
        RegistrationMemento rm = new RegistrationMemento(nameTextField, null, null, null, null, null);
        nameTextField.setText("test");
        assertEquals("test", rm.getNameTextField().getText());
    }
}
