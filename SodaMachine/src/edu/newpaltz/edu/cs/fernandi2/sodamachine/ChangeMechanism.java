package edu.newpaltz.edu.cs.fernandi2.sodamachine;

import java.util.ArrayList;

public class ChangeMechanism {
	private int cust_q = 0, cust_d = 0, cust_n = 0;
	private final int MAX_Q = 3;
	private final int MAX_D = 3;
	private final int MAX_N = 3;
	private int changeBox = 0;
	private int amountEntered = 0;

	public ChangeMechanism() {
		this.init();
	}

	public void resetAmountEntered() {
		this.amountEntered = 0;
	}

	public void init() {
		this.cust_q = MAX_Q;
		this.cust_d = MAX_D;
		this.cust_n = MAX_N;
		this.changeBox = 0;
		this.amountEntered = 0;
	}

	public String emptyCashBox() {
		String funds = this.toString();
		this.changeBox = 0;
		return funds;
	}

	public String toString() {
		StringBuilder bd = new StringBuilder();
		bd.append("CashBox: $");
		bd.append(this.changeBox / 100);
		bd.append(".");
		bd.append(String.format("%02d", this.changeBox % 100));
		return bd.toString();
	}

	/**
	 * 
	 * @param c
	 *            must be 5, 10 or 25
	 * 
	 *            Accepts change into the change mechanism. If
	 */
	public void addChange(int c) {
		if (c == 5 && this.cust_n < MAX_N) {
			this.cust_n++;
		} else if (c == 10 && this.cust_d < MAX_D) {
			this.cust_d++;
		} else if (c == 25 && this.cust_q < MAX_Q) {
			this.cust_q++;
		} else if (c != 5 && c != 10 && c != 25) {
			return;
		} else {
			this.changeBox += c;
		}
		this.amountEntered += c;
	}

	public void addChange(String s) {
		this.addChange(Integer.parseInt(s));
	}

	private String buildChangeString(int amountReturned) {
		StringBuilder bd = new StringBuilder();
		bd.append("Returning: $");
		bd.append(amountReturned / 100);
		bd.append(".");
		bd.append(String.format("%02d", amountReturned % 100));
		return bd.toString();
	}

	public boolean hasChange(int cost) {
		int amountReturned = this.amountEntered - cost;
		if (amountReturned < 0)
			return false;

		int change = 0;
		ArrayList<Integer> changes = this.possibleChanges(amountReturned);
		for (int i = 0; i < changes.size(); i += 3) {
			if (changes.get(i) <= this.cust_q
					&& changes.get(i + 1) <= this.cust_d
					&& changes.get(i + 2) <= this.cust_n) {
				change = 25 * changes.get(i) + 10 * changes.get(i + 1) + 5
						* changes.get(i + 2);
				break;
			}
		}

		return change == amountReturned;
	}

	/**
	 * method called to calculate the amount of change coming back to the
	 * machine user. Assumes coins have already been added.
	 * 
	 * @param cost
	 *            cost of current selection (Use 0 for lack of inventory)
	 * @return
	 */
	public String getChange(int cost) {
		int amountReturned = this.amountEntered - cost;
		if (amountReturned < 0)
			return null;

		int change = 0;
		ArrayList<Integer> changes = this.possibleChanges(amountReturned);
		for (int i = 0; i < changes.size(); i += 3) {
			if (changes.get(i) <= this.cust_q
					&& changes.get(i + 1) <= this.cust_d
					&& changes.get(i + 2) <= this.cust_n) {
				change = 25 * changes.get(i) + 10 * changes.get(i + 1) + 5
						* changes.get(i + 2);
				this.cust_q -= changes.get(i);
				this.cust_d -= changes.get(i + 1);
				this.cust_n -= changes.get(i + 2);
				break;
			}
		}
		
		if(change == 0){
			change = 25*this.cust_q + 10*this.cust_d + 5*this.cust_n;
			this.cust_q = this.cust_n = this.cust_d = 0;
		}

		this.amountEntered = 0;

		return this.buildChangeString(change);
	}

	public int getAmountEntered() {
		return this.amountEntered;
	}

	/**
	 * Get all possible combination of coins to reach the price
	 * 
	 * @param price
	 *            the price to be reached
	 * @return A list with all possible combinations. Each 3 elements on the
	 *         list represents the necessary number of quarter dimes and nickels
	 *         respectively
	 */
	private ArrayList<Integer> possibleChanges(int price) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		int quarters = price / 25;

		for (; quarters >= 0; quarters--) {
			int dimes = (price - 25 * quarters) / 10;
			for (; dimes >= 0; dimes--) {
				int nickels = (price - 25 * quarters - 10 * dimes) / 5;
				result.add(quarters);
				result.add(dimes);
				result.add(nickels);
			}
		}

		return result;
	}

}
