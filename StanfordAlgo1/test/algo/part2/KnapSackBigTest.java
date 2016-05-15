package algo.part2;

import static org.junit.Assert.fail;

import org.junit.Test;

public class KnapSackBigTest {

	
	@Test
	public void testFromCoursera(){
		String file ="p2/knapsack_big.txt";
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
