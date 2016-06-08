package org.algo.practise;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class MaxSumInSubArrayTest {

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
	
	@Test(expected=Exception.class)
	public void testMaxSumInSubArrayForNullArray() throws Exception{
		int[] a = null;
		int maxSum = MaxSumInSubArray.maxSumInSubArray(a);
		System.out.println(maxSum);
	}
	
	@Test(expected=Exception.class)
	public void testMaxSumInSubArrayForEmptyArray() throws Exception{
		int[] a = new int[0];
		int maxSum = MaxSumInSubArray.maxSumInSubArray(a);
		System.out.println(maxSum);
	}
	
	@Test
	public void testMaxSumInSubArrayForNegativeArray() throws Exception{
		int[] a = {-100,-1,-2,-3};
		int maxSum = MaxSumInSubArray.maxSumInSubArray(a);
		System.out.println(maxSum);
	}
	
	@Test
	public void testMaxSumInSubArrayForPositiveArray() throws Exception{
		int[] a = {10,20,-1,10,20,-7};
		int maxSum = MaxSumInSubArray.maxSumInSubArray(a);
		System.out.println(maxSum);
	}
	
}
