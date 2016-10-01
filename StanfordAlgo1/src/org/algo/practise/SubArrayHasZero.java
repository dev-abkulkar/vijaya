package org.algo.practise;

import java.util.HashMap;

public class SubArrayHasZero {

	public static void main(String[] args) {
		int[] a = {2,1,-3,-6};
		System.out.println(hasSubArrayWithZeroSum(a));
	}

	static boolean hasSubArrayWithZeroSum(int[] a) {
		HashMap<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
		int sum=0;
		for (int i = 0; i < a.length; i++) {
			sum+= a[i];
			if(sum==0 || a[i]==0 || sumMap.get(sum)!=null)
				return true;
			sumMap.put(sum,i);
		}
		
		return false;
	}

}
