package org.algolib.utils;

import java.util.Arrays;

public class PermutationsBackTrack {

	public static void main(String[] args) {
		String test = "ABC";
		permute(test.toCharArray(),0);
		
	}

	private static void permute(char[] charArray, int i) {
		if(i>=charArray.length)
			System.out.println(Arrays.toString(charArray));
		
		for(int k=i;k<charArray.length;k++){
			swap(i,k,charArray);
			permute(charArray, i+1);
			swap(i,k,charArray);
		}
	}

	private static void swap(int i, int k, char[] charArray) {
		char temp = charArray[i];
		charArray[i] = charArray[k];
		charArray[k]=temp;
	}
	
}
