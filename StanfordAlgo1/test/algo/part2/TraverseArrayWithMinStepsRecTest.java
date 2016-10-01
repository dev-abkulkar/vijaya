package algo.part2;

import org.hamcrest.Matcher;
import org.junit.Test;


//int[] a = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
//int[] a = { 2,3,1,1,4};
//int[] a ={1,1,2,3,1,4};

public class TraverseArrayWithMinStepsRecTest {
	@Test
	public void testA(){
		int []a = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int steps = TraverseArrayWithMinStepsRec.minNumOfSteps(a, 0, a.length-1);
		org.junit.Assert.assertEquals(3, steps);
	}
	
	@Test
	public void testB(){
		int []a = {2,3,1,1,4};
		int steps = TraverseArrayWithMinStepsRec.minNumOfSteps(a, 0, a.length-1);
		org.junit.Assert.assertEquals(2, steps);
	}
	
	@Test
	public void testC(){
		int []a = {1,1,2,3,1,4};
		int steps = TraverseArrayWithMinStepsRec.minNumOfSteps(a, 0, a.length-1);
		org.junit.Assert.assertEquals(4, steps);
	}

}
