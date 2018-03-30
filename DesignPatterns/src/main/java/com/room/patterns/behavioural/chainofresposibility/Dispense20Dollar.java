package com.room.patterns.behavioural.chainofresposibility;

public class Dispense20Dollar implements DispenseChain {
	DispenseChain chain;
	public void setNextChain(DispenseChain nextChain) {
		chain = nextChain;

	}

	public void dispense(Currency cur) {
		
		
			if(cur.getAmount() >=20){
				int num = cur.getAmount()/20;
				int rem = cur.getAmount() % 20;
				if(rem !=0)
					this.chain.dispense(new Currency(rem));
				else
					this.chain.dispense(cur);
			}
			
		}
	

}
