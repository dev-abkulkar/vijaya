package org.algolib.traversals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DjikstraOnMatrix {

	//static int INF = Integer.MAX_VALUE;
	static int INF=10000;
	static int graph2[][] = { 	{ 0, 1, 4, 8 }, 
								{ INF, 0, 2, INF },
								{ 5, INF, 0, 3 }, 
								{ INF, INF, INF, 0 } 
							};
	static int graph[][] = {{0, 4, INF, INF, INF, INF, INF, 8, INF},
					        {4, 0, 8, INF, INF, INF, INF, 11, INF},
					        {INF, 8, 0, 7, INF, 4, INF, INF, 2},
					        {INF, INF, 7, 0, 9, 14, INF, INF, INF},
					        {INF, INF, INF, 9, 0, 10, INF, INF, INF},
					        {INF, INF, 4, INF, 10, 0, 2, INF, INF},
					        {INF, INF, INF, 14, INF, 2, 0, 1, 6},
					        {8, 11, INF, INF, INF, INF, 1, 0, 7},
					        {INF, INF, 2, INF, INF, INF, 6, 7, 0}
       };
	//static int dist[] = new int[graph[0].length];
	static int[] vals = {7,37,59,82,99,115,133,165,188,197};
	
	public static void main(String[] args) throws FileNotFoundException {
		int source =0;
		Scanner sc = new Scanner(new File("dijkstraData.txt"));
		int xgraph[][] = new int[200][200];
		
		int size=xgraph[0].length;
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++){
				if(i==j){
					xgraph[i][j]=0;
				}
				else{
					xgraph[i][j]=INF;
				}
			}
		
		while(sc.hasNext()){
			String line = sc.nextLine();
			String[] l = line.split("[\\s\\t]");
			String from = l[0];
			for(int i=1;i<l.length;i++){
				String[] tuple = l[i].split(",");
				int u = Integer.parseInt(from);
				int v = Integer.parseInt(tuple[0]);
				int weight = Integer.parseInt(tuple[1]);
				xgraph[u-1][v-1] = weight;
			}
		}
		
		sc.close();
		
		//djikstra(graph, dist, source);
		//for(int i=0;i<graph[0].length;i++ )
		
		dj(xgraph,source);
		
	}

	private static void dj(int[][] graph, int source) {
		int size = graph[0].length;
		int dist[] = new int[size];
		
		for(int i=0;i<size;i++){
			dist[i]=INF;
		}
		
		boolean[] visited = new boolean[size];
		dist[source]=0;
		
		
		for (int count = 0; count <size - 1; count++) {
			int minIndex = findMin(dist, visited);
			//System.out.println("Minimum "+minIndex);
			
			visited[minIndex] = true;
			
			for (int j = 0; j < size; j++) {
				if (visited[j] == false && dist[minIndex]!=INF && graph[minIndex][j]!=INF &&(dist[j] > dist[minIndex] + graph[minIndex][j])) {
					dist[j] = dist[minIndex] + graph[minIndex][j];
				}
			}
		}
		
		System.out.println("for "+source+"==>"+Arrays.toString(dist));
		for(int c=0;c<vals.length;c++){
			System.out.print(dist[vals[c]-1]+",");
		}
		
	}

	private static int findMin(int[] dist, boolean[] visited) {
		int minVal,min;
		minVal=min=INF;
		for(int i=0;i<visited.length;i++){
			if(visited[i]==false && dist[i]<=minVal){
				min=i;
				minVal=dist[i];
			}
			
		}
		return min;
	}

/*	private static void djikstra(int[][] graph, int[] dist, int source) {
		Set<Integer> v = new HashSet<Integer>();
		v.add(source);

		Set<Integer> nv = new HashSet<Integer>();
		for (int i = 0; i < graph[0].length; i++) {
			nv.add(i);
		}
		nv.remove(source);
		//boolean seenFlag[] = new boolean[graph[0].length];
		//seenFlag[source]
		while (v.size() != graph[0].length) {
			for (final Iterator<Integer> seenIterator = v.iterator(); seenIterator.hasNext();) {
				int seen = seenIterator.next();
				int min = INF;
				int index = -1;
				
				for (final Iterator<Integer> unseenIterator = nv.iterator(); unseenIterator.hasNext();) {
					int notSeen = unseenIterator.next();
					if (dist[seen] + graph[seen][notSeen] < min) {
						min = dist[seen] + graph[seen][notSeen];
						index = notSeen;
					}
				}
				
				if(min!=INF){
					dist[index] = min;
					//v.add(index);
					//nv.remove(index);
					//seenIterator
				}
			}
		}

	}
*/
}
