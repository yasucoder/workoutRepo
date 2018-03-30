package com.room.patterns.creational.prototype;

public class TestPrototype {

	public static void main(String[] args) {
		Students stu = new Students();
		stu.loadData();
		
		try {
			Students newStu = (Students) stu.clone();
			Students newStu1 = (Students) stu.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
