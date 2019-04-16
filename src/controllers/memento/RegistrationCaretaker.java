package controllers.memento;

import java.util.ArrayList;

public class RegistrationCaretaker {

    ArrayList<RegistrationMemento> mementos = new ArrayList<RegistrationMemento>();

    public RegistrationCaretaker() {
        System.out.println("RegistrationCaretaker has been initiated");
    }

    public RegistrationMemento getMemento(int index)
    {
        return mementos.get(index);
    }

    public void addMemento(RegistrationMemento memento)
    {
        mementos.add(memento);
    }

    public void printTheDifferentMementosCurrentlyStored() {
        System.out.println(mementos.size());
        for (int i = 0; i < mementos.size(); i++) {
            System.out.println("Iteration: " + i);
            System.out.println("1:"+mementos.get(i).getNameString());
            System.out.println("2:"+mementos.get(i).getSurnameString());
            System.out.println("3:"+mementos.get(i).getUsernameString());
        }
    }
}
