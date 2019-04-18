package framework.states.register;

import data.models.RegisterModel;
import framework.Framework;
import framework.context.Context;
import framework.context.LoginContext;
import framework.context.RegisterContext;
import framework.states.State;
import framework.states.statemachines.Register;

public class Validation implements State
{
	private RegisterModel registerModel;
	
	private static Validation instance;
	
	private Validation()
	{
		try
		{
			registerModel = new RegisterModel();
		}
		catch (Exception e)
		{
			Framework.getInstance().onLogEvent(
				new Context("Registration Model could not be loaded!")
			);
		}
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
		RegisterContext registerContext = (RegisterContext) context;
		try
		{
//			boolean valid =
			// TODO: Finish registration
			registerModel.registerUser(
				registerContext.getName(),
				registerContext.getSurname(),
				registerContext.getUsername(),
				registerContext.getPassword(),
				registerContext.getEmail(),
				registerContext.getAddress(),
				registerContext.getPhone()
				
			);
			//registerContext.setRegistration(valid);
		}
		catch (Exception e)
		{
			System.out.println("Exception occurred during login:");
			e.printStackTrace();
		}
		
	}
}
