package org.algolib.clusters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
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
		/*String[] s = "10000".split("");
		System.out.println(Arrays.toString(s));
		System.out.println("Normal="+convertBitsToInt(s));
		System.out.println("BitMagic="+convertBitsToIntUsingBitMagic(s));
		System.out.println();*/
		Set<Integer> numberSet = new HashSet<Integer>(); 
		n = 10000;
		while(sc.hasNextLine() && counter<n){
			System.out.println("Line number = "+(counter+1));
			String line = sc.nextLine();
			String[] verexBits = line.split("[\\s\\t]");
			int num = convertBitsToIntUsingBitMagic(verexBits);
			if(numberSet.contains(num)){
				duplicateCount++;
			}else{
				uniqCount++;
				numberSet.add(num);
			}
			counter++;
		}
		List<Integer> uniqIntegers = new ArrayList<Integer>(numberSet);
		numberSet=null;
		//int[][] edges = new int[uniqCount][uniqCount];
		for(int i=0;i<uniqCount;i++){
			for(int j=0;j<uniqCount;j++)
				;
		}
		System.out.println("Total = "+counter);
		System.out.println("Unique vertices="+uniqCount);
		System.out.println("Duplicate Count="+duplicateCount);
		sc.close();
	}
	
	static int convertBitsToInt(String[] bits){
		int x=0;
		//System.out.println(bits.length);
		for(int i=bits.length-1;i>=0;i--){
			x += Integer.parseInt(bits[i])*Math.pow(2,bits.length-i-1);
		}
		return x;
	}
	
	static int convertBitsToIntUsingBitMagic(String[] bits){
		int x = 0;
		for(int i=0;i<bits.length;i++){
			int b = Integer.parseInt(bits[i]);
			x = x << 1 | b;
		}
		return x;
	}
	
	

}

