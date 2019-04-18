package framework.states.login;

import controllers.Registration;
import controllers.ScreensController;
import display.views.Screens;
import framework.context.Context;
import framework.context.ScreenSwitchContext;
import framework.states.State;
import framework.states.main.Main;

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
		System.out.println("In state login.valid");
		ScreensController.getInstance().setState(Main.getInstance());
		ScreensController.getInstance().executeState(
			new ScreenSwitchContext(
				"Switching to Main Menu",
				Screens.MAIN_MENU
		));
		// Execute main
		ScreensController.getInstance().getState().executeState(
			new Context("Idle")
		);
	}
}
