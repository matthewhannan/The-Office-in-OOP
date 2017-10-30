import java.util.Arrays;

public class Sorter{
	/**
	 * 
	 * @param workers
	 * @return Employee[] array sorted in alphabetical order
	 */
	public static Employee[] sort(Employee[] workers){
		//array of worker names for temporary use
		String[] workerNames = new String[workers.length];
		//array I will return after
		Employee[] finalArray = new Employee[workers.length];
		//setting values to temporary array
		for(int v = 0; v < workers.length; v++){
			workerNames[v] = workers[v].getName();
		}
		//sorting by alphabetical order
		Arrays.sort(workerNames);
		//nexted loop in order to set each index of final array to the sorted version of the temporary array
		for(int p = 0; p < workerNames.length; p++){
			for(int z = 0; z < workerNames.length; z++){
				if(workerNames[p].equals(workers[z].getName())){
					finalArray[p] = workers[z];
				}
			}
		}
		return finalArray;
	}
}