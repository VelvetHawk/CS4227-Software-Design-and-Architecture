package framework.context;

public class RegisterContext extends Context
{
	private boolean isRegistered;
	private String name;
	private String surname;
	private String username;
	private String password;
	private String email;
	private String address;
	private String phone;
	
	public RegisterContext(
		String name,
		String surname,
		String username,
		String password,
		String email,
		String address,
		String phone
	)
	{
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	
	public boolean isRegistered()
	{
		return isRegistered;
	}
	
	public void setRegistration(boolean valid)
	{
		isRegistered = valid;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getSurname()
	{
		return surname;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPhone()
	{
		return phone;
	}
}
