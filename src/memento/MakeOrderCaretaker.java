package memento;

import java.util.ArrayList;

public class MakeOrderCaretaker
{
    private ArrayList<MakeOrderMemento> mementos = new ArrayList<>();

    public MakeOrderMemento getMemento(int index)
    {
        return mementos.get(index);
    }

    public void addMemento(MakeOrderMemento memento)
    {
        mementos.add(memento);
    }
}
