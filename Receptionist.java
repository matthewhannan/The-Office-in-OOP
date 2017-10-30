public class Receptionist extends Employee{
	private AssistantRegionalManager supervisor;
     private int maxTaskComplexityLevel;
	//equals method. Do not edit!
	public boolean equals(Receptionist r){
		boolean equal = super.equals(r);
		equal = equal && (r.getSupervisor().equals(supervisor));
		equal = equal && (r.getMaxTaskComplexityLevel() == maxTaskComplexityLevel);
		return equal;
	}
	//constructor
	Receptionist(int IDNumber, String name, Task[] taskList, AssistantRegionalManager supervisor, int maxTaskComplexityLevel){
		super(IDNumber, name, taskList);
		this.supervisor = supervisor;
		this.maxTaskComplexityLevel = maxTaskComplexityLevel;
	}
	//setters and getters
	public AssistantRegionalManager getSupervisor(){
		return supervisor;
	}
	public void setSupervisor(AssistantRegionalManager supervisor){
		this.supervisor = supervisor;
	}
	public int getMaxTaskComplexityLevel(){
		return maxTaskComplexityLevel;
	}
	public void setMaxTaskComplexityLevel(int maxTaskComplexityLevel){
		this.maxTaskComplexityLevel = maxTaskComplexityLevel;
	}
	/**
	 * @return String final receptionist string
	 */
	public String toString(){
		//builds receptionist string
		String RString = "Receptionist\n"+super.toString()+"\nAssistant Regional Manager: "+supervisor.getName()+"\nMax Task Level: "+maxTaskComplexityLevel;
		return RString;
	}
}

