package data;

public interface Subject
{
	public void notifyAllObservers();
	public void attach(Observer observer);
}
