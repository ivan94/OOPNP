package edu.newpaltz.edu.cs.fernandi2.sodamachine;

import java.util.*;


public class Transaction {

	protected int ID;
	protected String name = null;
	static public final int INIT_TID = 0;
	static public final int ADMIN_TID = 1;
	static public final int SELECT_TID = 2;
	static public final int INPUT_TID = 3;

	
	protected ArrayList<String> legalInputs = null;
	
	protected SodaMachine mSodaMachine;
	
	public Transaction(SodaMachine sm) {
		this.mSodaMachine = sm;
		this.legalInputs = new ArrayList<String>();
	}
	
	/**
	 * dummy constructor for searching transaction list
	 * @param tid legal transaction identifier
	 */
	public Transaction(int tid) {
	}
	
	public boolean isLegalInput(String s) {
		return this.legalInputs.contains(s);
	}
	
	public Boolean equals(Transaction t){
		return this.ID == t.ID || this.name.equals(t.name);
	}
	
	public void displayLegalInputs() {
		StringBuilder bd = new StringBuilder();
		int c = 0;
		for(String li: this.legalInputs){
			bd.append(li);
			if(c < this.legalInputs.size()-1){
				bd.append(", ");
			}
			c++;
		}
		System.out.println(bd.toString());
	}
	
	public void entry() {
		System.out.println("Entering "+ name);
		System.out.print("Legal inputs: ");
		displayLegalInputs();
		System.out.println();
	}
	
	public void run() {}
	
	
	
}

