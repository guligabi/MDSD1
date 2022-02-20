package main;

import main.metamodel.IntegerVariable;
import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class MachineInterpreter {

	Machine running;
	public void run(Machine m) {
		running = m;
		running.current = m.initial;
	}

	public State getCurrentState() {
		
		return running.current;
	}

	public void processEvent(String string) {
		var eventObj = new Object(){ Transition trans = null; };
        running.states.forEach((State) -> {
        	if(State == running.current) {
            	State.transitions.forEach((Transition) -> {
            		if(Transition.getEvent().equals(string))
            		{
            			eventObj.trans = Transition;
            		}
            	});
        	}
        });
        
        if(eventObj.trans != null)
        {
        	if(eventObj.trans.hasOperation()) {
        		
        		if(eventObj.trans.hasIncrementOperation()) {
        			running.getInteger(eventObj.trans.getOperationVariableName().toString()).Value++;
        		}
        		if(eventObj.trans.hasDecrementOperation()) {
        			running.getInteger(eventObj.trans.getOperationVariableName().toString()).Value--;
        		}
        	}
        	
        	if(!eventObj.trans.isConditional()) {
        		running.current = eventObj.trans.getTarget();
        	}
        	else
        	{
        		if(eventObj.trans.isConditionEqual())
        		{
        			if(running.getInteger(eventObj.trans.getConditionVariableName().toString()).Value == eventObj.trans.getConditionComparedValue())
        			{
        				running.current = eventObj.trans.getTarget();
        			}
        		}
        		if(eventObj.trans.isConditionGreaterThan())
        		{
        			if(running.getInteger(eventObj.trans.getConditionVariableName().toString()).Value > eventObj.trans.getConditionComparedValue())
        			{
        				running.current = eventObj.trans.getTarget();
        			}
        		}
        		if(eventObj.trans.isConditionLessThan())
        		{
        			if(running.getInteger(eventObj.trans.getConditionVariableName().toString()).Value < eventObj.trans.getConditionComparedValue())
        			{
        				running.current = eventObj.trans.getTarget();
        			}
        		}
        	}
        }
	}

	public int getInteger(String string) {
		
		var integerObj = new Object(){ IntegerVariable value = null; };
        running.integers.forEach((Integer) -> {
        	if(Integer.Name.equals(string))
        	{
        		integerObj.value = Integer;
        	}
        });
        return integerObj.value.Value;
	}

}
