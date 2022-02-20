package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;
import main.metamodel.IntegerVariable;

import java.util.List;
import java.util.ArrayList;

public class StateMachine {

	private Machine statemachine;
	private State lastState;
	private List<State> states;
	private String transitionCondition;
	private Transition currentTransition;
	
	public StateMachine()
	{
		states = new ArrayList<State>();
		this.build();
	}
	
	public Machine build() {
		if(statemachine == null)
		{
			statemachine = new Machine(states);	
		}
		else
		{
			statemachine.states = states;
		}
		return statemachine;
	}

	public StateMachine state(String string) {
		lastState = statemachine.getState(string);
		return this;
	}

	public StateMachine initial() {
		statemachine.initial = lastState;
		return this;
	}

	public StateMachine when(String string) {
		transitionCondition = string;
		return this;
	}

	public StateMachine to(String string) {
		currentTransition = new Transition(transitionCondition, statemachine.getState(string));
		lastState.transitions.add(currentTransition);
		return this;
	}

	public StateMachine integer(String string) {
		statemachine.integers.add(new IntegerVariable(string,0));
		return this;
	}

	public StateMachine set(String string, int i) {
		IntegerVariable obj = statemachine.getInteger(string);
		obj.Value = i;
		currentTransition.setOperation(true);
		currentTransition.setOperationName(string);
		return this;
	}

	public StateMachine increment(String string) {
		currentTransition.setIncrementOperation(true);
		currentTransition.setOperationName(string);
		//statemachine.getInteger(string).Value++;

		return this;
	}

	public StateMachine decrement(String string) {
		currentTransition.setDecrementOperation(true);
		currentTransition.setOperationName(string);
		//statemachine.getInteger(string).Value--;
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		currentTransition.setEqualsCondition(true);
		currentTransition.setConditionName(string);
		currentTransition.setConditional(true);
		currentTransition.setTargetValue(i);
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		currentTransition.setGreaterThanCondition(true);
		currentTransition.setConditionName(string);
		currentTransition.setConditional(true);
		currentTransition.setTargetValue(i);
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		currentTransition.setLessThanCondition(true);
		currentTransition.setConditionName(string);
		currentTransition.setConditional(true);
		currentTransition.setTargetValue(i);
		return this;
	}

}
