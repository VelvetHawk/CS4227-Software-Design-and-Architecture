package framework.states.statemachines;

import framework.Framework;
import framework.context.Context;
import framework.context.RegisterContext;
import framework.states.State;
import framework.states.register.Idle;
import framework.states.register.Validation;

public class Register implements State
{
	// This class acts as Finite State Machine (FSM)
	private State currentState;
	
	private static Register instance;
	
	private Register()
	{
		// Init
		
		// Default state
		currentState = Idle.getInstance();
	}
	
	public static Register getInstance()
	{
		if (instance == null)
			instance = new Register();
		return instance;
	}
	
	public void setState(State state)
	{
		// Log state change
		Framework.getInstance().onLogEvent(
			new Context(String.format(
				"'%s' switching from state '%s' to state '%s'",
				this.getClass().getName(),
				currentState.getClass().getName(),
				state.getClass().getName()
			))
		);
		// Change state
		currentState = state;
	}
	
	@Override
	public void executeState(Context context)
	{
		if (context instanceof RegisterContext)
		{
//			// From Idle to validation
//			setState(Validation.getInstance());
//			// Run Validation
//			currentState.executeState(context);
//			// Valid
//			if (((RegisterContext)context).isValidLogin())
//			{
//				setState(Valid.getInstance());
//				currentState.executeState(context);
//			}
//			else // Invalid
//			{
//				setState(Invalid.getInstance());
//				currentState.executeState(context);
//			}
//			// Back to Idle
//			setState(Idle.getInstance());
//			currentState.executeState(context);
		}
		else
			currentState.executeState(context);
	}
}