package com.room.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Students implements Cloneable {

	private List<String> studentList = null;
	
	public Students() {
		studentList = new  ArrayList<String>();
	}
	public Students(List<String> list) {
		studentList = list;
	}
	
	public List<String> getStudentList(){
		return studentList;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<String>();
		for(String s:this.getStudentList()){
			temp.add(s);
		}
		return new Students(temp);
	}
	
	
	public void loadData(){
		studentList.add("stu1");
		studentList.add("stu2");
		studentList.add("stu3");
		studentList.add("stu4");
		studentList.add("stu5");
		studentList.add("stu6");
		
	}
	
}
