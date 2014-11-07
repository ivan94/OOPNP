package edu.newpaltz.cs.fernandi2.tests;

import java.util.ArrayList;


public class Tests {

	public static void main(String[] args) throws InterruptedException {
		
		CollectionOf2 col = new CollectionOf2();
		CollectionOf2.CollectionOf2Incrementer inc = col.new CollectionOf2Incrementer();
		CollectionOf2.CollectionOf2Incrementer inc2 = col.new CollectionOf2Incrementer();
		
		inc.increment();
		inc2.increment();
		
		System.out.println(col.get2());
		
	}	

}


class CollectionOf2{
	private final ArrayList<Integer> arr;
	public CollectionOf2() {
		this.arr = new ArrayList<Integer>();
		this.arr.add(0);
	}
	
	public int get2(){
		return this.arr.get(0);
	}
	
	public CollectionOf2Incrementer getIncrementer(){
		return new CollectionOf2Incrementer();
	}
	
	public class CollectionOf2Incrementer{
		public void increment(){
			arr.add(arr.remove(0)+1);
		}
	}
}
