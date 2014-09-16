package edu.newpaltz.edu.cs.fernandi2.sodamachine;

public class InventoryItem {

	private int ID = 0;
	private static final int MAX_QUANTITY = 3;
	private String name = null;
	private int QIS = 0;
	private final int PRICE = 75;
	
	public InventoryItem(int id, String n, int initialQIS) {
		this.ID = id;
		this.name = n;
		this.QIS = initialQIS;
	}
	
	public void addToInventory(int q) {
		this.QIS += q;
	}
	
	public void addToInventory() {
		this.QIS = InventoryItem.MAX_QUANTITY;
	}
	
	public void decrementInventory() {
		this.QIS--;
	}
	
	public int getPrice() {
		return this.PRICE;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		// sample output:
		//         (1): orange - 3
		return this.name + " - " + this.QIS;
	}
	
	public boolean equals(InventoryItem io) {
		return this.ID == io.ID || this.name.equals(io.name);
	}
	
	public int getQIS () {
		return this.QIS;
	}
}