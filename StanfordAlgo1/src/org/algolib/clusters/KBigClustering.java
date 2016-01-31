package org.algolib.clusters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class KBigClustering {

	public static void main(String[] args) throws FileNotFoundException {
	
		File f = new File("p2/clustering_big.txt");
		Scanner sc = new Scanner(f);
		String[] fline = sc.nextLine().split("[\\s\\t]");
		int n = Integer.parseInt(fline[0]);
		int bits = Integer.parseInt(fline[1]);
		System.out.println("Number of vertices = "+n);
		int uniqCount = 0;
		int duplicateCount = 0;
		int counter=0;
		List<Edge> edgeList = new ArrayList<Edge>();
		Set<Integer> numberSet = new LinkedHashSet<Integer>(); 
		//n = 10000;
		while(sc.hasNextLine() && counter<n){
			//System.out.println("Line number = "+(counter+1));
			String line = sc.nextLine();
			String[] verexBits = line.split("[\\s\\t]");
			int num = bitsToInt(verexBits);
			if(numberSet.contains(num)){
				duplicateCount++;
			}else{
				uniqCount++;
				numberSet.add(num);
			}
			counter++;
		}
		
		System.out.println("Total = "+counter);
		System.out.println("Unique vertices="+uniqCount);
		System.out.println("Duplicate Count="+duplicateCount);
		sc.close();
		
		for(Integer x : numberSet){
			//find 1 distance edges
			List<Integer>  dist_1 = bitCombinations(1, 24);
			Set<Integer> oneDistanceSet = new HashSet<Integer>();
			for(Integer bit_1 : dist_1){
				int y = x & bit_1;
				if(!oneDistanceSet.contains(y) && numberSet.contains(y)){
					oneDistanceSet.add(y);
					
				}
				
			}
			List<Integer>  dist_1 = bitCombinations(1, 24);
			for(Integer bit_1 : dist_1){
				int y = x & bit_1;
				if(numberSet.contains(y)){
					
				}
			}
		}
	}
	
	static int convertBitsToInt(String[] bits){
		int x=0;
		//System.out.println(bits.length);
		for(int i=bits.length-1;i>=0;i--){
			x += Integer.parseInt(bits[i])*Math.pow(2,bits.length-i-1);
		}
		return x;
	}
	
	static int bitsToInt(String[] bits){
		int x = 0;
		for(int i=0;i<bits.length;i++){
			int b = Integer.parseInt(bits[i]);
			x = x << 1 | b;
		}
		return x;
	}
	
	static int hammingDistance(int a,int b){
		int c = a^b;
		int bitcount = 0;
		for (int i = 0; i < 24; i++) {
			if((c&1)==1){
				bitcount++;
				c=c>>1;
			}
		}
		return bitcount;
	}
	
	/**
	 * if ones =1 and bitLength =2
	 * 01
	 * 10
	 * if ones =1 and bitLength =3
	 * 001
	 * 010
	 * 100
	 * if ones =2 and bitLength =3
	 * 011
	 * 110
	 * 101
	 * @param ones
	 * @param bitLength
	 * @return
	 */
	static void bitCombinations(String prefix, int ones, int bitLength,List<String> bits) {

		if (bitLength == 0) {
			//System.out.println(prefix);
			bits.add(prefix);
			return;
		} else if (ones == 0) {
			bitCombinations(prefix + 0, ones, bitLength - 1, bits);
		} else if (ones == bitLength) {
			bitCombinations(prefix + 1, ones - 1, bitLength - 1, bits);
			return;
		} else if (ones < bitLength) {

			bitCombinations(prefix + 1, ones - 1, bitLength - 1, bits);
			bitCombinations(prefix + 0, ones, bitLength - 1, bits);
		}

	}
	
	static List<Integer> bitCombinations( int ones, int bitLength) {
		List<String> bits = new ArrayList<String>();
		List<Integer> intBits = new ArrayList<Integer>();
		bitCombinations("", ones, bitLength, bits);
		for(String b : bits){
			intBits.add(bitsToInt(b.split("")));
		}
		return intBits;
	}
	
	

}

