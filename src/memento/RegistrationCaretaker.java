package memento;

import java.util.ArrayList;

public class RegistrationCaretaker
{
    private ArrayList<RegistrationMemento> mementos = new ArrayList<>();

    public RegistrationMemento getMemento(int index)
    {
        return mementos.get(index);
    }

    public void addMemento(RegistrationMemento memento)
    {
        mementos.add(memento);
    }

    public void printTheDifferentMementosCurrentlyStored() {
        System.out.println("size of mementos: "+ mementos.size());
        for (int i = 0; i < mementos.size(); i++) {
            System.out.println("Iteration: " + i);
            System.out.println("Name:"+mementos.get(i).getNameTextField().getText());
            System.out.println("Surname:"+mementos.get(i).getSurnameTextField().getText());
            System.out.println("Email:"+mementos.get(i).getEmailTextField().getText());
            System.out.println("username:"+mementos.get(i).getUsernameTextField().getText());
            System.out.println("Address:"+mementos.get(i).getAddressTextField().getText());
            System.out.println("Phone:"+mementos.get(i).getPhoneTextField().getText());
        }
    }
}
