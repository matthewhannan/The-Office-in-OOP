public class RegionalManager extends Employee {
	private int RegionNum;
	private Employee[] subordinates;
	private int minimumTask;
	
	//constructor
	RegionalManager(int IDNumber, String name, Task[] taskList, int RegionNum, Employee[] subordinates, int minimumTask){
		super(IDNumber, name, taskList);
		this.subordinates = subordinates;
		this.RegionNum = RegionNum;
		this.minimumTask = minimumTask;
	}
	//alternate constructor lacking subordinate array
	RegionalManager(int IDNumber, String name, Task[] taskList, int RegionNum, int minimumTask) {
		super(IDNumber, name, taskList);
		this.RegionNum = RegionNum;
		this.minimumTask = minimumTask;
	}
	//setters and getters
	public int getRegionNum() {
		return RegionNum;
	}
	public void setRegionNum(int RegionNum){
		this.RegionNum = RegionNum;
	}
	public Employee[] getSubordinates(){
		return subordinates;
	}
	public void setSubordinates(Employee[] subordinates){
		this.subordinates = subordinates;
	}
	public int getMinimumTask(){
		return minimumTask;
	}
	public void setMinimumTask(int minimumTask){
		this.minimumTask = minimumTask;
	}
	/**
	 * @return String constructed string formatting for Regional Manager
	 */
	public String toString(){
		
		String employeesString = "";
		//helps with not adding a space on the end
		boolean nextOne = true;
		//null checker
		if(subordinates != null){
			for (int x = 0; x<subordinates.length; x++){
				//makes sure correct number of spaces
				if (subordinates.length - 1 == x){
					nextOne = false;
				}
				String space = "";
				if (nextOne){
					space = "\n";
				}
				//constructs the employee substring
				employeesString += subordinates[x].toString() + space;
			}
		}
		//constructs the full string
		String RMString = "Regional Manager\n"+ super.toString() + "\nRegion Number: "+RegionNum+"\nMinimum Task Level: "+minimumTask+"\nEmployees: \n"+employeesString;
		return RMString;
	}
	//equals method. Do not edit!
	public boolean equals(RegionalManager r){
		boolean equal = super.equals(r);
		equal = equal && (r.getRegionNum() == RegionNum);
		equal = equal && (r.getMinimumTask() == minimumTask);
		for(int i = 0; i < subordinates.length; i++){
			equal = equal && (subordinates[i].equals(r.getSubordinates()[i]));
		}
		return equal;
	}

}

