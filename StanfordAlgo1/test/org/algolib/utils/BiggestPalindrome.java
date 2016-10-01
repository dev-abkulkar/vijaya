package org.algolib.utils;

public class BiggestPalindrome {
	
	
	Integer s = 0;
	public static int biggestPalindrome(String s){
		String[] str = s.split("");
		
		return findBiggestPalin(str,0,str.length-1);
	}
	
	private static int findBiggestPalin(String[] str, int i, int j) {
		if(i>j)
			return 0;
		if(i==j)
			return 1;
		if(str[i].equals(str[j]))
			return 2+findBiggestPalin(str,i+1,j-1);
		else{
			return Math.max(findBiggestPalin(str,i+1,j),findBiggestPalin(str,i,j-1));
		} 
	}

	public static void main(String[] args) {
		System.out.println(biggestPalindrome("AA"));		

	}


}
