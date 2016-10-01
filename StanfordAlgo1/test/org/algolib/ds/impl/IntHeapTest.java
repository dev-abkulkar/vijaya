package org.algolib.ds.impl;

import java.util.Arrays;

import org.algolib.ds.Heap;
import org.algolib.ds.HeapOrder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntHeapTest {

	@Before
	public void before() {
		System.out.println("------------------------------------------------------");
	}
	
	@Test
	public void testheapBuild(){
		Integer[] testArray= {120,210,4,70,500,100}; 
		Heap<Integer> h = new IntHeap();
		h.bottomUpHeapify(testArray);
		System.out.println(Arrays.toString(h.getArrayCopyOfHeap()));
		Assert.assertArrayEquals(new Integer[]{500, 210, 100, 70, 120, 4}, h.getArrayCopyOfHeap());
	}
	
	@Test
	public void testheapBuildMin(){
		Integer[] testArray= {120,210,4,70,500,100}; 
		Heap<Integer> h = new IntHeap(HeapOrder.ASC);
		h.bottomUpHeapify(testArray);
		System.out.println("->"+Arrays.toString(h.getArrayCopyOfHeap()));
		Assert.assertArrayEquals(new Integer[]{4, 70, 100, 210, 500, 120}, h.getArrayCopyOfHeap());
	}
	
	@Test
	public void testInsertHeap(){
		Integer[] testArray= {120,210,4,70,500,100}; 
		Heap<Integer> h = new IntHeap();
		h.bottomUpHeapify(testArray);
		h.insert(700);
		System.out.println("After inserting 700 "+Arrays.toString(h.getArrayCopyOfHeap()));
		Assert.assertEquals(new Integer(700), h.getArrayCopyOfHeap()[0]);
	}
	
	@Test
	public void testExtractTopPriority(){
		Integer[] testArray= {120,210,4,70,500,100}; 
		Heap<Integer> h = new IntHeap();
		h.bottomUpHeapify(testArray);
		System.out.println("Before extract "+Arrays.toString(h.getArrayCopyOfHeap()));
		Integer top = h.extractTopPriority();
		Assert.assertEquals(new Integer(500), top);
		System.out.println("After extract "+Arrays.toString(h.getArrayCopyOfHeap()));
	}
	
	@Test
	public void multiInsert(){
		Integer[] testArray= {120,210,4,70,500,100}; 
		Heap<Integer> h = new IntHeap();
		for(Integer i : testArray){
			h.insert(i);
			System.out.println("After inserting "+i+" :"+Arrays.toString(h.getArrayCopyOfHeap()));
		}
		Assert.assertArrayEquals(new Integer[]{500, 210, 100, 70, 120, 4}, h.getArrayCopyOfHeap());
	}
	
}
