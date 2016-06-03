package org.algolib.ds.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class SinglyLinkedListInsertTest {

	private long after;
	private long before;

	@Rule 
	public TestName name = new TestName();
	
	@Before
	public void before(){
		System.out.println();
		System.out.println(name.getMethodName());
		this.before = System.currentTimeMillis();
	}	
	
	@After
	public void after(){
		this.after = System.currentTimeMillis();
		System.out.println("Time Taken in seconds = "+ (this.after - this.before) / 1000D);
	}

	@Test
	public void testInsertAtHead(){
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertAtHead(3);
		sll.insertAtHead(2);
		sll.insertAtHead(1);
		sll.printList();
	}
	
	@Test
	public void testInsertAtTail(){
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertAtTail(1);
		sll.insertAtTail(2);
		sll.insertAtTail(3);
		sll.printList();
	}
	
	@Test
	public void testInsertAtPos() throws Exception{
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertAtTail(1);
		sll.insertAtTail(3);
		sll.insertAtTail(4);
		sll.insertAtPos(200, 2);
		sll.printList();
	}
	
	@Test
	public void testInsertAtLastPos() throws Exception{
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertAtTail(1);
		sll.insertAtTail(3);
		sll.insertAtTail(4);
		sll.insertAtPos(200, 4);
		sll.printList();
	}
	
	@Test
	public void testInsertAtPos0() throws Exception{
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertAtTail(0);
		sll.insertAtTail(1);
		sll.insertAtTail(2);
		sll.insertAtPos(200, 0);
		sll.printList();
	}
	
	@Test
	public void testInsertAtPosINF() throws Exception{
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertAtTail(0);
		sll.insertAtTail(1);
		sll.insertAtTail(2);
		try{
		sll.insertAtPos(200, 100);
		}catch(Exception e){
			e.printStackTrace();
		}
		sll.printList();
	}
	
	@Test
	public void testInsertAtPosNegative() throws Exception{
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertAtTail(0);
		sll.insertAtTail(1);
		sll.insertAtTail(2);
		try{
		sll.insertAtPos(200, -100);
		}catch(Exception e){
			e.printStackTrace();
		}
		sll.printList();
	}
	
}
