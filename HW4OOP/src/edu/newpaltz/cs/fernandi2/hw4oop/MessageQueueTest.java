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

}
