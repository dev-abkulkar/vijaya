package algo.part2;

import static org.junit.Assert.*;

import org.junit.Test;

public class KnapSackTest {

	
	public void smallTest(){
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
	
	
	@Test
	public void testFromCoursera(){
		String file ="knapsack1.txt";
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
