package framework.dispatchers;

import framework.context.Context;
import framework.interceptors.LoggingInterceptor;

import java.util.ArrayList;

public class LoggingDispatcher implements Dispatcher
{
	private ArrayList<LoggingInterceptor> interceptors;
	
	private static LoggingDispatcher instance;
	
	private LoggingDispatcher()
	{
		interceptors = new ArrayList<>();
	}
	
	public static LoggingDispatcher getInstance()
	{
		if (instance == null)
			instance = new LoggingDispatcher();
		return instance;
	}
	
	public boolean register(LoggingInterceptor interceptor)
	{
		return interceptors.add(interceptor);
	}
	
	public boolean remove(LoggingInterceptor interceptor)
	{
		return interceptors.remove(interceptor);
	}
	
	public void onLogEvent(Context context)
	{
		for (LoggingInterceptor interceptor : interceptors)
			interceptor.onLogEvent(context);
	}
}
