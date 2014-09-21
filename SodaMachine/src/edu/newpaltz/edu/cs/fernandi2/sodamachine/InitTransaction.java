package edu.newpaltz.edu.cs.fernandi2.sodamachine;


import java.util.*;

public class InitTransaction extends Transaction{

	public InitTransaction(SodaMachine sm) {
		super(sm);
		this.name = "init";
	}
	
	public void entry() {
	}
	
	public void run() {
		this.mSodaMachine.advanceTransaction(INPUT_TID);
	}
}

