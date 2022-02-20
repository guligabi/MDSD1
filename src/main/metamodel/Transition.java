package main.metamodel;

public class Transition {

	private boolean setoperation;
	private boolean incrementoperation;
	private boolean decrementoperation;
	private boolean conditional;
	private boolean conditiongreaterthan;
	private boolean conditionequal;
	private boolean conditionlessthan;
	private boolean hasoperation;
	
	private String eventName;
	private String operationName;
	private String conditionName;
	private int targetValue;
	private State target;
	
	public Transition(String name, State target)
	{
		eventName = name;
		this.target = target;
	}
	
	public Object getEvent() {
		return eventName;
	}

	public State getTarget() {
		return target;
	}

	public boolean hasSetOperation() {
		return setoperation;
	}

	public boolean hasIncrementOperation() {
		return incrementoperation;
	}

	public boolean hasDecrementOperation() {
		return decrementoperation;
	}

	public Object getOperationVariableName() {
		return operationName;
	}

	public boolean isConditional() {
		return conditional;
	}

	public Object getConditionVariableName() {
		return conditionName;
	}

	public Integer getConditionComparedValue() {
		return targetValue;
	}

	public boolean isConditionEqual() {
		return conditionequal;
	}

	public boolean isConditionGreaterThan() {
		return conditiongreaterthan;
	}

	public boolean isConditionLessThan() {
		return conditionlessthan;
	}

	public boolean hasOperation() {
		return hasoperation;
	}

	public void setOperation(boolean value) {
		setoperation = value;
		if(value)
		{
			hasoperation = true;
		}
	}
	public void setIncrementOperation(boolean value) {
		incrementoperation = value;
		if(value)
		{
			hasoperation = true;
		}
	}
	public void setDecrementOperation(boolean value) {
		decrementoperation = value;
		if(value)
		{
			hasoperation = true;
		}
	}
	public void setOperationName(String value) {
		operationName = value;
	}
	public void setConditionName(String value) {
		conditionName = value;
	}
	public void setGreaterThanCondition(boolean value) {
		conditiongreaterthan = value;
	}
	public void setEqualsCondition(boolean value) {
		conditionequal = value;
	}
	public void setLessThanCondition(boolean value) {
		conditionlessthan = value;
	}
	public void setConditional(boolean value) {
		conditional = value;
	}
	public void setTargetValue(int value) {
		targetValue = value;
	}
}
