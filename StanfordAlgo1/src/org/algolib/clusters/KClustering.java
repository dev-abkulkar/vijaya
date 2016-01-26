package org.algolib.clusters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class KClustering {

	
	static  List<Edge> edges = new ArrayList<Edge>();
	static Map<Integer,Set<Integer>> parentToVeritces= new HashMap<Integer,Set<Integer>>();
	static Map<Integer,Integer> vertexToParent= new HashMap<Integer,Integer>();
	
	static long kCluster(int n,int kcluster ){
		
		int clusters = n;
		for(int i=0;i<n;i++){
			int vertex=i+1;
			Set<Integer> s = new HashSet<Integer>();
			s.add(vertex);
			parentToVeritces.put(vertex,s);
			vertexToParent.put(vertex, vertex);
		}	
		
		Collections.sort(edges);
		int counter = 0;
		while(true){
			Edge e =edges.get(counter);
			counter++;
			int pu = vertexToParent.get(e.u);
			int pv = vertexToParent.get(e.v);
			if (pu != pv) {
				int pusize = parentToVeritces.get(pu).size();
				int pvsize = parentToVeritces.get(pv).size();
				int minParent=-1;
				int newParent = -1;
				
				if (pusize < pvsize) {
					minParent = pu;
					newParent = pv;
				} else {
					minParent = pv;
					newParent = pu;
				}
				//update all the minsize clusters parent to the bigger clusters parent
				Set<Integer> minCluster = parentToVeritces.get(minParent); 
				for(Integer x : minCluster){
					vertexToParent.put(x,newParent);
					parentToVeritces.get(newParent).add(x);
				}
				parentToVeritces.remove(minParent);
				clusters--;
				if(clusters == kcluster)
					break;
				
			}
			
		}
		System.out.println("Total number of clusters = "+parentToVeritces.size());
		for(int x: parentToVeritces.keySet()){
			System.out.println(x+"==>"+parentToVeritces.get(x));
		}
		
		int z  = counter;
		long maxLength = -1;
		while(z<edges.size()){
			Edge e = edges.get(z);
			z++;
			int pu = vertexToParent.get(e.u);
			int pv = vertexToParent.get(e.v);
			if (pu != pv) {
				/*if(maxLength < e.length){
					maxLength = e.length;
				}*/
				return e.length;
			}
		}
		return maxLength;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("p2/clustering1.txt");
		f = new File("p2/cluster4.txt");
		Scanner sc = new Scanner(f);
		int n = sc.nextInt();
		//long[][] g = new long[n][n];
		
		while(sc.hasNext()){
			
			int u = sc.nextInt();
			int v = sc.nextInt();
			long d = sc.nextLong();
			//g[u][v] = g[v][u] = d;
			
			edges.add(new Edge(u,v,d));
		}
		
		System.out.println("Max spacing = "+kCluster(n, 6));
		
		sc.close();
	}
	
	
	static class Edge implements Comparable<Edge>{
		int  u,v;
		long length; 
		Edge(int u2,int v2,long length){
			this.v=v2;
			this.u=u2;
			this.length=length;
		}
		
		@Override
		public int compareTo(Edge o) {
			return (int) (this.length-o.length);
		}

		@Override
		public String toString() {
			return "Edge [u=" + u + ", v=" + v + ", length=" + length + "]";
		}
	}
	
	
	
	
	
	
	
}
