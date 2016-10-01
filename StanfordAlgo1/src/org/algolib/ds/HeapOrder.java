package org.algolib.ds;

public enum HeapOrder {
	ASC(-1),
	DESC(1);
	
	private int val = -1;
	
	HeapOrder(int val){
		this.val =val;
	}
}
