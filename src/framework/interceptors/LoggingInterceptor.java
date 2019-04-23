package framework.interceptors;

import adapters.AdapterType;
import adapters.ConsoleAdapter;
import adapters.GraylogAdapter;
import adapters.LogAdapter;
import framework.context.Context;
import framework.context.ErrorContext;

import java.util.logging.Level;


public class LoggingInterceptor implements Interceptor
{
	private LogAdapter logAdapter;
	
	private static LoggingInterceptor instance;
	
	private LoggingInterceptor(LogAdapter logAdapter)
	{
		/*
    	    Host: "192.168.56.104",
			Default Port: 9000
	        Configured Port: 12201
    	 */
		this.logAdapter = logAdapter;
	}
	
	public static LoggingInterceptor getInstance(AdapterType adapterType)
	{
		if (instance == null)
		{
			switch (adapterType)
			{
				case CONSOLE:   instance = new LoggingInterceptor(new ConsoleAdapter());    break;
				case GRAYLOG:   instance = new LoggingInterceptor(new GraylogAdapter());    break;
			}
		}
		return instance;
	}
	
	public Context onLogEvent(Context context)
	{
		logAdapter.info(context.getMessage());
		if (context instanceof ErrorContext)
		{
			logAdapter.log(Level.SEVERE, ((ErrorContext)context).getException().getMessage());
		}
		return context;
	}
}
