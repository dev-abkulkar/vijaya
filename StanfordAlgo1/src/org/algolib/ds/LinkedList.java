package org.algolib.ds;

public interface LinkedList<T> {
	
	public void insertAtHead(T data);
	public void insertAtTail(T data);
	public void insertAtPos(T data, int pos) throws Exception;
	
	public void deleteHead();
	public void deleteTail();
	public void deleteAtPos(int pos) throws Exception;
	
	
	public void printList();
	
}
