package org.algolib.traversals;

import java.util.Arrays;

public class PrimsMST {

	
	static long INF = Long.MAX_VALUE;
	
	static int findMinVertex(long out[], boolean[] v) {
		//System.out.println("OUT[]= "+Arrays.toString(out));
		//System.out.println("Visisted[] ="+Arrays.toString(v));
		long min = Long.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < out.length; i++) {
			if (v[i]==false && out[i] < min) {
				minIndex = i;
				min = out[i];
			}
		}
		//System.out.println("Min edge = "+min);
		//System.out.println("Vertex chosen: "+(minIndex+1));
		System.out.println();
		return minIndex;
	}
	
	
	
	public static int[] prims(long g[][],int root){
		int n = g[0].length;
		
		long out[] = new long[n];
		boolean v[] = new boolean[n];
		int parent[] = new int[n];
		
		
		Arrays.fill(out,INF);
		parent[root]=-1;
		out[root]=0;
		
		for (long j = 0; j < n - 1; j++) {
			int newV = findMinVertex(out, v);
			v[newV] = true;
			
			for (int k = 0; k < n; k++) {
				if (v[k] == false && g[newV][k]!=INF && g[newV][k] < out[k]) {
					out[k] = g[newV][k];
					parent[k] = newV;
				}
			}
		}
		
		return parent;
		
	}
	
	public static long totalMSTCost(long graph[][],int[] parent,boolean prlong){
		long tc =0;
		
		for (int i = 0; i < parent.length; i++) {
			if(parent[i]==-1) 
				continue;
			long cost=graph[(int) parent[i]][i];
			tc+=cost;
			if(prlong)
				System.out.printf("%d -->%d = %d\n",parent[i]+1,i+1,cost);
		}
		return tc;
	}
	
	
}
