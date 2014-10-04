package edu.newpaltz.cs.fernandi2.hw4oop;

/**
 * A first-in, first-out bounded collection of messages.
 */

public class MessageQueue{
	/**
	 * Constructs an empty message queue.
	 * 
	 * @param capacity
	 *            the maximum capacity of the queue
	 * @precondition capacity > 0
	 */

	public MessageQueue(int capacity) {
		assert capacity > 0: "Violated pre condition capacity>0";
		elements = new Message[capacity];
		count = 0;
		head = 0;
		tail = 0;
	}

	/**
	 * Remove message at head.
	 * 
	 * @return the message that has been removed from the queue
	 * @precondition size() > 0
	 */
	public Message remove() {
		assert size() > 0 : "Violated pre condition size()>0";
		Message r = elements[head];
		head = (head + 1) % elements.length;
		count--;
		System.out.println("(tail - head - count)%elements.length : "+this.testInvariant());
		return r;
	}

	/**
	 * Append a message at tail.
	 * 
	 * @param aMessage
	 *            the message to be appended
	 */
	public void add(Message aMessage) {
		if(this.isFull())
			growCapacity();
		elements[tail] = aMessage;
		tail = (tail + 1) % elements.length;
		count++;
		System.out.println("(tail - head - count)%elements.length : "+this.testInvariant());
	}

	/**
	 * Get the total number of messages in the queue.
	 * 
	 * @return the total number of messages in the queue
	 */
	public int size() {
		return count;
	}

	/**
	 * Checks whether this queue is full
	 * 
	 * @return true if the queue is full
	 */
	public boolean isFull() {
		return count == elements.length;
	}

	/**
	 * Get message at head.
	 * 
	 * @return the message that is at the head of the queue
	 * @precondition size() > 0
	 */
	public Message peek() {
		assert size() > 0: "Violated pre condition size()>0";
		return elements[head];
	}
	
	
	private void growCapacity(){
		Message[] oldQueue = elements;
		elements = new Message[elements.length*GROW_SCALE];
		count = 0;
		head = 0;
		tail = 0;
		for(Message m: oldQueue){
			this.add(m);
		}
	}
	
	public int testInvariant(){
		return (tail - head - count)%elements.length;
	}

	private Message[] elements;
	private int head;
	private int tail;
	private int count;
	private final int GROW_SCALE = 2;
}
