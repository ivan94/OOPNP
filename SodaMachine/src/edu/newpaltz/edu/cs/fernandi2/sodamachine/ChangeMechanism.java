package edu.newpaltz.edu.cs.fernandi2.sodamachine;

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
		this.cust_q = 0;
		this.cust_d = 0;
		this.cust_n = 0;
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
		bd.append("Change: $");
		bd.append(amountReturned / 100);
		bd.append(".");
		bd.append(String.format("%02d", amountReturned % 100));
		return bd.toString();
	}

	public boolean hasChange(int cost) {
		int amountReturned = this.amountEntered - cost;
		if (amountReturned < 0)
			return false;

		int change = amountReturned;

		if (change / 25 > 0) {
			int mul = change / 25 <= this.cust_q ? change / 25 : this.cust_q;
			change -= 25 * mul;
		}
		if (change / 10 > 0) {
			int mul = change / 10 <= this.cust_d ? change / 10 : this.cust_d;
			change -= 10 * mul;
		}
		if (change / 5 > 0) {
			int mul = change / 5 <= this.cust_n ? change / 5 : this.cust_n;
			change -= 5 * mul;
		}

		return change == 0;
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

		int change = amountReturned;
		if (change / 25 > 0) {
			int mul = change / 25 <= this.cust_q ? change / 25 : this.cust_q;
			change -= 25 * mul;
			this.cust_q -= mul;
		}
		if (change / 10 > 0) {
			int mul = change / 10 <= this.cust_d ? change / 10 : this.cust_d;
			change -= 10 * mul;
			this.cust_d -= mul;
		}
		if (change / 5 > 0) {
			int mul = change / 5 <= this.cust_n ? change / 5 : this.cust_n;
			change -= 5 * mul;
			this.cust_n -= mul;
		}
		this.amountEntered = 0;

		return this.buildChangeString(amountReturned - change);
	}

	public int getAmountEntered() {
		return this.amountEntered;
	}

}
