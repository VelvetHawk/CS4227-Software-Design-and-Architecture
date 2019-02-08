package data.accounts;

public abstract class Account
{
	protected String name;
	protected String surname;
	protected String username;
	protected String password;
	protected String email;
	protected String phone;
	protected String address;
	protected int points;
	
	public Account()
	{
	
	}

	Account(String name, String surname, String username, String password, String phone, String address)
	{
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getPoints()
	{
		return points;
	}

	public void setPoints(int points)
	{
		this.points = points;
	}
}
