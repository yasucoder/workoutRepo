package java8feature;

public class Employee {
	
	private int employeeID;
	private String employeeName;
	private int employeeAge;
	/**
	 * @return the employeeID
	 */
	public int getEmployeeID() {
		return employeeID;
	}
	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * @return the employeeAge
	 */
	public int getEmployeeAge() {
		return employeeAge;
	}
	/**
	 * @param employeeAge the employeeAge to set
	 */
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
	public Employee(int employeeID, String employeeName, int employeeAge) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
	}
	
	
	

}
