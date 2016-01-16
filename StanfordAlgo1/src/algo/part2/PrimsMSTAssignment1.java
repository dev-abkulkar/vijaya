package algo.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import org.algolib.traversals.PrimsMST;

public class PrimsMSTAssignment1 {

	public static long INF = Long.MAX_VALUE;
			
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("p2/primedges.txt"));
		int n = sc.nextInt();
		int m = sc.nextInt();
		long g[][] = new long[n][n];
		
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(g[i], INF);
			g[i][i]=0;
		}
		
		while(sc.hasNext()){
			int u = sc.nextInt();
			int v = sc.nextInt();
			g[v-1][u-1]=g[u-1][v-1] = sc.nextInt();
			
		}
		
		int parent[] = PrimsMST.prims(g,0);
		System.out.println("TOTAL COST = "+PrimsMST.totalMSTCost(g, parent, true));
		sc.close();
	}

}
