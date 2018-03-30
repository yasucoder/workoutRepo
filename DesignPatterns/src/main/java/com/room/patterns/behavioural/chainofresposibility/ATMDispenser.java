package com.room.patterns.behavioural.chainofresposibility;

public class ATMDispenser {
	
	private DispenseChain c1;
	
	public ATMDispenser() {
		this.c1 = new Dispense50Dollar();
		 DispenseChain c2 =  new Dispense20Dollar();
		 DispenseChain c3 =  new Dispense10Dollar();
		 
		 c1.setNextChain(c2);
		 c2.setNextChain(c3);
	}
	
	public static void main (String[] arg){
		ATMDispenser atmdis = new ATMDispenser();
		while(true){
			int amount =0;
			
		}
	}

}
