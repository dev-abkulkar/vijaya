package org.algolib.traversals;

import org.junit.After;
import org.junit.Test;

public class PrimsMSTTest {
	int INF = Integer.MAX_VALUE;
	
	@Test
	public void testPrims(){
			long graph[][] = {	{0, 2,INF , 6, INF},
		            			{2, 0, 3, 8, 5},
		            			{INF, 3, 0, INF, 7},
		            			{6, 8, INF, 0, 9},
		            			{INF, 5, 7, 9, 0},
		           };	
			int[] parent = PrimsMST.prims(graph,0);
			int tc =0;
			
			for (int i = 1; i < parent.length; i++) {
				long cost=graph[parent[i]][i];
				tc+=cost;
				System.out.printf("%d -->%d = %d\n",parent[i],i,cost);
			}
			
			System.out.println("MST Cost = "+tc);
	}
	
	@Test
	public void testPrimsWithDiffSeed(){
			long graph[][] = {	{0, 2,INF , 6, INF},
		            			{2, 0, 3, 8, 5},
		            			{INF, 3, 0, INF, 7},
		            			{6, 8, INF, 0, 9},
		            			{INF, 5, 7, 9, 0},
		            };	
			int[] parent = PrimsMST.prims(graph,0);
			int tc =0;
			
			for (int i = 0; i < parent.length; i++) {
				if(parent[i]==-1) 
					continue;
				long cost=graph[parent[i]][i];
				tc+=cost;
				System.out.printf("%d -->%d = %d\n",parent[i],i,cost);
			}
			
			System.out.println("MST Cost = "+tc);
	}
	
	@Test
	public void testPrimsTims(){
			long graph[][] = {	{0, 1, 3 , 4},
		            			{1, 0, 2, INF},
		            			{3, 2, 0, 5},
		            			{4, INF, 5, 0},
		           };	
			int[] parent = PrimsMST.prims(graph,0);
			int tc =0;
			
			for (int i = 0; i < parent.length; i++) {
				if(parent[i]==-1) 
					continue;
				long cost=graph[parent[i]][i];
				tc+=cost;
				System.out.printf("%d -->%d = %d\n",parent[i],i,cost);
			}
			
			System.out.println("MST Cost = "+tc);
			
	}
	
	@Test
	public void testPrimsTimsOtherRoot(){
			long graph[][] = {	{0, 1, 3 , 4},
		            			{1, 0, 2, INF},
		            			{3, 2, 0, 5},
		            			{4, INF, 5, 0},
		           };	
			int [] parent = PrimsMST.prims(graph,3);
			int tc =0;
			
			for (int i = 0; i < parent.length; i++) {
				if(parent[i]==-1) 
					continue;
				long cost=graph[parent[i]][i];
				tc+=cost;
				System.out.printf("%d -->%d = %d\n",parent[i],i,cost);
			}
			
			System.out.println("MST Cost = "+tc);
			
	}
	
	@After
	public void after(){
		System.out.println();
	}
	
}
