package framework.states.register;

import controllers.ScreensController;
import display.views.Screens;
import framework.context.Context;
import framework.context.ScreenSwitchContext;
import framework.states.State;
import framework.states.statemachines.Login;

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
		System.out.println("In state register.valid");
		ScreensController.getInstance().setState(Login.getInstance());
		ScreensController.getInstance().executeState(
			new ScreenSwitchContext(
				"Switching to Login Screen",
				Screens.LOGIN
			));
		// Execute main
		ScreensController.getInstance().getState().executeState(
			new Context("Idle")
		);
		
	}
}
