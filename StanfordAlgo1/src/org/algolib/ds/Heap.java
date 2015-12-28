package org.algolib.ds;

import java.util.Comparator;


public interface Heap<T extends Comparable<T>> {
	public T extractTopPriority();
	public void insert(T val);
	public T delete(T val);
	//public T[] getInternalArray();
	public int getSize();
	public boolean isEmpty();
	public T peek();
	/*
	 * The heap uses the compareTo() of T to check for ordering;
	 * If the ordering is DESC, then negates the result of compareTo
	 * and builds the heap
	 */
	
	public HeapOrder getHeapOrder();
	public void bottomUpHeapify(T[] vals);
	
	T[] getArrayCopyOfHeap();
	
}
