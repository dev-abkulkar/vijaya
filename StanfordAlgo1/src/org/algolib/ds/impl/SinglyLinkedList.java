package org.algolib.ds.impl;

import org.algolib.ds.LNode;
import org.algolib.ds.LinkedList;

public class SinglyLinkedList<T> implements LinkedList<T> {

	LNode<T> head;
		
	public LNode<T> getHead(){
		return this.head;
	}

	@Override
	public void insertAtHead(T data) {
		
		LNode<T> lnode = new LNode<T>(data);
		lnode.setNext(this.head);
		this.head=lnode;
		
	}

	@Override
	public void insertAtTail(T data) {
		LNode<T> lnode = new LNode<T>(data);
		if(this.head==null)
			this.head=lnode;
		else{
			LNode<T> current = this.head;
			while(current.getNext()!=null){
				current = current.getNext();
			}
			current.setNext(lnode);
		}
	}

	@Override
	public void insertAtPos(T data, int pos) throws Exception {
		LNode<T> lnode = new LNode<T>(data);
		if(pos==1){
			insertAtHead(data);
		}else{
			int curpos= 1;
			LNode<T> curNode = this.head;
			while(curNode!=null && curpos < pos-1){
				curNode=curNode.getNext();
				curpos++;
			}
			if(curNode==null)
				throw new Exception("Linked List is short. Cannot insert at "+pos);
			lnode.setNext(curNode.getNext());
			curNode.setNext(lnode);
		}
		
	}

	@Override
	public void deleteHead() {
		if(this.head!=null){
			this.head=this.head.getNext();
		}
	}

	@Override
	public void deleteTail() {
		if(this.head!=null){
			if(this.head.getNext()==null){
				this.head=null;
			}
			LNode<T> curNode= this.head;
			while(curNode.getNext().getNext()!=null){
				curNode = curNode.getNext();
			}
			curNode.setNext(null);//this deletes the tail thru gc;
		}
		
	}

	@Override
	public void deleteAtPos(int pos) throws Exception {
		if(this.head!=null){
			if(pos==1)
				this.deleteHead();
			else{
				LNode<T> curNode= this.head;
				int curpos = 1;
				while(curNode!=null && curpos<pos-1){
					curNode=curNode.getNext();
					curpos++;
				}
				if (curNode == null || curNode.getNext()==null) {
					throw new Exception("No item at position "+pos+" to be deleted");
				}
				if(curpos==pos-1){
					curNode.setNext(curNode.getNext().getNext());//deletes node and gives it for gc
				}
				
			}
			
		}
		
	}

	@Override
	public void printList() {
		LNode<T> curNode = this.head;
		while(curNode!=null){
			System.out.print(curNode.getData());
			if(curNode.getNext()!=null){
				System.out.print("=>");
			}
			curNode=curNode.getNext();
		}
	}
}
