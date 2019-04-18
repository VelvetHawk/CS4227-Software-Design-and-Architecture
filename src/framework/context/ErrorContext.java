package framework.context;

public class ErrorContext extends Context
{
	private Exception exception;
	
	public ErrorContext(String message, Exception exception)
	{
		this.message = message;
		this.exception = exception;
	}
	
	public Exception getException()
	{
		return exception;
	}
}
