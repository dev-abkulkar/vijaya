package algo.part2.w4sssp;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BelmanFordSSSP1DTest {

	
	
	private String testFile;
	private long after;
	private long before;
	BelmanFordSSSP1D<Integer> bf;

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
		 |\         /|\
		5| \         |
		 |  \ 15     | 1
		\|/  -----\  |
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
		
		Integer[][] graph = makeAdjMatrix(testFile);
		bf = new BelmanFordSSSP1D<Integer>(Integer.class,graph);
		BigDecimal[] distances =  bf.calculateSSSP(0);
		System.out.println(Arrays.toString(distances));
		
		printPaths(bf);

	}
	
	
	private void printPaths(BelmanFordSSSP1D<Integer> bf) {
		Integer[] path = bf.getPath();
		if(path==null) return ;
		
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

	@Test
	public void simpleTest2() throws FileNotFoundException{
		/*	      graph[][] = { {0,   5,  15, 10},
        {INF,  0,  -30,  INF},
        {INF, INF, 0,   1},
        {INF, INF, INF, 0} }
		which represents the following graph
		     10
		(0)------->(3)
		 |\         /|\
		5| \         |
		 |  \ 15     | 1
		\|/  -----\  |
		(1)------->(2)
			-30       
		Note that the value of graph[i][j] is 0 if i is equal to j 
		And graph[i][j] is INF (infinite) if there is no edge from vertex i to j.
		
		Output:
		Shortest distance matrix
		0      5      8      9
		INF      0      3      4
		INF    INF      0      1
		INF    INF    INF      0 */
		
		this.testFile = "p2/w4/sg1.txt";
		
		Integer[][] graph = makeAdjMatrix(testFile);
		bf = new BelmanFordSSSP1D<Integer>(Integer.class,graph);
		BigDecimal[] distances =  bf.calculateSSSP(0);
		System.out.println(Arrays.toString(distances));

	}
	
	@Test
	public void simpleTest2OnVertex1() throws FileNotFoundException{
		this.testFile = "p2/w4/sg5.txt";
		
		Integer[][] graph = makeAdjMatrix(testFile);
		bf = new BelmanFordSSSP1D<Integer>(Integer.class,graph);
		BigDecimal[] distances =  bf.calculateSSSP(1);
		System.out.println(Arrays.toString(distances));

	}
	
	@Test
	public void simpleTest2OnVertex0() throws FileNotFoundException{
		this.testFile = "p2/w4/sg5.txt";
		
		Integer[][] graph = makeAdjMatrix(testFile);
		bf = new BelmanFordSSSP1D<Integer>(Integer.class,graph);
		BigDecimal[] distances =  bf.calculateSSSP(0);
		System.out.println(Arrays.toString(distances));
		printPaths(bf);

	}
	
	@Test
	public void testOnDjikstrasAssignment() throws FileNotFoundException{
		this.testFile = "dijkstraData.txt";
		Scanner sc = new Scanner(new File("dijkstraData.txt"));
		Integer xgraph[][] = new Integer[200][200];
		
		int size=xgraph[0].length;
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++){
				if(i==j){
					xgraph[i][j]=0;
				}
				else{
					xgraph[i][j]=null;
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
		int source = 0;
		bf = new BelmanFordSSSP1D<Integer>(Integer.class,xgraph);
		BigDecimal[] distances =  bf.calculateSSSP(source);
		int[] dests  = {7,37,59,82,99,115,133,165,188,197};
		int[] answers = {2599,2610,2947,2052,2367,2399,2029,2442,2505,3068};
		for (int i = 0; i < dests.length; i++) {
			System.out.printf("%8s",distances[dests[i]-1].toString());
		}
		System.out.println();
		sc.close();

	}
	
	
	private Integer[][] makeAdjMatrix(String testFile) throws FileNotFoundException {
		File f = new File(testFile);
		Scanner sc = new Scanner(f);
		String[] fline = sc.nextLine().split("[\\s\\t]");
		
		int vertices = Integer.parseInt(fline[0]);
		int edges = Integer.parseInt(fline[1]);
		
		Integer[][] graph = new Integer[vertices][vertices];
		
		for(int i=0;i<vertices;i++){
			graph[i][i]=0;
		}
		for (int line = 0; line < edges; line++) {
			String[] edge = sc.nextLine().split("[\\s\\t]");
			int tail = Integer.parseInt(edge[0])-1;
			int head = Integer.parseInt(edge[1])-1;
			int length = Integer.parseInt(edge[2]);
			graph[tail][head] = length;
		}
		sc.close();
		return graph;
	}
	
	
	
	
}
