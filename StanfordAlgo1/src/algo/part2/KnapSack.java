package algo.part2;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnapSack {
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
		//System.out.println("");
		int[][] A = new int[this.numOfitems+1][this.totalSize+1]; 
		for(int i = 0 ;i<numOfitems+1;i++)
			for(int j=0 ;j<totalSize+1;j++){
				if(i==0 || j==0)
					A[i][j]=0;
				else if(weights[i-1] <=j){
					A[i][j] = Math.max(A[i-1][j], values[i-1]+A[i-1][j-weights[i-1]]);
				}
						
			}
		return A[this.numOfitems][this.totalSize];
	} 
	public static void main(String[] args) {
		String file ="knapsack2.txt";
		KnapSack ks = new KnapSack();
		try{
			ks.load(file);
			System.out.println(ks.calculateMaxProfit());
		}catch(Exception e){
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
}
