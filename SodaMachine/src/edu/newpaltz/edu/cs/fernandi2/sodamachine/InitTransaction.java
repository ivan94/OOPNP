package edu.newpaltz.edu.cs.fernandi2.sodamachine;



public class InitTransaction extends Transaction{

	public InitTransaction(SodaMachine sm) {
		super(sm);
		this.name = "init";
	}
	
	public void entry() {
		super.entry();
	}
	
	public void run() {
		this.mSodaMachine.advanceTransaction(INPUT_TID);
	}
}

