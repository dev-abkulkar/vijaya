package algo.part2.w4sssp;

import java.math.BigDecimal;

public class BelmanFordSSSP<T extends Number> {

	public BelmanFordSSSP(Class clazz, T[][] graph) {
		this.clazz = clazz;
		this.graph = graph;
	}
	
	protected Class clazz;
	protected T[][] graph;
	
	protected Integer[] path;
	protected int source;
	
	
	public BigDecimal[][] calculateSSSP(int s){
		int nodes = graph[0].length;
		BigDecimal[][] L = new BigDecimal[nodes+1][nodes];
		//T[][] gcopy = (T[][])Array.newInstance(this.clazz, nodes, nodes);
		 
		//initialize 
		for(int n=0;n<nodes;n++){
			if(s==n){
				L[0][n]=BigDecimal.ZERO;
				L[1][n]=BigDecimal.ZERO;
			}
			else{
				L[0][n]=null;
				L[1][n] = graph[s][n]==null?null:new BigDecimal(graph[s][n].toString());
			}
		}
		
			
		for (int e = 2; e <= (nodes - 1); e++) {
			for (int node = 0; node < nodes; node++) {
				if(node==s){
					L[e][node]=BigDecimal.ZERO;
				}else{
					BigDecimal oldDistance = L[e-1][node];
					// l[i-1][w]+min gcopy[w][v] to v
					
					/* Find all edges incident to v as wv.
					 * and find min of L[i-1][w]+cwv
					 */
					BigDecimal curmin = null;
					for(int x=0;x<nodes;x++){
						T dis = graph[x][node];
						if(dis!=null && L[e-1][x]!=null){
							BigDecimal disThruNode = L[e-1][x].add(new BigDecimal(dis.toString()));
							if (curmin == null)
								curmin = disThruNode;
							if (curmin != null && curmin.compareTo(disThruNode) > 0) {
								curmin = disThruNode;
							}
						}
					}
					
					L[e][node] = (oldDistance==null || curmin.compareTo(oldDistance)<0)?curmin:L[e-1][node];
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
