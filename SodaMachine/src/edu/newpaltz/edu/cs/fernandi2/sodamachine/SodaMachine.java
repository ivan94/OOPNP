package edu.newpaltz.edu.cs.fernandi2.sodamachine;

import java.util.ArrayList;
import java.util.Scanner;

public class SodaMachine {

	public static Transaction transaction;
	private static ArrayList<Transaction> transactions;
	private Scanner scan;
	private Inventory inventory = null;
	private ChangeMechanism changeMechanism;
	private String latestSelection = null;

	public SodaMachine() {
		this.scan = new Scanner(System.in);
		this.inventory = new Inventory();
		this.changeMechanism = new ChangeMechanism();
	}

	public void processSelection() {
		if (this.latestSelection != null) {
			int itemId = Integer.parseInt(this.latestSelection.substring(1));
			if (!this.inventory.insufficientFunds(itemId,
					this.changeMechanism.getAmountEntered())) {
				if (!this.inventory.outOfStock(itemId)) { // successfull
															// transaction
					if(this.changeMechanism.hasChange(this.inventory.getSelectionCost(itemId))){
						System.out.println(this.inventory.getSelection(itemId));
						System.out
								.println(this.changeMechanism
										.getChange(this.inventory
												.getSelectionCost(itemId)));
					}else{ // MACHINE WITHOUT CHANGE
						System.out.println("Machine without change");
						System.out.println(this.changeMechanism.getChange(0));
					}
				} else {// OUT OF STOCK
					System.out.println("Item out of stock");
					System.out.println(this.changeMechanism.getChange(0));
				}
			} else { //INSUFICIENT FUNDS
				System.out.println("Insufficient funds");
				StringBuilder bd = new StringBuilder();
				int price =  this.inventory.getSelectionCost(itemId);
				bd.append("Price: $");
				bd.append(price/100);
				bd.append(".");
				bd.append(String.format("%02d", price%100));
				System.out.println(bd);
				System.out.println(this.changeMechanism.getChange(0));
			}
		}
	}

	public void resetTransaction() {
		SodaMachine.transaction = SodaMachine.transactions
				.get(Transaction.INIT_TID);
	}

	public Transaction getTransaction(int t) {
		return SodaMachine.transactions.get(t);
	}

	public void advanceTransaction(int tid) {
		SodaMachine.transaction = this.getTransaction(tid);
		SodaMachine.transaction.entry();
	}

	public void saveSelection(String s) {
		this.latestSelection = s;
	}

	public void addTransactions() {
		this.initMachine();
		SodaMachine.transactions.add(Transaction.INIT_TID, new InitTransaction(
				this));
		SodaMachine.transactions.add(Transaction.ADMIN_TID,
				new AdminTransaction(this));
		SodaMachine.transactions.add(Transaction.SELECT_TID,
				new SelectTransaction(this));
		SodaMachine.transactions.add(Transaction.INPUT_TID,
				new InputTransaction(this));
	}

	/**
	 * @param args
	 *            - the legal inputs in this state this method gets input,
	 *            checks it against legal inputs and returns input if legal;
	 *            otherwise it returns the null string.
	 * 
	 */
	public String consumeInput(ArrayList<String> args) {
		String input = this.scan.nextLine();
		if (args.contains(input))
			return input;
		else
			return null;
	}

	public void accumulateChange(String s) {
		this.changeMechanism.addChange(s);
		int funds = this.changeMechanism.getAmountEntered();
		StringBuilder bd = new StringBuilder();
		bd.append("Funds: $");
		bd.append(funds/100);
		bd.append(".");
		bd.append(String.format("%02d", funds%100));
		System.out.println(bd);
		
	}

	public void displayMachineInfo() {
		System.out.println(this.changeMechanism);
		System.out.println(this.inventory);
	}

	public void initMachine() {
		transactions = new ArrayList<Transaction>();
		this.changeMechanism.init();
	}

	public void removeMachineReceipts() {
		System.out.println(this.changeMechanism.emptyCashBox());
	}

	public void addToInventory(String s) {
		int itemId = Integer.parseInt(s.substring(1));
		this.inventory.updateInventory(this.inventory.getItemName(itemId));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SodaMachine sm = new SodaMachine();
		sm.addTransactions();

		transaction = transactions.get(Transaction.INIT_TID);
		while (true) {
			SodaMachine.transaction.run();
		}

	}

}
