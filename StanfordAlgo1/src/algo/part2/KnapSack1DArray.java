package algo.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnapSack1DArray {
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
	
	
	public int calculateMaxProfit(){
		int[] a = new int[this.totalSize+1];
		for(int i=0;i<this.numOfitems;i++){
			for(int j=this.totalSize;j>=0;j--){
				int vn = values[i];
				int wn = weights[i];
				a[j]= j<wn?a[j] : Math.max(a[j], vn + a[j-wn]);
			}
		}
		return a[this.totalSize];
	}
	//2489489
}
