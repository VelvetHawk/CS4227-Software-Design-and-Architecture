package data.accounts;

public class StaffAccount extends Account
{
	protected int staffNumber;
	protected Employee employeeType;

	public int getStaffNumber()
	{
		return staffNumber;
	}

	public void setStaffNumber(int staffNumber)
	{
		this.staffNumber = staffNumber;
	}

	public Employee getEmployeeType()
	{
		return employeeType;
	}

	public void setEmployeeType(Employee employeeType)
	{
		this.employeeType = employeeType;
	}
}
