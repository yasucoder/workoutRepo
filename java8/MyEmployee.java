package java8feature;

public class MyEmployee implements Comparable<MyEmployee> {

	private int employeeID;
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	private String employeeName;
	private int employeeAge;

	@Override
	public int compareTo(MyEmployee o) {
		// TODO Auto-generated method stub
		return this.employeeID - o.employeeID;
		//return 0;
	}
	public MyEmployee(int employeeID, String employeeName, int employeeAge) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
	}
}
