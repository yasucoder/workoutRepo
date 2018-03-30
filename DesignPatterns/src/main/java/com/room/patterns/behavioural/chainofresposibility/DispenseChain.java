package com.room.patterns.behavioural.chainofresposibility;

public interface DispenseChain {
	
	public void setNextChain(DispenseChain nextChain);
	public void dispense(Currency cur);

}
