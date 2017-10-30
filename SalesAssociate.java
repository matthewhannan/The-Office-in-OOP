public class SalesAssociate extends Employee{
	private int numClients;
    private String[] products;
    private RegionalManager supervisor;
	//equals method. Do not edit!
	public boolean equals(SalesAssociate s){
		boolean equal = super.equals(s);
		equal = equal && (s.getNumClients() == numClients);
		equal = equal && (s.getSupervisor().equals(supervisor));
		
		for(int i = 0; i < products.length; i++){
			equal = equal && (products[i].equals(s.getProducts()[i]));
		}
		return equal;
	}
	//constructor
	SalesAssociate(int IDNumber, String name, Task[] taskList, int numClients, String[] products, RegionalManager supervisor){
		super(IDNumber, name, taskList);
		this.numClients = numClients;
		this.products = products;
		this.supervisor = supervisor;
	}
	//getters and setters
	public int getNumClients(){
		return numClients;
	}
	public void setNumClients(int numClients){
		this.numClients = numClients;
	}
	public String[] getProducts(){
		return products;
	}
	public void setProducts(String[] products){
		this.products = products;
	}
	public RegionalManager getSupervisor(){
		return supervisor;
	}
	public void setSupervisor(RegionalManager supervisor){
		this.supervisor = supervisor;
	}
	/**
	 * @return String formatted String for Sales Associate
	 */
	public String toString(){
		String productsString = "";
		//boolean variable to decide whether a newline should be added
		boolean nextOne = true;
		
		for (int p = 0; p < products.length; p++){
			//function for determining if there should be a space after each iteration
			if (products.length - 1 == p){
				nextOne = false;
			}
			String space = "";
			if (nextOne){
				space = "\n";
			}
			//constructs the product string
			productsString += "\t"+products[p]+space;
		}
		//builds the full string for sales associate
		String SAString = "Sales Associate\n"+super.toString()+"\nRegional Manager: "+supervisor.getName()+"\nNumber of clients: "+numClients+"\nProducts to sell: \n"+productsString;
		return SAString;
	}
	
}

