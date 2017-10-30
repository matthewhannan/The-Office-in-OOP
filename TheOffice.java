import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * @author Matthew Hannan and Nish Patel
 * UFID for Matthew Hannan: 12071843
 * UFID for Nish Patel: 81161330
 * Section 1A87
 */
public class TheOffice{
	
	private Employee[] workers;
	
	//Constructor
	TheOffice(){}
	
	TheOffice(String fileLoc) throws TaskLevelException{
		
		//This is used to read a file, do NOT edit!!!
		Scanner fs = null;
		File f = null;
		
		//Try Catch on file
		try{ 
			f = new File(fileLoc); 
			fs = new Scanner(f); 
		}
		catch(FileNotFoundException e){ 
			System.out.println("FileNotFoundException: The file \""+ fileLoc + "\" could not be found.");
		}
		
		
		//First Line is number of employees
		int size = Integer.parseInt(fs.nextLine());
		
		workers = new Employee[size];
				
		//This might be useful, feel free to delete, or not use these		
		RegionalManager manager = null;
		int supremum = 0;
		AssistantRegionalManager assistantManager = null;
		int ATRM = 0; 
		//saved first assistant manager to provide a supervisor for receptionist
		AssistantRegionalManager firstManager = null;
		
		//Loops through file
		for(int i = 0; i < size; i++){
			//Sets temp variables for all possible member variables
			int IDNumber = -1;
			String name = null;
			Task[] taskList = null; 
			int RegionNum = -1; 
			int minimumTask = -1;
			int numClients = -1;
			String[] products = null;
			int maxTaskComplexityLevel = -1;
			
			//Check which type of employee
			String type = fs.nextLine().trim();
			
			//Get Standard information (id, name)
			IDNumber = Integer.parseInt(fs.nextLine().trim());
			name =  fs.nextLine();
			
			//Gets number of tasks and makes a task array based on the size
			int tasks = Integer.parseInt(fs.nextLine().trim());
			taskList = new Task[tasks];
				
			//Fills up Task List
			for(int j = 0; j < tasks; j++){
				//Gets information for task
				String work = fs.nextLine();
				int num = Integer.parseInt(fs.nextLine().trim());
				
				//Sets task at array spot
				taskList[j] = new Task(work, num); 
			}
			
			//Scanner read for Regional Manager. Use this as an example to do the other 3 types
			if(type.equals("RegionalManager")){
				//Gets Region Number and Minimum Task Level
				RegionNum = Integer.parseInt(fs.nextLine().trim());
				minimumTask = Integer.parseInt(fs.nextLine().trim());
				
				//Loop through the Task list
				for(int j = 0; j < taskList.length; j++ ){
					//If a task is below the minimum task level, throw exception
					if(taskList[j].getLevel() < minimumTask){
						throw new TaskLevelException(taskList[j].getLevel());
					}
				}			
				
				//set manager to new regional manager
				manager = new RegionalManager(IDNumber, name, taskList, RegionNum, minimumTask);
				
				//set workers[i] to regional manager
				workers[i] = manager;
				
				//Set supremum (Might be useful)
				supremum = minimumTask;
			}
			//how to read the assistantregionalmanager portion of the input text file
			else if(type.equals("AssistantRegionalManager")){
				minimumTask = Integer.parseInt(fs.nextLine().trim());
				//tasklevel exception loop
				for(int e = 0; e < taskList.length; e++){
					
					if(taskList[e].getLevel() < minimumTask){
						throw new TaskLevelException(taskList[e].getLevel());
					}
				}
				//temporary placeholder
				int placeHolder = 0;
				//creates a new assistant manager with necessary parameters
				assistantManager = new AssistantRegionalManager(IDNumber, name, taskList, manager, minimumTask);
				//stores the first assistantmanager for supervisor parameter in receptionist
				if (placeHolder == 0){
					firstManager = assistantManager;
					placeHolder++;
				}
				//stores in array of workers
				workers[i] = assistantManager;
				
				supremum = minimumTask;
				
			}
			//reads in and sorts through correct information for sales associate
			else if(type.equals("SalesAssociate")){
				
				for(int e = 0; e < taskList.length; e++){
					
					if(taskList[e].getLevel() < minimumTask){
						throw new TaskLevelException(taskList[e].getLevel());
					}
				}
				//grabs correct variables from files
				numClients = Integer.parseInt(fs.nextLine().trim());
				int numOfProducts = Integer.parseInt(fs.nextLine().trim());
				products = new String[numOfProducts];
				//creates an array of product strings to store in products
				for(int e = 0; e < products.length; e++){
					products[e] = fs.nextLine().trim();
				}
				//creates a new salesassociate object for the worker array
				SalesAssociate temp = new SalesAssociate(IDNumber, name, taskList, numClients, products, manager);
				//stores inside worker array
				workers[i] = temp;
			}
			//reads and sets correct information for receptionist
			else if(type.equals("Receptionist")){
				for(int e = 0; e < taskList.length; e++){
					//exception loop
					if(taskList[e].getLevel() < minimumTask){
						throw new TaskLevelException(taskList[e].getLevel());
					}
				}
				//grabs correct info from file and assigns
				maxTaskComplexityLevel = Integer.parseInt(fs.nextLine().trim());
				//creates a new receptionsit object
				Receptionist placeHold = new Receptionist(IDNumber, name, taskList, firstManager, maxTaskComplexityLevel);
				//stores receptionist in worker array
				workers[i] = placeHold;
			}
		}
		
		//Set up Employee Arrays for regional manager
		Employee[] a = new Employee[size -1];
		for(int i = 0, j = 0; i < workers.length; i++){
			if(!(workers[i] instanceof RegionalManager)){
				a[j++] = workers[i];
			}
		}
		
		//If there is a manager, set the subordinate array
		if(manager != null){
			manager.setSubordinates(a);
		}
	}
	
	
	
	
	/**
	 * @return String final string for regional manager employee
	 */
	public String toString(){
		Employee regionalMan = null;
		for(int r = 0; r < workers.length; r++){
			//checking if it is the regional manager
			if(workers[r].getIDNumber() == 1){
				regionalMan = workers[r];
			}
		}
		//building string
		String finalReturn = regionalMan.toString();
		return finalReturn;
	}
	
	/**
	 * 
	 * @return String name of the worker and their minimum task level with correct amount of newlines
	 */
	public String levelDisplay(){
		
		String displayThing = "";
		//storing a large number for minimum task level in order to filter down to actual minimum
		int minimumTaskLevel = 100000000;
		//variabkle that stores whether we shoul dbe adding another new line
		boolean nextOne = true;
		//sifting through the workers array
		for (int o = 0; o < workers.length; o++){
			//Ricardo helped me with the instanceof
			//checking if this is the regional manager since it already has a minimum task variable
			if(workers[o] instanceof RegionalManager){
				minimumTaskLevel = ((RegionalManager) workers[o]).getMinimumTask();
			}
			
			//Ricardo helped me with the instanceof
			//checking to see if this is an assistantregionalmanager since it already has a minimumtasklevel variable
			else if(workers[o] instanceof AssistantRegionalManager){
				minimumTaskLevel = ((AssistantRegionalManager) workers[o]).getMinimumTask();
			}
			//if the employee(worker) is other than a regional or assistant regional so it will calculate the minimum task level
			else{
				//makes an array of tasks of length same size as the employee's tasklist length
				Task[] tempTaskList = new Task[workers[o].getTaskList().length];
				//stores the employee's tasklist in the temp array
				tempTaskList = workers[o].getTaskList();
				//sifts through each task in the taskarray and finds the minimum task level 
				for (int e = 0; e < tempTaskList.length; e++){
					if(tempTaskList[e].getLevel() < minimumTaskLevel){
						minimumTaskLevel = tempTaskList[e].getLevel();
					}
				}
			}
			//doesnt need another space cuz we're on the last iteration
			if (workers.length - 1 == o){
				nextOne = false;
			}
			String space = "";
			if (nextOne){
				space = "\n";
			}
			//builds string to return
			displayThing += "Name: "+workers[o].getName()+"\tLevel: "+minimumTaskLevel+space;
		}
		return displayThing;
	}
	
	//setter and getter
	public Employee[] getWorkers() {
		return workers;
	}

	public void setWorkers(Employee[] workers) {
		this.workers = workers;
	}
	/**
	 * 
	 * @param args aka the declaration pointing to the input text file
	 * @throws TaskLevelException
	 */
	public static void main(String[] args) throws TaskLevelException{
		//Gets location for file
		TheOffice o = new TheOffice((args[0]+".txt"));
		
		//Prints office, then the current level display
		System.out.println(o + "\n\n\n" + o.levelDisplay());
		
		//Sorts(by name) the employee array
		Sorter.sort(o.getWorkers());
		
		//Prints the sorted(by name) level display
		System.out.println("\n\n\n" + o.levelDisplay());
	}
	
}