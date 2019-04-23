package framework.interceptors;

import framework.context.Context;
import framework.context.ErrorContext;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingInterceptor implements Interceptor
{
	private Logger log;
	
	private static LoggingInterceptor instance;
	
	private LoggingInterceptor()
	{
		/*
    	    Host: "192.168.56.104",
			Default Port: 9000
	        Configured Port: 12201
    	 */
		System.setProperty("java.util.logging.config.file", new File("cs4227.properties").getAbsolutePath());
		log = Logger.getLogger("Restaurant");
	}
	
	public static LoggingInterceptor getInstance()
	{
		if (instance == null)
			instance = new LoggingInterceptor();
		return instance;
	}
	
	public Context onLogEvent(Context context)
	{
		log.info(context.getMessage());
		if (context instanceof ErrorContext)
		{
			log.log(Level.SEVERE, ((ErrorContext)context).getException().getMessage());
		}
		return context;
	}
}
