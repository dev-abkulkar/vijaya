package algo.part2.w4sssp;

import java.math.BigDecimal;
import java.util.List;

public class BFRelaxMethod<T extends Number>  {

	
	protected Class clazz;
	protected List<Edge> edges;
	protected int nodes;
	protected int source;
	protected Integer[] path;
	
	public BFRelaxMethod(Class clazz, List<Edge> edges,int nodes) {
		this.clazz = clazz;
		this.edges = edges;
		this.nodes = nodes;
		
	}
	
	public BigDecimal[] calcSSSP(int source){
		BigDecimal[] d = new BigDecimal[nodes];
		path = new Integer[nodes];
		
		d[source] = BigDecimal.ZERO;
		this.source = source;
		for (int i = 1; i <= nodes - 1; i++)
			for(Edge e: edges ){
				relax(e,d);
			}
		for(Edge e: edges ){
			boolean hasNegativeCycle = relaxForNegativeEdge(e,d);
			if(hasNegativeCycle)
				return null;
		}
		return d;
	}

	private boolean relaxForNegativeEdge(Edge e, BigDecimal[] d) {
		int u = e.from;
		int v = e.to;
		if (d[u] != null) {
			
			BigDecimal new_dv = d[u].add(e.weight);
			
			if (new_dv.compareTo(d[v]) < 0){
				return true;
			}
		}
		return false;
	}

	protected void relax(Edge e,BigDecimal[] d) {
		int u = e.from;
		int v = e.to;
		if (d[u] != null) {
			
			BigDecimal new_dv = d[u].add(e.weight);
			
			if (d[v] == null || new_dv.compareTo(d[v]) < 0){
				d[v] = new_dv;
				path[v] = u;
			}
		}
	}
	
	public Integer[] getPath(){
		return this.path;
	}
	
	public int getSource(){
		return this.source;
	}
	
	
}
