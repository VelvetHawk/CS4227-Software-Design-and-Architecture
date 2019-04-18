package framework.states.login;

import controllers.LoginScreen;
import framework.context.Context;
import framework.states.State;

public class Invalid implements State
{
	private static Invalid instance;
	
	private Invalid()
	{

	}
	
	public static Invalid getInstance()
	{
		if (instance == null)
			instance = new Invalid();
		return instance;
	}
	
	@Override
	public void executeState(Context context)
	{
		System.out.println("In state invalid");
		LoginScreen.getInstance().setMessage("Invalid login details!");
	}
}
