package framework.dispatchers;

import framework.context.Context;
import framework.context.ScreenSwitchContext;
import framework.interceptors.ScreenSwitchInterceptor;

import java.util.ArrayList;

public class ScreenSwitchDispatcher implements Dispatcher
{
	private ArrayList<ScreenSwitchInterceptor> interceptors;
	
	private static ScreenSwitchDispatcher instance;
	
	private ScreenSwitchDispatcher()
	{
		interceptors = new ArrayList<>();
	}
	
	public static ScreenSwitchDispatcher getInstance()
	{
		if (instance == null)
			instance = new ScreenSwitchDispatcher();
		return instance;
	}
	
	public boolean register(ScreenSwitchInterceptor interceptor)
	{
		return interceptors.add(interceptor);
	}
	
	public boolean remove(ScreenSwitchInterceptor interceptor)
	{
		return interceptors.remove(interceptor);
	}
	
	public void onScreenSwitch(Context context)
	{
		for (ScreenSwitchInterceptor interceptor : interceptors)
			interceptor.onScreenSwitch((ScreenSwitchContext) context);
	}
}
