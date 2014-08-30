package edu.newpaltz.cs.fernandi2.hw1oop;

import java.util.ArrayList;
import java.util.Random;

public class RandomStringGenerator {
	private ArrayList<Range> ranges;
	
	private Random rand;
	
	public RandomStringGenerator(){
		this.ranges = new ArrayList<>();
		this.rand = new Random();
	}
	
	private int getRangeIndex(){
		return this.rand.nextInt(this.ranges.size()-1);
	}
	
	public String nextString(int size){
		char[] string = new char[size];
		
		for(int i = 0; i<size; i++){
			string[i] = this.ranges.get(this.getRangeIndex()).getRandomCharacter();
		}
		
		return new String(string);
	}
	
	public void addRange(Range range){
		this.ranges.add(range);
	}
	
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
