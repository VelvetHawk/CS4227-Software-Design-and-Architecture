package framework.states.entry;

import framework.context.Context;
import framework.states.State;

public class Idle implements State
{
	private static Idle instance;
	
	private Idle()
	{
	
	}
	
	public static Idle getInstance()
	{
		if (instance == null)
			instance = new Idle();
		return instance;
	}
	
	@Override
	public void executeState(Context context)
	{
		System.out.println("Currently in entry.Idle state");
	}
}
