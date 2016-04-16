package algo.part2;

import static org.junit.Assert.*;

import org.junit.Test;

public class KnapSackTest {

	@Test
	public void testFromCoursera(){
		String file ="knapsack1.txt";
		KnapSack ks = new KnapSack();
		try{
			ks.load(file);
			
		}catch(Exception e){
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
}
