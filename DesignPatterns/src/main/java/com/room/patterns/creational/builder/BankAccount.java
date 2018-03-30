package com.room.patterns.creational.builder;

public class BankAccount {
	private int accountNumber;
	private String firstname;
	private String lastname;
	private String dob;
	private String addressline1;
	private String addressline2;
	private String city;
	private String state;
	private String zip;
	
	public static class Builder {
		
		private int accountNumber;
		private String firstname;
		private String lastname;
		private String dob;
		private String addressline1;
		private String addressline2;
		private String city;
		private String state;
		private String zip;
		
		public Builder(int accountNo){
			this.accountNumber = accountNo;
		}		
		
		
		public Builder setFirstname(String firstname) {
			this.firstname = firstname;
			return this;
		}
		
		public Builder setLastname(String lastname) {
			this.lastname = lastname;
			return this;
		}
		
		public Builder setDob(String dob) {
			this.dob = dob;
			return this;
		}
		
		public Builder setAddressline1(String addressline1) {
			this.addressline1 = addressline1;
			return this;
		}
		
		public Builder setAddressline2(String addressline2) {
			this.addressline2 = addressline2;
			return this;
		}
		
		public Builder setCity(String city) {
			this.city = city;
			return this;
		}
		
		public Builder setState(String state) {
			this.state = state;
			return this;
		}
		
		public Builder setZip(String zip) {
			this.zip = zip;
			return this;
		}
		
		public BankAccount build(){
			BankAccount account = new BankAccount();
			account.accountNumber = this.accountNumber;
			account.addressline1 = this.addressline1;
			account.addressline2 = this.addressline2;
			account.city = this.city;
			account.dob = this.dob;
			account.firstname = this.firstname;
			account.lastname = this.lastname;
			account.state = this.state;
			account.zip = this.zip;
			return account;			
		}
		
	
	}
	
	private BankAccount(){
		
	}

}
