final public class Task {
	private String name;
	private int level;
	//constructor
	Task(String name, int level){
		this.name = name;
		this.level = level;
	}
	//getters
	public String getName(){
		return name;
	}
	public int getLevel(){
		return level;
	}	
	/**
	 * @return String each task string for each employee
	 */
	public String toString(){
		//each task
		String taskString = "\tTask: "+name+"\tLevel: "+level;
		return taskString;
	}
	//equals method. Do not edit!
	public boolean equals(Task t){
		return ((t.getLevel() == level) && (t.getName().equals(name)));
	}
}
