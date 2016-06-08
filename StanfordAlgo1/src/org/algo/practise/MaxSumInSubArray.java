package org.algo.practise;

public class MaxSumInSubArray {

	public static int maxSumInSubArray(int[] a) throws Exception{
		if(a==null || a.length==0) 
			throw new Exception("Input Array is null!");
		int maxSum=0;
		if(a.length==1)
			maxSum= a[0];
		else{
			int curSum=a[0];
			//because even if an array has all negative items,
			//we need to return the smallest negative element not 0!
			maxSum=curSum;
			for (int i = 1; i < a.length; i++) {
				curSum = (a[i] + curSum > a[i])?a[i] + curSum:a[i];  
				maxSum = (maxSum < curSum) ? curSum : maxSum;	
			}
		}
		return maxSum;
	}
	
}
