package edu.newpaltz.cs.fernandi2.hw4oop;

import junit.framework.TestCase;

import org.junit.Test;

public class MessageQueueTest extends TestCase {
	
	@Test
	public void testAddInvariant(){
		MessageQueue m = new MessageQueue(3);
		m.add(new Message(""));
		m.add(new Message(""));
		assertTrue(m.testInvariant() == 0);
	}
	
	public void testRemoveInvariant(){
		MessageQueue m = new MessageQueue(3);
		m.add(new Message(""));
		m.add(new Message(""));
		m.remove();
		m.remove();
		assertTrue(m.testInvariant() == 0);
	}
	
	@Test
	public void testInvariantWOResize() {
		MessageQueue m = new MessageQueue(3);
		m.add(new Message(""));
		m.add(new Message(""));
		m.remove();
		m.add(new Message(""));
		assertTrue(m.testInvariant() == 0);
	}
	@Test
	public void testInvariantWResize() {
		MessageQueue m = new MessageQueue(3);
		m.add(new Message(""));
		m.add(new Message(""));
		m.remove();
		m.add(new Message(""));
		m.remove();
		m.add(new Message(""));
		m.add(new Message(""));
		m.add(new Message(""));
		m.add(new Message(""));
		m.add(new Message(""));
		m.remove();
		assertTrue(m.testInvariant() == 0);
	}
	
	@Test
	public void testCircularArrayWOResize(){
		MessageQueue m = new MessageQueue(5);
		m.add(new Message(""));
		m.add(new Message(""));
		m.add(new Message(""));
		m.add(new Message("test"));
		m.add(new Message(""));
		m.remove();
		m.add(new Message(""));
		m.remove();
		m.remove();
		m.add(new Message(""));
		assertEquals("test", m.peek().getText());
	}
	
	@Test
	public void testCircularArrayWResize(){
		MessageQueue m = new MessageQueue(5);
		m.add(new Message(""));
		m.add(new Message(""));
		m.add(new Message(""));
		m.add(new Message(""));
		m.add(new Message(""));
		m.remove();
		m.add(new Message(""));
		m.remove();
		m.remove();
		m.add(new Message(""));
		m.add(new Message(""));
		m.add(new Message("test"));
		m.add(new Message(""));
		m.add(new Message(""));
		m.remove();
		m.add(new Message(""));
		m.add(new Message(""));
		m.remove();
		m.remove();
		m.remove();
		m.remove();
		//after 8 removals, the head should be the ninth added
		assertEquals("test", m.peek().getText());
	}

	
	public void testResize(){
		MessageQueue m = new MessageQueue(4);
		m.add(new Message("0"));
		m.add(new Message("1"));
		m.add(new Message("2"));
		m.add(new Message("3"));
		m.add(new Message("4"));
		m.add(new Message("5"));
		m.add(new Message("6"));
		m.add(new Message("7"));
		char c0 = m.remove().getText().charAt(0);
		char c1 = m.remove().getText().charAt(0);
		char c2 = m.remove().getText().charAt(0);
		char c3 = m.remove().getText().charAt(0);
		char c4 = m.remove().getText().charAt(0);
		char c5 = m.remove().getText().charAt(0);
		char c6 = m.remove().getText().charAt(0);
		char c7 = m.remove().getText().charAt(0);
		assertTrue(c0 == '0' && c1 == '1' && c2 == '2' && c3 == '3' && c4 == '4' && c5 == '5' && c6 == '6' && c7 == '7');
	}
}
