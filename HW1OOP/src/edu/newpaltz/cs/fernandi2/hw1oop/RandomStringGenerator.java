package edu.newpaltz.cs.fernandi2.hw1oop;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class that generate a random strings
 * Given a list of ranges of characters the class is able to genereta a string of a given size or based on a seed
 * @author Ivan Fernandes
 *
 */
public class RandomStringGenerator {
	private ArrayList<Range> ranges;
	
	private Random rand;
	
	public RandomStringGenerator(){
		this.ranges = new ArrayList<Range>();
		this.rand = new Random();
	}
	
	/**
	 * Return a random index for the ranges list
	 * @return A random index number
	 */
	private int getRangeIndex(){
		return this.rand.nextInt(this.ranges.size());
	}
	
	/**
	 * Generate a random string with the specified size
	 * @param size The size of the generated string
	 * @return The random string
	 */
	public String nextString(int size){
		char[] string = new char[size];
		
		for(int i = 0; i<size; i++){
			string[i] = this.ranges.get(this.getRangeIndex()).getRandomCharacter();
		}
		
		return new String(string);
	}
	
	/**
	 * Add a range of characters on the generator
	 * @param range The range of characters to be added.
	 */
	public void addRange(Range range){
		this.ranges.add(range);
	}
	
	/**
	 * Generate a random string based on a specified seed.
	 * The seed is a string containers c, C or d characters, each one representing what type of character should be generated.
	 * The 'c' character means that the letter should be lower-case, the 'C' means upper-case and 'd' means that it should 
	 * be a digit
	 * @param seed The seed string made of 'c', 'C' or 'd' characters
	 * @return The generated random string based on the seed
	 * @throws Exception Raises when the seed contains characters other then the ones specified above
	 */
	public String nextString(String seed) throws Exception{
		char[] string = new char[seed.length()];
		Range lower = new Range('a','z');
		Range upper = new Range('A','Z');
		Range digit = new Range('0', '9');
		for(int i = 0; i< seed.length(); i++){
			char c = seed.charAt(i);
			if(c == 'c'){
				string[i] = lower.getRandomCharacter();
			}else if(c == 'C'){
				string[i] = upper.getRandomCharacter();
			}else if(c == 'd'){
				string[i] = digit.getRandomCharacter();
			}else{
				throw new Exception("Invalid character");
			}
		}
		
		return new String(string);
	}
}
