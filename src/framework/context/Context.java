package framework.context;

public class Context
{
	protected String message;
	
	public Context()
	{
		this(null);
	}
	
	public Context(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public void empty()
	{
		message = null;
	}
}
