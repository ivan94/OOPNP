package edu.newpaltz.edu.cs.fernandi2.sodamachine;

public class AdminTransaction extends Transaction {

	public AdminTransaction(SodaMachine sm) {
		super(sm);
		this.legalInputs.add("q");
		this.legalInputs.add("R");
		this.legalInputs.add("r0");
		this.legalInputs.add("r1");
		this.legalInputs.add("r2");
		this.legalInputs.add("r3");
		this.legalInputs.add("r4");
		this.name = "admin";
	}

	public void entry() {
		super.entry();
		System.out.println("Welcome admin");
	}

	public void run() {
		this.mSodaMachine.displayMachineInfo();
		String input = this.mSodaMachine.consumeInput(this.legalInputs);
		if (input == null) {
		} else if (input.equals("q")) {
			this.mSodaMachine.advanceTransaction(INIT_TID);
		} else if (input.equals("R")) {
			this.mSodaMachine.removeMachineReceipts();
		} else if (input.charAt(0) == 'r') {
			this.mSodaMachine.addToInventory(input);
		}
	}
}
