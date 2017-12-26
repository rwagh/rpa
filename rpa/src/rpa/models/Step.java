package rpa.models;

public class Step {
	private int id;
	private String name;
	private String description;
	private int activityId;
	private String activityName;
	private int processId;
	private String processName;
	private int lobId;
	private String lobName;	
	private int functionId;
	private String functionName;
	private int required;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public int getProcessId() {
		return processId;
	}
	public void setProcessId(int processId) {
		this.processId = processId;
	}
	
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public int getFunctionId() {
		return functionId;
	}
	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public int getLobId() {
		return lobId;
	}
	public void setLobId(int lobId) {
		this.lobId = lobId;
	}
	
	public String getLobName() {
		return lobName;
	}
	public void setLobName(String lobName) {
		this.lobName = lobName;
	}
	public int getRequired() {
		return required;
	}
	public void setRequired(int required) {
		this.required = required;
	}
}
