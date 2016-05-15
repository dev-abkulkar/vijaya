package algo.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnapSackBig {
	private int[] values ;
	private int[] weights;
	private int totalSize;
	private int numOfitems;
	//public static final String file = "knapsack1.txt";
	
	
	
	public void load(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(fileName));
		this.totalSize = sc.nextInt();
		this.numOfitems = sc.nextInt();
		this.values = new int[numOfitems];
		this.weights = new int[numOfitems];
		int counter=0;
		while(sc.hasNext()){
			this.values[counter] = sc.nextInt();
			this.weights[counter] = sc.nextInt();
			counter++;
		}
		sc.close();
		
	}
}
