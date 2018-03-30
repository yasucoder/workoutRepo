package java8feature;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> empArray = new ArrayList<Employee>();
		empArray.add(new Employee(1, "john", 25));			
		empArray.add(new Employee(3, "dam", 25));		
		empArray.add(new Employee(5, "jill", 25));		
		empArray.add(new Employee(2, "steav", 25));
		empArray.add(new Employee(4, "jack", 25));
		empArray.add(new Employee(6, "rose", 25));
		
		empArray.forEach((e)->System.out.println(e.getEmployeeID()));
		EmployeeCompare empcom = new EmployeeCompare();
		Collections.sort(empArray,empcom);
		//
		System.out.println("output");
		empArray.forEach((e)->System.out.println(e.getEmployeeID()));
		
		//Comparable
		/*ArrayList<MyEmployee> myempArray = new ArrayList<MyEmployee>();
		myempArray.add(new MyEmployee(1, "john", 25));			
		myempArray.add(new MyEmployee(3, "dam", 25));		
		myempArray.add(new MyEmployee(5, "jill", 25));		
		myempArray.add(new MyEmployee(2, "steav", 25));
		myempArray.add(new MyEmployee(4, "jack", 25));
		myempArray.add(new MyEmployee(6, "rose", 25));
		
		myempArray.forEach((e)->System.out.println(e.getEmployeeID()));
		
		Collections.sort( myempArray);
		myempArray.forEach((e)->System.out.println(e.getEmployeeID()));*/
		
	}

}
