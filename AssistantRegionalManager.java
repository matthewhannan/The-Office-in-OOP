public class AssistantRegionalManager extends Employee{
	private RegionalManager manager;
	private int minimumTask;
	//equals method. Do not edit!
	public boolean equals(AssistantRegionalManager r){
		boolean equal = super.equals(r);
		equal = equal && (r.getMinimumTask() == minimumTask);
		equal = equal && (r.getManager().equals(manager));
		return equal;
	}
	//constructor
	AssistantRegionalManager(int IDNumber, String name, Task[] taskList, RegionalManager manager, int minimumTask){
		super(IDNumber, name, taskList);
		this.manager = manager;
		this.minimumTask = minimumTask;
	}
	//setters and getters
	public RegionalManager getManager(){
		return manager;
	}
	public void setManager(RegionalManager manager){
		this.manager = manager;
	}
	public int getMinimumTask(){
		return minimumTask;
	}
	public void setMinimumTask(int minimumTask){
		this.minimumTask = minimumTask;
	}
	/**
	 * @return String formatted string
	 */
	public String toString(){
		String ARMString = "Assistant Regional Manager\n"+super.toString()+"\nRegional Manager: "+manager.getName()+"\nMinimum Task Level: "+minimumTask;
		return ARMString;
	}
}
