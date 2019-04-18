package framework.interceptors;

import framework.context.Context;

public class LoggingInterceptor implements Interceptor
{
	private static LoggingInterceptor instance;
	
	private LoggingInterceptor()
	{
	
	}
	
	public static LoggingInterceptor getInstance()
	{
		if (instance == null)
			instance = new LoggingInterceptor();
		return instance;
	}
	
	public Context onLogEvent(Context context)
	{
		System.out.println("Log: " + context.getMessage());
		return context;
	}
}
