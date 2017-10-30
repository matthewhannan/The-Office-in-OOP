public abstract class Employee {	
	private int IDNumber;
    private String name;
    private Task[] taskList;
    
	//constructor
	Employee(int IDNumber, String name, Task[] taskList){
		this.IDNumber = IDNumber;
		this.name = name;
		this.taskList = taskList;
	}
	
	//setters and getters
	public int getIDNumber(){
		return IDNumber;
	}
	public void setIDNumber(int IDNumber){
		this.IDNumber = IDNumber;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Task[] getTaskList(){
		return taskList;
	}
	public void setTaskList(Task[] taskList){
		this.taskList = taskList;
	}
	
	/**
	 * @return String formatted text for the superclass Employee
	 */
	public String toString(){
		
		//boolean to aid in not putting a next line at the end
		boolean nextOne = true;
		String tasks = "";
		//null checker
		if(taskList != null){
			int numOfTasks = taskList.length;
			//function for determining whether to put a next line
			for (int i = 0; i < numOfTasks; i++){
				if (numOfTasks - 1 == i){
					nextOne = false;
				}
				String space = "";
				if (nextOne){
					space = "\n";
				}
				//creating the task portion of the string
				tasks += "\tTask: " + taskList[i].getName() + "\t" + "Level: "+taskList[i].getLevel() + space;
			}
		}
		//creating the full string with appropriate spacing
		String textFormat = "Name: " + name + "\nID: " + IDNumber + "\nTask List: \n" + tasks;
		return textFormat;
	}
	//equals method. Do not edit!
	public boolean equals(Employee e){
		boolean equal = true;
		equal = equal && (e.getIDNumber() == IDNumber);
		equal = equal && (e.getName().equals(name));
		for(int i = 0; i < taskList.length; i++){
			equal = equal && (taskList[i].equals(e.getTaskList()[i]));
		}
		return equal;
	}
	
}