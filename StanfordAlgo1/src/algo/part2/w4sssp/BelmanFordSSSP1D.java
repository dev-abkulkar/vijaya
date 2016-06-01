package algo.part2.w4sssp;

import java.math.BigDecimal;

public class BelmanFordSSSP1D<T extends Number> {

	private Integer[] path;
	public BelmanFordSSSP1D(Class clazz, T[][] graph) {
		this.clazz = clazz;
		this.graph = graph;
	}

	Class clazz;
	T[][] graph;
	private int source;
	
	
	
	public BigDecimal[] calculateSSSP(int s){
		System.out.println("Source is "+s);
		this.source = s;
		int nodes = graph[0].length;
		BigDecimal[] L = new BigDecimal[nodes+1];
		path = new Integer[nodes];
		path[s]=s;
		
		//T[][] gcopy = (T[][])Array.newInstance(this.clazz, nodes, nodes);
		 
		//initialize 
		/*for(int n=0;n<nodes;n++){
			if(s==n){
				L[0][n]=BigDecimal.ZERO;
				L[1][n]=BigDecimal.ZERO;
			}
			else{
				L[0][n]=null;
				L[1][n] = graph[s][n]==null?null:new BigDecimal(graph[s][n].toString());
			}
		}*/
		L[s] = BigDecimal.ZERO;
			
		for (int e = 1; e <= (nodes - 1); e++) {
			for (int node = 0; node < nodes; node++) {
					
					BigDecimal oldDistance = L[node];
					// l[i-1][w]+min gcopy[w][v] to v
					
					/* Find all edges incident to v as wv.
					 * and find min of L[i-1][w]+cwv
					 */
					BigDecimal min = null;
				int x = 0;
				int minx=x;
				for (x = 0; x < nodes; x++) {
						T dis = graph[x][node];
					if (dis != null && L[x] != null) {
							BigDecimal disThruNode = L[x].add(new BigDecimal(dis.toString()));
							if (min == null){
								min = disThruNode;
								minx=x;
							}
							if (min != null && min.compareTo(disThruNode) > 0) {
								min = disThruNode;
								minx=x;
							}
						}
					}
					
					if(oldDistance==null || min.compareTo(oldDistance)<0){
						L[node] = min ;
						path[node] = minx;
					}
							
					
				}
			 
		}
		return L;
	}
	
	public Integer[] getPath(){
		return this.path;
	}
	

	public int getSource(){
		return this.source;
	}
}
