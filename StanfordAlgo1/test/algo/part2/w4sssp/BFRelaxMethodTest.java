package algo.part2.w4sssp;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BFRelaxMethodTest {

	private String testFile;
	private long after;
	private long before;
	BFRelaxMethod<Integer> bf;

	@Before
	public void before(){
		System.out.println();
		this.before = System.currentTimeMillis();
	}	
	
	@After
	public void after(){
		this.after = System.currentTimeMillis();
		System.out.println("File: " + testFile + ". Time Taken in seconds = "+ (this.after - this.before) / 1000D);
		
	}

	
	@Test
	public void simpleTest() throws FileNotFoundException{
		/*	      graph[][] = { {0,   5,  INF, 10},
        {INF,  0,  3,  INF},
        {INF, INF, 0,   1},
        {INF, INF, INF, 0} }
		which represents the following graph
		     10
		(0)------->(3)
		 |          /|\
		5|           |
		 |           | 1
		\|/    		 |
		(1)------->(2)
			3       
		Note that the value of graph[i][j] is 0 if i is equal to j 
		And graph[i][j] is INF (infinite) if there is no edge from vertex i to j.
		
		Output:
		Shortest distance matrix
		0      5      8      9
		INF      0      3      4
		INF    INF      0      1
		INF    INF    INF      0 */
		
		this.testFile = "p2/w4/simpleg.txt";
		
		Graph g = makeGraph(testFile);
		bf = new BFRelaxMethod<Integer>(Integer.class,g.getEdges(),g.getNodes());
		BigDecimal[] distances =  bf.calcSSSP(0);
		System.out.println(Arrays.toString(distances));
		
		printPaths(bf);

	}
	
	@Test
	public void testOnNegativeCycle() throws FileNotFoundException{
	/*	     -12
		(0)<-------(3)
		 |          /|\
		5|           |
		 |           | 1
		\|/    		 |
		(1)------->(2)
			3       */
		this.testFile = "p2/w4/neg.txt";
		Graph g = makeGraph(testFile);
		bf = new BFRelaxMethod<Integer>(Integer.class,g.getEdges(),g.getNodes());
		BigDecimal[] distances =  bf.calcSSSP(0);
		if(distances==null){
			System.out.println("Graph of "+this.testFile+" has negative cycle!");
		}else{
			System.out.println(Arrays.toString(distances));
		}
	}
	
	
	@Test
	public void testOnDjikstrasAssignment() throws FileNotFoundException{
		this.testFile = "dijkstraData.txt";
		Scanner sc = new Scanner(new File("dijkstraData.txt"));
		//num of lines = num of nodes
		int nodeCounter = 0;
		List<Edge> edges = new ArrayList<Edge>();
		while(sc.hasNext()){
			nodeCounter++;
			String line = sc.nextLine();
			String[] l = line.split("[\\s\\t]");
			String from = l[0];
			for(int i=1;i<l.length;i++){
				String[] tuple = l[i].split(",");
				int u = Integer.parseInt(from)-1;
				int v = Integer.parseInt(tuple[0])-1;
				BigDecimal weight = new BigDecimal(tuple[1]);
				edges.add(new Edge(u,v,weight));
			}
		}	
		int source = 0;
		bf = new BFRelaxMethod<Integer>(Integer.class, edges, nodeCounter);
		BigDecimal[] distances =  bf.calcSSSP(source);
		int[] dests  = {7,37,59,82,99,115,133,165,188,197};
		int[] answers = {2599,2610,2947,2052,2367,2399,2029,2442,2505,3068};
		for (int i = 0; i < dests.length; i++) {
			System.out.printf("%-5s (%-5s) %s",distances[dests[i]-1].toString(),getPath(bf,dests[i]-1),"\n");
			Assert.assertEquals(answers[i], distances[dests[i]-1].intValue());
		}
		System.out.println();
		sc.close();

	}

	private String getPath(BFRelaxMethod<Integer> bf2, int target) {
		Integer[] path = bf.getPath();
		
		if (path == null)
			return null;

		return recPrint(bf.getSource(),target,path);
		
		
		
	}

	private Graph makeGraph(String testFile2) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(testFile2));
		int nodes = sc.nextInt();
		int edges = sc.nextInt();
		List<Edge> edgeList = new ArrayList<Edge>(); 
		for (int i = 0; i < edges; i++) {
			int from = sc.nextInt()-1;
			int to = sc.nextInt()-1;
			BigDecimal wt = sc.nextBigDecimal();
			edgeList.add(new Edge(from,to,wt));
		}
		
		Graph g = new Graph(edgeList, nodes);
		
		sc.close();
		return g;
	}
	
	private void printPaths(BFRelaxMethod bf) {
		Integer[] path = bf.getPath();
		if (path == null)
			return;
		
		for (int i = 0; i < path.length; i++) {
			String p = recPrint(bf.getSource(),i,path);
			System.out.println("Path to "+i+" : "+p.toString());
		}
		
	}

	private String recPrint(Integer source,Integer target, Integer[] path) {
		if(target == null)
			return "-";
		if(source.equals(target))
			return ""+source; 
		if(path!=null){
			Integer pred = path[target];
			if (pred != null) {
				return target +"<--" + recPrint(source, pred, path);
			}
		}
		return null;
	}
}
