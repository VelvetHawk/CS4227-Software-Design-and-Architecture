package framework.states.statemachines;

import framework.Framework;
import framework.context.Context;
import framework.context.LoginContext;
import framework.states.State;
import framework.states.login.Idle;
import framework.states.login.Invalid;
import framework.states.login.Valid;
import framework.states.login.Validation;

public class Login implements State
{
	// This class acts as Finite State Machine (FSM)
	private State currentState;
	
	private static Login instance;
	
	private Login()
	{
		// Init
		
		// Default state
		currentState = Idle.getInstance();
	}
	
	public static Login getInstance()
	{
		if (instance == null)
			instance = new Login();
		return instance;
	}
	
	public State getState()
	{
		return currentState;
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
		if (context instanceof LoginContext)
		{
			// From Idle to validation
			setState(Validation.getInstance());
			// Run Validation
			currentState.executeState(context);
			// Valid
			if (((LoginContext)context).isValidLogin())
			{
				setState(Valid.getInstance());
				currentState.executeState(context);
			}
			else // Invalid
			{
				setState(Invalid.getInstance());
				currentState.executeState(context);
			}
			// Back to Idle
			setState(Idle.getInstance());
			currentState.executeState(context);
		}
		else
			currentState.executeState(context);
	}
}
