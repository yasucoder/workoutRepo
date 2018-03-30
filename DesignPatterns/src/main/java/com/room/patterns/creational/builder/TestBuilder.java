package com.room.patterns.creational.builder;

public class TestBuilder {

	public static void main(){
		BankAccount account = new BankAccount.Builder(123456789)
				.setFirstname("fname")
				.setLastname("Lname")
				.setCity("XXX")
				.setState("AA")
				.build();
		
		
	}
}
