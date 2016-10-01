package algo.part2.w4apsp;

import static algo.common.AlgoUtils.INF;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FloydWarshallTest {


	
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

	//@Test
	public void testSimpleGraph() throws FileNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
			/*	      graph[][] = { {0,   5,  INF, 10},
			                  {INF,  0,  3,  INF},
			                  {INF, INF, 0,   1},
			                  {INF, INF, INF, 0} }
			which represents the following graph
			           10
			     (0)------->(3)
			      |         /|\
			    5 |          |
			      |          | 1
			     \|/         |
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
		FloydWarshall floydWarshall = new FloydWarshall(graph,Integer.MAX_VALUE, Integer.class);
		Integer[][] distances = (Integer[][]) floydWarshall.calculateAPSP();
		printDistances(distances);
		
	}

	private void printDistances(Integer[][] distances) {
		if(distances == null) return;
		for(int i=0;i<distances[0].length;i++){
			for (int j = 0; j < distances[0].length; j++) {
				if(distances[i][j].compareTo(Integer.MAX_VALUE)==0){
					System.out.printf("%5s","INF");
				}else{
					System.out.printf("%5d",distances[i][j]);
				}
			}
		System.out.println();
		}
		
	}

	private Integer[][] makeAdjMatrix(String testFile) throws FileNotFoundException {
		File f = new File(testFile);
		Scanner sc = new Scanner(f);
		String[] fline = sc.nextLine().split("[\\s\\t]");
		
		int vertices = Integer.parseInt(fline[0]);
		int edges = Integer.parseInt(fline[1]);
		
		Integer[][] graph = new Integer[vertices][vertices];
		
		for(int i=0;i<vertices;i++){
			Arrays.fill(graph[i], Integer.MAX_VALUE);
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
	
	
	
	//@Test
	public void testNegativeCycleGraph() throws FileNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
			/*	      graph[][] = { {0,   5,  INF, INF},
			                  		{INF,  0,  3,  INF},
					                {INF, INF, 0,   1},
					                {INF, -10, INF, 0} 
					               }
			which represents the following graph
			           -10
			     (1)<-------(4)
			      |         /|\
			    5 |          |
			      |          | 1
			     \|/         |
			     (2)------->(3)
			          3       
			Note that the value of graph[i][j] is 0 if i is equal to j 
			And graph[i][j] is INF (infinite) if there is no edge from vertex i to j.
			
			Output: graph has a negative cycle;
 */
		
		this.testFile = "p2/w4/negative.txt";
		
		Integer[][] graph = makeAdjMatrix(testFile);
		FloydWarshall floydWarshall = new FloydWarshall(graph,Integer.MAX_VALUE, Integer.class);
		Integer[][] distances = (Integer[][]) floydWarshall.calculateAPSP();
		/*for (int i = 0; i < distances[0].length; i++)
			if (distances[i][i] < 0){
				System.out.println("Graph has a negative cycle because distance["+i+"]["+i+"] = "+distances[i][i]);
				break;
			}*/
					
		printDistances(distances);
		
	}
	
	@Test
	public void testG1Graph() throws FileNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
			
		
		this.testFile = "p2/w4/g1.txt";
		
		Long[][] graph = makeAdjMatrixForLong(testFile);
		FloydWarshall floydWarshall = new FloydWarshall(graph,Long.MAX_VALUE, Long.class);
		Long[][] distances = (Long[][]) floydWarshall.calculateAPSP();
		
		/*for (int i = 0; i < distances[0].length; i++)
			if (distances[i][i] < 0){
				System.out.println("Graph has a negative cycle because distance["+i+"]["+i+"] = "+distances[i][i]);
				break;
			}*/
		
	}
	
	@Test
	public void testG2Graph() throws FileNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
			
		
		this.testFile = "p2/w4/g2.txt";
		
		Long[][] graph = makeAdjMatrixForLong(testFile);
		FloydWarshall floydWarshall = new FloydWarshall(graph,Long.MAX_VALUE, Long.class);
		Long[][] distances = (Long[][]) floydWarshall.calculateAPSP();
		
		
		
	}
	
	@Test
	public void testG3Graph() throws FileNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
			
		
		this.testFile = "p2/w4/g3.txt";
		long min = Long.MAX_VALUE;
		Long[][] graph = makeAdjMatrixForLong(testFile);
		FloydWarshall floydWarshall = new FloydWarshall(graph,Long.MAX_VALUE, Long.class);
		Long[][] distances = (Long[][]) floydWarshall.calculateAPSP();
		
		for (int i = 0; i < distances[0].length; i++){
			for (int j = 0; j < distances[0].length; j++) {
				if (i != j && distances[i][j] < min) {
					//System.out.println("Graph has a negative cycle because distance["+i+"]["+i+"] = "+distances[i][i]);
					min = distances[i][j];
				}
			}
		}
		System.out.println(min);
	}

	private Long[][] makeAdjMatrixForLong(String testFile2) throws FileNotFoundException {
		File f = new File(testFile);
		Scanner sc = new Scanner(f);
		String[] fline = sc.nextLine().split("[\\s\\t]");
		
		int vertices = Integer.parseInt(fline[0]);
		int edges = Integer.parseInt(fline[1]);
		
		Long[][] graph = new Long[vertices][vertices];
		
		for(int i=0;i<vertices;i++){
			Arrays.fill(graph[i], Long.MAX_VALUE);
			graph[i][i]=0l;
		}
		for (int line = 0; line < edges; line++) {
			String[] edge = sc.nextLine().split("[\\s\\t]");
			int tail = Integer.parseInt(edge[0])-1;
			int head = Integer.parseInt(edge[1])-1;
			Long length = Long.valueOf(edge[2]);
			graph[tail][head] = length;
		}
		sc.close();
		return graph;
	}
	
}
