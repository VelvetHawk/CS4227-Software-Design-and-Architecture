package framework.states.register;

import framework.context.Context;
import framework.states.State;

public class Valid implements State
{
	private static Valid instance;
	
	private Valid()
	{
	
	}
	
	public static Valid getInstance()
	{
		if (instance == null)
			instance = new Valid();
		return instance;
	}
	
	
	@Override
	public void executeState(Context context)
	{
		System.out.println("In state valid");
	}
}
