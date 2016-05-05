package algo.part2;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KnapSackRecursiveTest {

	private String file;
	private int answer;
	private long after;
	private long before;

	@Before
	public void before(){
		this.before = System.currentTimeMillis();
	}
	
	@After
	public void after(){
		this.after = System.currentTimeMillis();
		System.out.println("Answer for "+file+" = "+this.answer);
		System.out.println("Time Taken in seconds = "+(this.after-this.before)/1000D);
	}
	
	//@Test
	public void gfgTest(){
		this.file ="p2/ks_gfg.txt";
		KnapSackRecursive ks = new KnapSackRecursive();
		try{
			ks.load(file);
			this.answer = ks.maxProfitThruCache();
		}catch(Exception e){
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
	
	//@Test
	public void testFromCourseraAssn1(){
		this.file ="p2/knapsack_assn1.txt";
		KnapSackRecursive ks = new KnapSackRecursive();
		try{
			ks.load(file);
			this.answer = ks.maxProfitThruCache();
		}catch(Exception e){
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void testFromStackoverflow(){
		//http://stackoverflow.com/questions/17246670/0-1-knapsack-dynamic-programming-optimazion-from-2d-matrix-to-1d-matrix#
		this.file = "p2/ks_stackoverflow.txt";
		KnapSackRecursive ks = new KnapSackRecursive();
		try{
			ks.load(file);
			this.answer = ks.calculateMaxProfit();
		}catch(Exception e){
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
	
	
	
	
	
}
