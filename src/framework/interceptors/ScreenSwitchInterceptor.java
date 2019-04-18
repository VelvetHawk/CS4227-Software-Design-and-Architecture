package framework.interceptors;

import framework.context.ScreenSwitchContext;

public class ScreenSwitchInterceptor implements Interceptor
{
	public ScreenSwitchContext onScreenSwitch(ScreenSwitchContext context)
	{
		System.out.println("Log: " + context.getMessage());
		return context;
	}
}