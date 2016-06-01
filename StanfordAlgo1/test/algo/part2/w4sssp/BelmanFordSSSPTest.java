package algo.part2.w4sssp;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algo.part2.w4apsp.FloydWarshall;

public class BelmanFordSSSPTest {

	
	
	private String testFile;
	private long after;
	private long before;

	@Before
	public void before(){
		System.out.println();
		this.before = System.currentTimeMillis();
	}	
	
	@After
	public void after(){
		this.after = System.currentTimeMillis();
		System.out.println("File: " + testFile + "Time Taken in seconds = "+ (this.after - this.before) / 1000D);
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
		BelmanFordSSSP<Integer> bf = new BelmanFordSSSP<Integer>(Integer.class,graph);
		BigDecimal[][] distances =  bf.calculateSSSP(0);
		printDistances(distances);

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
		BelmanFordSSSP<Integer> bf = new BelmanFordSSSP<Integer>(Integer.class,graph);
		BigDecimal[][] distances =  bf.calculateSSSP(0);
		printDistances(distances);

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
	
	private <T> void printDistances(T[][] distances) {
		if(distances == null) return;
		for(int i=0;i<distances[0].length;i++){
			for (int j = 0; j < distances[0].length; j++) {
				if (distances[i][j] == null) {
					System.out.printf("%5s","INF");
				}else{
					System.out.printf("%5s",distances[i][j].toString());
				}
			}
		System.out.println();
		}
		
	}
}
