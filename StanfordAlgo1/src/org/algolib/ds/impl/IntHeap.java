package org.algolib.ds.impl;

import java.util.Arrays;

import org.algolib.ds.Heap;
import org.algolib.ds.HeapOrder;

/*
 * class that provides a basic implementation of MAX-Heap 
 * for integters
 */
// TODO: use bit operators to speed up divide by 2 and others
// TODO: use a better method than constantly resizing the array.

public class IntHeap implements Heap<Integer> {

	private HeapOrder relativeOrder;
	
	private Integer[] heapArr = new Integer[0];
	private int size;

	
	public IntHeap() {
		this.relativeOrder = HeapOrder.DESC;
	}
	public IntHeap(HeapOrder order) {
		this.relativeOrder = order;
	}

	@Override
	public Integer extractTopPriority() {
		if(this.isEmpty())
			throw new RuntimeException("Heap is empty");
		Integer top = new Integer(this.heapArr[0]);
		this.swap(0, this.size-1);
		this.heapArr = Arrays.copyOf(this.heapArr, this.size - 1);
		this.size--;
		this.bottomUpHeapify();
		return top;
	}

	@Override
	public void insert(Integer val) {
		
		this.heapArr = Arrays.copyOf(this.heapArr, this.size+1);
		this.heapArr[this.size]=val;
		this.bottomUpHeapify();
	}

	private void bottomUpHeapify() {
		this.size = this.heapArr.length;
		for (int i = (this.size - 2) / 2; i >= 0; i--) {
			buHeapAtParent(i);
		}
		
	}
	@Override
	public Integer delete(Integer val) {
		throw new UnsupportedOperationException("delete not yet implemented");
	}

	@Override
	public void bottomUpHeapify(Integer[] vals) {
		this.heapArr = Arrays.copyOf(vals, vals.length);
		this.bottomUpHeapify();
	}
	
	
	public void buHeapAtParent(int index){
		if(index >= this.size )
			throw new RuntimeException("Cannot build a heap at "+index+" when the heap size is "+this.size);
		
		int lc = 2 * index + 1;
		int rc = 2 * index + 2;
		int max = index;

		if (lc < size && this.compare(this.heapArr[max],heapArr[lc]) > 0) {
			max = lc;
		}

		if (rc < size && this.compare(this.heapArr[max],heapArr[rc]) > 0) {
			max = rc;
		}

		if (max != index) {
			this.swap(max, index);
			this.buHeapAtParent(max);
		}
		
	}
	
	private void swap(int p, int q) {
		Integer temp = this.heapArr[p];
		this.heapArr[p] = this.heapArr[q];
		this.heapArr[q] = temp;
	}
	

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size ==0 || this.heapArr == null || this.heapArr.length == 0;
	}

	@Override
	public Integer peek() {
		if (this.getSize() > 0)
			return this.heapArr[0];
		else
			return null;
	}

	@Override
	public HeapOrder getHeapOrder() {
		return this.relativeOrder;
	}

	
	
	private int compare(Integer a, Integer b){
		int result = a.compareTo(b);
		if(this.getHeapOrder().equals(HeapOrder.DESC))
			return -result;
		return result;
	}

	@Override
	public Integer[] getArrayCopyOfHeap() {
		return Arrays.copyOf(this.heapArr, this.heapArr.length);
	}

	
	
}
