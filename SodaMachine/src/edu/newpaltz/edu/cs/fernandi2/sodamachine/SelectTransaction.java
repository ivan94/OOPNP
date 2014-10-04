package edu.newpaltz.edu.cs.fernandi2.sodamachine;

public class SelectTransaction extends Transaction {

	public SelectTransaction(SodaMachine sm ) {
		super(sm);
		this.name = "select";
	}
	

	public void entry() {
		super.entry();
	}
	
	public void run() {
		this.mSodaMachine.processSelection();
		this.mSodaMachine.advanceTransaction(INIT_TID);
	}
}

