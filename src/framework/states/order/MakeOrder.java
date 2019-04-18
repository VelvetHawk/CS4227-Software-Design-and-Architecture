package framework.states.order;

import framework.context.Context;
import framework.states.State;

public class MakeOrder implements State
{
	private static MakeOrder instance;
	
	private MakeOrder()
	{
	
	}
	
	public static MakeOrder getInstance()
	{
		if (instance == null)
			instance = new MakeOrder();
		return instance;
	}
	
	@Override
	public void executeState(Context context)
	{
		System.out.println("Currently in MakeOrder state");
	}
}
