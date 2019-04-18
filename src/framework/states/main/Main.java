package framework.states.main;

import framework.context.Context;
import framework.states.State;

public class Main implements State
{
	private static Main instance;
	
	private Main()
	{
	
	}
	
	public static Main getInstance()
	{
		if (instance == null)
			instance = new Main();
		return instance;
	}
	
	@Override
	public void executeState(Context context)
	{
		System.out.println("Currently in Main state");
	}
}
