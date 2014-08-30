package edu.newpaltz.cs.fernandi2.hw1oop;

import java.util.Random;

public class Range {
	private char begin;
	private char end;
	
	private Random rand;
	
	private int getRangeSize(){
		return ((int)this.end) - ((int)this.begin);
	}
	
	public char getRandomCharacter(){
		int i = this.rand.nextInt(this.getRangeSize());
		
		return (char)(((int)this.begin) + i);
	}

	public Range(char begin, char end) {
		this.begin = begin;
		this.end = end;
		this.rand = new Random();
	}
	
	public static void main(String[] args) {
		Range r = new Range('0', '9');
		
		for(int i = 0; i<10; i++){
			System.out.println(r.getRandomCharacter());
		}
	}
}
