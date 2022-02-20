package main.metamodel;

import java.util.List;
import java.util.ArrayList;

public class State {

	public String Name;
	public List<Transition> transitions;
	
	public State(String name)
	{
		Name = name;
		transitions = new ArrayList<Transition>();
	}
	
	public Object getName() {
		return Name;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public Transition getTransitionByEvent(String string) {
		var transitionObj = new Object(){ Transition value = null; };
        transitions.forEach((transition) -> {
        	if(transition.getEvent() == string)
        	{
        		transitionObj.value = transition;
        	}
        });
		return transitionObj.value;
	}

}
