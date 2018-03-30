package com.room.patterns.behavioural.chainofresposibility;

public class Dispense50Dollar implements DispenseChain{

	private DispenseChain chain;
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
		
	}

	public void dispense(Currency cur) {
		if(cur.getAmount() >=50){
			int num = cur.getAmount()/50;
			int rem = cur.getAmount() % 50;
			if(rem !=0)
				this.chain.dispense(new Currency(rem));
			else
				this.chain.dispense(cur);
		}
		
	}

}
