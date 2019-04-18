package framework.states.register;

import controllers.Registration;
import data.models.RegisterModel;
import framework.Framework;
import framework.context.*;
import framework.states.State;

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
				new ErrorContext(
					"Registration Model could not be loaded!",
					e
				)
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
		System.out.println("In state register.validation");
		RegisterContext registerContext = (RegisterContext) context;
		
		if (!registerContext.isRegistered())
		{
			try
			{
				//User is not already registered, so register them
				registerModel.registerUser(
					registerContext.getName(),
					registerContext.getSurname(),
					registerContext.getUsername(),
					registerContext.getPassword(),
					registerContext.getEmail(),
					registerContext.getAddress(),
					registerContext.getPhone()
				);
				// Mark that user is now registered
				registerContext.setRegistration(true);
				// Inform user
				Registration.getInstance().setMessage("Successfuly registered");
			}
			catch (Exception e)
			{
				Framework.getInstance().onLogEvent(
					new ErrorContext(
						"Error during registration",
						e
					)
				);
				Registration.getInstance().setMessage("Error registering");
			}
		}
		else
			Registration.getInstance().setMessage("User already exists");
	}
}
