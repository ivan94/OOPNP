package edu.newpaltz.cs.fernandi2.hw1oop;

import java.util.Random;

/**
 * Defines a Range of characters
 * @author Ivan Fernandes
 *
 */
public class Range {
	private char begin;
	private char end;
	
	private Random rand;
	
	/**
	 * Get the size of the range
	 * @return The size of the range
	 */
	private int getRangeSize(){
		return ((int)this.end) - ((int)this.begin);
	}
	
	/**
	 * Select a random character inside the range
	 * @return The random character
	 */
	public char getRandomCharacter(){
		int i = this.rand.nextInt(this.getRangeSize());
		return (char)(((int)this.begin) + i);
	}
	
	/**
	 * Define a new range
	 * @param begin The begin of the range
	 * @param end The end of the range
	 */
	public Range(char begin, char end) {
		this.begin = begin;
		this.end = end;
		this.rand = new Random();
	}
}
