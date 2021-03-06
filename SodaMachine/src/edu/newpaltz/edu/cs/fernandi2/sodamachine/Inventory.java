package edu.newpaltz.edu.cs.fernandi2.sodamachine;


import java.util.*;

public class Inventory {

	public static String COLA= "cola";
	public static String ORANGE= "orange";
	public static String SPRITE= "sprite";
	public static String GINGER_ALE= "ginger ale";
	public static String DIET_COLA= "diet cola";	
	
	
	private ArrayList<InventoryItem> contents = null;
	
	public Inventory() {
		this.contents = new ArrayList<InventoryItem>();
		this.contents.add(new InventoryItem(0, COLA, 3));
		this.contents.add(new InventoryItem(1, ORANGE, 3));
		this.contents.add(new InventoryItem(2, SPRITE, 3));
		this.contents.add(new InventoryItem(3, GINGER_ALE, 3));
		this.contents.add(new InventoryItem(4, DIET_COLA, 3));
	}
	
	public void addToInventory(int id, int q ) {
		this.getItem(id).addToInventory(q);
	}
	
	public void addToInventory(String  n, int q ) {
		this.getInventoryItem(n).addToInventory(q);
	}
	
	public String toString() {
		StringBuilder bd = new StringBuilder();
		for (InventoryItem inventoryItem : this.contents) {
			bd.append(inventoryItem.toString());
			bd.append("\n");
		}
		return bd.toString();
	}
	
	public InventoryItem getInventoryItem(String s) {
		return this.getItem(s);
	}
	
	public boolean insufficientFunds(int item, int amountEntered) {
		return this.getItem(item).getPrice() > amountEntered;
	}
	
	public String getItemName(int i) {
		return this.getItem(i).getName();
	}
	
	private InventoryItem getItem(int i) {
		return this.contents.get(i);
	}
	
	private InventoryItem getItem(String i) {
		InventoryItem result = null;
		InventoryItem comparation = new InventoryItem(0, i, 0);
		for(InventoryItem item : this.contents){
			if(item.equals(comparation))
				result = item;
		}
		return result;
	}
	
	public boolean outOfStock(int itemID) {
		return this.getItem(itemID).getQIS() < 1;
	}
	
	public int getSelectionCost(int selection) {
		return this.getItem(selection).getPrice();
	}
	
	public String getSelection(int selection) {
		InventoryItem item = this.getItem(selection);
		item.decrementInventory();
		return "Delivering a " + item.getName();
	}
	
	public void updateInventory(String s) {
		this.getItem(s).addToInventory();
	}
	
}

