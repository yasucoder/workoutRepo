package java8feature;

import java.util.Comparator;

public class EmployeeCompare implements Comparator<Employee> {

	@Override
	public int compare(Employee arg0, Employee arg1) {
				
		return arg0.getEmployeeID()-arg1.getEmployeeID();
	}

}
