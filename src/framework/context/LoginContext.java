package framework.context;

public class LoginContext extends Context
{
	private boolean isValidLogin;
	private String userName;
	private String password;
	
	public LoginContext(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public boolean isValidLogin()
	{
		return isValidLogin;
	}
	
	public void setValidLogin(boolean valid)
	{
		isValidLogin = valid;
	}
}
