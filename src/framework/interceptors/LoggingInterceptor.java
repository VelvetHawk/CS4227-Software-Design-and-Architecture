package framework.interceptors;

import framework.context.Context;
import framework.context.ErrorContext;

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
		if (context instanceof ErrorContext)
		{
			System.out.println(((ErrorContext)context).getException().getMessage());
		}
		return context;
	}
}
