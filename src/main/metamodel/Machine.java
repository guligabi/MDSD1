package main.metamodel;

import java.util.List;
import java.util.ArrayList;

public class Machine {

	public State initial;
	public List<State> states;
	public State current;
	public List<IntegerVariable> integers;
	
	public Machine(List<State> states)
	{
		integers = new ArrayList<IntegerVariable>();
		this.states = states;
	}
	
	public List<State> getStates() {
		return states;
	}

	public State getInitialState() {
		return initial;
	}

	public State getState(String string) {
		var stateObj = new Object(){ State value = null; };
        states.forEach((State) -> {
        	if(State.Name.equals(string))
        	{
        		stateObj.value = State;
        	}
        });
        
        if(stateObj.value == null)
        {
        	stateObj.value = new State(string);
        	states.add(stateObj.value);
        }
        
        return stateObj.value;
	}

	public int numberOfIntegers() {
		return integers.size();
	}

	public boolean hasInteger(String string) {

		var isFound = new Object(){ boolean value = false; };
        integers.forEach((Integer) -> {
        	if(Integer.Name.equals(string))
        	{
        		isFound.value = true;
        	}
        });
		
		return isFound.value;
	}
	
	public IntegerVariable getInteger(String string)
	{
		var integerObj = new Object(){ IntegerVariable value = null; };
        integers.forEach((Integer) -> {
        	if(Integer.Name.equals(string))
        	{
        		integerObj.value = Integer;
        	}
        });
        return integerObj.value;
	}

}
