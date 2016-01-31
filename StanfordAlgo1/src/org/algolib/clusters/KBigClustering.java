package org.algolib.clusters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class KBigClustering {

	public static void main(String[] args) throws FileNotFoundException {
	
		File f = new File("p2/clustering_big.txt");
		//f = new File("p2/");
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
		List<Integer> allNumbers = new ArrayList<Integer>();
		n = 1000;
		while(sc.hasNextLine() && counter<n){
			//System.out.println("Line number = "+(counter+1));
			String line = sc.nextLine();
			String[] verexBits = line.split("[\\s\\t]");
			//System.out.println("Vertex Bits = "+verexBits.length);
			int num = bitsToInt(verexBits);
			if(numberSet.contains(num)){
				duplicateCount++;
				edgeList.add(new Edge(num,num,0));
			}else{
				uniqCount++;
				numberSet.add(num);
			}
			allNumbers.add(num);
			
			counter++;
		}
		
		findDistances(allNumbers);
		
		System.out.println("Total = "+counter);
		System.out.println("Unique vertices="+uniqCount);
		System.out.println("Duplicate Count="+duplicateCount);
		System.out.println("Edges added = "+edgeList.size());
		sc.close();
		List<Edge> oneEdgeList = new ArrayList<Edge>();
		List<Edge> twoEdgeList = new ArrayList<Edge>();
		//Set<Integer> vertexAddedToEdge = new LinkedHashSet<Integer>();
		Map<Integer,Integer> edgeAdded = new HashMap<Integer,Integer>();
		for(Integer x : numberSet){
			//find 1 distance edges
			List<Integer>  dist_1 = bitCombinations(1, 24);
			for(Integer bit_1 : dist_1){
				int y = x ^ bit_1;
				if(numberSet.contains(y)){
					if((edgeAdded.get(x)!=null && edgeAdded.get(x)==y) || (edgeAdded.get(y)!=null && edgeAdded.get(y)==x))
						continue;
					edgeAdded.put(x, y);
					//edgeAdded.put(y, x);
					Edge e= new Edge(x,y,1);
					edgeList.add(e);
					oneEdgeList.add(e);
				}
				
			}
			
			List<Integer>  dist_2 = bitCombinations(2, 24);
			
			for(Integer bit_2 : dist_2){
				int z = x ^ bit_2;
				if(numberSet.contains(z)){
					if((edgeAdded.get(x)!=null && edgeAdded.get(x)==z) || (edgeAdded.get(z)!=null && edgeAdded.get(z)==x))
						continue;
					edgeAdded.put(x, z);
					//edgeAdded.put(z, x);

					Edge e = new Edge(x,z,2);
					edgeList.add(e);
					twoEdgeList.add(e);
				}
			}
			
		}
		
		System.out.println("Edges with Lenght = 1 "+oneEdgeList.size());
		for (Edge edge : oneEdgeList) {
			System.out.println(edge);
		}
		System.out.println("Edges with Length = 2 "+twoEdgeList.size());
		for (Edge edge : twoEdgeList) {
			System.out.println(edge);
		}
		
		
		
		/*Map<Integer,Set<Integer>> parentToVeritces = new HashMap<Integer,Set<Integer>>();
		Map<Integer,Integer> vertexToParent= new HashMap<Integer,Integer>();
		
		for(Integer vertex : vertexAddedToEdge){
			vertexToParent.put(vertex, vertex);
			Set<Integer> childs = new LinkedHashSet<Integer>();
			childs.add(vertex);
			parentToVeritces.put(vertex, childs);
		}
		Collections.sort(edgeList);
		int cluster = vertexAddedToEdge.size();
		int totalUniq = uniqCount-cluster;
		int edgeCount=0;
		
		while(true){
			if(vertexAddedToEdge.size()==0)
				break;
			Edge e = edgeList.get(edgeCount);
			int u = e.u;
			int v = e.v;
			edgeCount++;
			int pu = vertexToParent.get(u);
			int pv = vertexToParent.get(v);
			if(pu==pv)
				continue;
			int smallVertex=0;
			int bigVertex = 0;
			
			Set<Integer> uchilds = parentToVeritces.get(pu);
			Set<Integer> vchilds = parentToVeritces.get(pv);
			
			if(uchilds.size() < vchilds.size()){
				smallVertex = pu;
				bigVertex = pv;
			}else{
				smallVertex = pv;
				bigVertex = pu;
			}
			Set<Integer> childsOfSmall = parentToVeritces.get(smallVertex);
			for(Integer x: childsOfSmall){
				vertexToParent.put(x, bigVertex);
				parentToVeritces.get(bigVertex).add(x);
			}
			
			parentToVeritces.remove(smallVertex);
			
			vertexAddedToEdge.remove(u);
			vertexAddedToEdge.remove(v);
			cluster--;
			
		}
		System.out.println("Clusters = "+cluster);
		System.out.println("Left out vertices = "+totalUniq);
		System.out.println("Answer="+(cluster+totalUniq));*/
		
	}
	
	private static void findDistances(Collection<Integer> numberSet) {
		System.out.println("Numerb Set  Size="+numberSet.size());
		List<Integer> vrtices = new ArrayList<Integer>(numberSet);
		Map<Integer,Integer> countTo= new HashMap<Integer,Integer>();
		Set<Integer> addedToEdge = new HashSet<Integer>();
		
		
		for (int i = 0; i < vrtices.size(); i++) {
			for (int j = i + 1; j < vrtices.size(); j++) {
				Integer u = vrtices.get(i);
				Integer v = vrtices.get(j);
				/*if(addedToEdge.contains(u) && addedToEdge.contains(v))
					continue;*/
				int d = hd(u,v);
				if(countTo.containsKey(d)){
					int x = countTo.get(d);
					countTo.put(d, ++x);
				}else{
					countTo.put(d, 1);
				}
				addedToEdge.add(u);
				addedToEdge.add(v);
			}
		}
		System.out.println(countTo);
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
			intBits.add(bitsToInt(splitString2SingleArray(b)));
		}
		return intBits;
	}
	
	public static String[] splitString2SingleArray(String s){
	    if (s == null )
	        return null;
	    char[] c = s.toCharArray();
	    String[] sArray = new String[c.length];
	    for (int i = 0; i < c.length; i++) {
	        sArray[i] = String.valueOf(c[i]);
	    }
	    return sArray;
	}

	static int hd(int x, int y)
	{
	    int dist = 0;
	    int  val = x ^ y;

	    // Count the number of bits set
	    while (val != 0)
	    {
	        // A bit is set, so increment the count and clear the bit
	        dist++;
	        val &= val - 1;
	    }

	    // Return the number of differing bits
	    return dist;
	}
}

