package framework.states.login;

import data.models.LoginModel;
import framework.Framework;
import framework.context.Context;
import framework.context.ErrorContext;
import framework.context.LoginContext;
import framework.states.State;

public class Validation implements State
{
	private LoginModel loginModel;
	
	private static Validation instance;
	
	private Validation()
	{
		loginModel = new LoginModel();
	}
	
	public static Validation getInstance()
	{
		if (instance == null)
			instance = new Validation();
		return instance;
	}
	
	@Override
	public void executeState(Context context)
	{
		System.out.println("In state validation");
		try
		{
			boolean valid = loginModel.validateLogin(
				((LoginContext)context).getUserName(),
				((LoginContext)context).getPassword()
			);
			((LoginContext) context).setValidLogin(valid);
		}
		catch (Exception e)
		{
			Framework.getInstance().onLogEvent(
				new ErrorContext(
					"Exception occurred during login",
					e
				)
			);
		}
		
	}
}
