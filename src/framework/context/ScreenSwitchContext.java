package framework.context;

import display.views.Screens;

public class ScreenSwitchContext extends Context
{
	private Screens screenType;
	
	public ScreenSwitchContext()
	{
		this(null, null);
	}
	
	public ScreenSwitchContext(String message, Screens screenType)
	{
		this.message = message;
		this.screenType = screenType;
	}
	
	public Screens getScreenType()
	{
		return screenType;
	}
	
	public void setScreenType(Screens screenType)
	{
		this.screenType = screenType;
	}
}
