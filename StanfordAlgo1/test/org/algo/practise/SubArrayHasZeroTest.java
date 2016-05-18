package org.algo.practise;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

public class SubArrayHasZeroTest {

	
	@Test
	public void testHasSubArrayWithZeroSum(){
		int[] a = {2,1,-3,-6};
		System.out.println("Array is "+Arrays.toString(a));
		boolean hasZeroSumArray = SubArrayHasZero.hasSubArrayWithZeroSum(a);
		Assert.assertTrue(hasZeroSumArray);
	}
	
	@Test
	public void testHasSubArrayWithZeroSumZeroelement(){
		int[] a = {2,1,0,3,4};
		System.out.println("Array is "+Arrays.toString(a));
		boolean hasZeroSumArray = SubArrayHasZero.hasSubArrayWithZeroSum(a);
		Assert.assertTrue(hasZeroSumArray);
	}
	
	
	@Test
	public void testHasSubArrayWithZeroSumZeroSubArray(){
		int[] a = {2,1,3,-3,4};
		System.out.println("Array is "+Arrays.toString(a));
		boolean hasZeroSumArray = SubArrayHasZero.hasSubArrayWithZeroSum(a);
		Assert.assertTrue(hasZeroSumArray);
	}
}
