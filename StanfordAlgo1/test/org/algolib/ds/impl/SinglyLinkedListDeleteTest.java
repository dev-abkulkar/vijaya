package org.algolib.ds.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class SinglyLinkedListDeleteTest {

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
	public void testDeleteAtHead() throws Exception{
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertAtHead(3);
		sll.insertAtHead(2);
		sll.insertAtHead(1);
		
		System.out.print("Before :");
		sll.printList();
		sll.deleteHead();
		System.out.print("After :");
		sll.printList();

		
	}
	
	@Test
	public void testDeleteAtTail(){
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertAtTail(1);
		sll.insertAtTail(2);
		sll.insertAtTail(3);
		
		System.out.print("Before :");
		sll.printList();
		sll.deleteTail();
		System.out.print("After :");
		sll.printList();
	}
	
	@Test
	public void testDeleteAtPos() throws Exception{
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertAtTail(1);
		sll.insertAtTail(2);
		sll.insertAtTail(3);
		sll.insertAtTail(4);
		
		System.out.print("Before :");
		sll.printList();
		sll.deleteAtPos(2);
		System.out.print("After :");
		sll.printList();
	}
	
	@Test
	public void testDeleteAtLastPos() throws Exception{
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertAtTail(100);
		sll.insertAtTail(200);
		sll.insertAtTail(300);
		System.out.print("Before :");
		sll.printList();
		sll.deleteAtPos(3);
		System.out.print("After :");
		sll.printList();
	}
	
	@Test
	public void testDeleteAtPos0() throws Exception{
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertAtTail(0);
		sll.insertAtTail(100);
		sll.insertAtTail(200);
		System.out.print("Before :");
		sll.printList();
		sll.deleteAtPos(0);
		System.out.print("After :");
		sll.printList();
	}
	
	@Test
	public void testDeleteAtPosINF() throws Exception{
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertAtTail(0);
		sll.insertAtTail(1);
		sll.insertAtTail(2);
		try{
			System.out.print("Before :");
			sll.printList();
			sll.deleteAtPos(Integer.MAX_VALUE);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.print("After :");
		sll.printList();
	}
	
	@Test
	public void testDeleteAtPosNegative() throws Exception{
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertAtTail(0);
		sll.insertAtTail(1);
		sll.insertAtTail(2);
		try{
			System.out.print("Before :");
			sll.printList();
			sll.deleteAtPos(-100);

		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.print("After :");
		sll.printList();
	}
	
	@Test
	public void testDeleteOnEmptyList() throws Exception{
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		try{
			System.out.print("Before :");
			sll.printList();
			sll.deleteHead();

		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.print("After :");
		sll.printList();
	}
	
}
