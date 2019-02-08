package data.accounts;

public class CustomerAccount extends Account
{
	protected int customerNumber;
	protected int customerPoints;

	public int getCustomerNumber()
	{
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber)
	{
		this.customerNumber = customerNumber;
	}

	public int getCustomerPoints()
	{
		return customerPoints;
	}

	public void setCustomerPoints(int customerPoints)
	{
		this.customerPoints = customerPoints;
	}
}
