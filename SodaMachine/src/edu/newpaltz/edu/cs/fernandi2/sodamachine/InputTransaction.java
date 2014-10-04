package edu.newpaltz.edu.cs.fernandi2.sodamachine;

public class InputTransaction extends Transaction {

	public InputTransaction(SodaMachine sm) {
		super(sm);
		this.legalInputs.add("a");
		this.legalInputs.add("5");
		this.legalInputs.add("10");
		this.legalInputs.add("25");
		this.legalInputs.add("s0");
		this.legalInputs.add("s1");
		this.legalInputs.add("s2");
		this.legalInputs.add("s3");
		this.legalInputs.add("s4");
		this.name = "input";
	}

	public void entry() {
		super.entry();
		System.out.println("Insert coins and select a soda");
	}

	public void run() {
		String input = this.mSodaMachine.consumeInput(this.legalInputs);
		if (input == null) {

		} else if (input.equals("a")) {
			this.mSodaMachine.advanceTransaction(ADMIN_TID);
		} else if (input.equals("10") || input.equals("5")
				|| input.equals("25")) {
			this.mSodaMachine.accumulateChange(input);
		} else if(input.charAt(0) == 's') {
			this.mSodaMachine.saveSelection(input);
			this.mSodaMachine.advanceTransaction(SELECT_TID);
		}
	}
}
