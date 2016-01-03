import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TWOSUM {

	/*
	 * The goal of this problem is to implement a variant of the 2-SUM algorithm
	 * (covered in the Week 6 lecture on hash table applications). The file
	 * contains 1 million integers, both positive and negative (there might be
	 * some repetitions!).This is your array of integers, with the ith row of
	 * the file specifying the ith entry of the array.
	 * 
	 * Your task is to compute the number of target values t in the interval
	 * [-10000,10000] (inclusive) such that there are distinct numbers x,y in
	 * the input file that satisfy x+y=t. (NOTE: ensuring distinctness requires
	 * a one-line addition to the algorithm from lecture.)
	 * 
	 * Write your numeric answer (an integer between 0 and 20001) in the space
	 * provided.
	 * 
	 * 
	 * OPTIONAL CHALLENGE: If this problem is too easy for you, try implementing
	 * your own hash table for it. For example, you could compare performance
	 * under the chaining and open addressing approaches to resolving
	 * collisions.
	 */
	

	public static void main(String[] args) throws FileNotFoundException {
		String file = "algo1-programming_prob-2sum.txt";
		System.out.println(twoSumSolution(file));//ans is 427
	}
	
	public static int twoSumSolution(String file) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(file));
		HashMap<Long,Boolean> foundMap=new HashMap<Long, Boolean>(); 
		Set<Long> rangeSet = new HashSet<Long>();
		int totalCount=0;
		long lineCounter=0;
		while (sc.hasNext()) {
			Long val = sc.nextLong();
			foundMap.put(val, true);
			for(Long num=-10000l;num<=10000l;num++){
				if(!rangeSet.contains(num)){
					Long otherVal = num - val;
					if(!otherVal.equals(val) && foundMap.containsKey(otherVal)){
						totalCount++;
						rangeSet.add(num);
					}
				}
			}
			System.out.println("Finished line="+lineCounter);lineCounter++;
		}
		
		return totalCount;
	}
}
