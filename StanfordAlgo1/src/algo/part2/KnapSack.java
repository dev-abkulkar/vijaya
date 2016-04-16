package algo.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnapSack {
	private int[] values ;
	private int[] weights;
	private int totalSize;
	private int numOfitems;
	public static final String file = "knapsack1.txt";
	
	
	
	public void load(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(file));
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
	
	public int calculateMaxProfit(){
		int[][] ksDynamic = new int[this.totalSize+1][this.numOfitems+1]; 
		for(int i=0;i<this.totalSize+1;i++)
			ksDynamic[i][0] = 0;
		for(int j=0;j<this.numOfitems+1;j++){
			ksDynamic[0][j] = 0;
		}
		for(int item=1;item<this.numOfitems+1;item++){
			for(int weight=1;weight<this.totalSize+1;weight++){
				
			}
		}
		return ksDynamic[this.totalSize][this.numOfitems];
	} 
}
