package org.algo.practise;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class MatrixRotateTest {

	
	
	private long after;
	private long before;
	
	int[][] a;

	@Rule 
	public TestName name = new TestName();
	private int n;
	
	@Before
	public void before(){
		System.out.println();
		System.out.println(name.getMethodName());
		
		
		this.before = System.currentTimeMillis();
	}	
	
	@After
	public void after(){
		System.out.println("After rotating:");
		printArray(a, n);

		this.after = System.currentTimeMillis();
		System.out.println("Time Taken in seconds = "+ (this.after - this.before) / 1000D);
	}

	@Test
	public void testArray1x1(){
		
		n=1;
		a= new int[][]{{1}};
		System.out.println("Before rotating:");
		printArray(a, n);
		
		MatrixRotate mr = new MatrixRotate(a, n);
		mr.rotateClockwise();
		
		
	}
	
	@Test
	public void testArray2x2(){
		
		n=2;
		a= new int[][]{{1,2},
						{3,4}};
		System.out.println("Before rotating:");
		printArray(a, n);
		
		MatrixRotate mr = new MatrixRotate(a, n);
		mr.rotateClockwise();
		
		
	}
	
	
	@Test
	public void testArray3x3(){
		
		n=3;
		a= new int[][]{ {1,2,3},
						{4,5,6},
						{7,8,9}
					};
		System.out.println("Before rotating:");
		printArray(a, n);
		
		MatrixRotate mr = new MatrixRotate(a, n);
		mr.rotateClockwise();
		
		
	}
	
	
	
	@Test
	public void testArray4x4(){
		
		n=4;
		a= new int[][]{ {1,2,3,4},
						{5,6,7,8},
						{9,10,11,12},
						{13,14,15,16}	
					};
		System.out.println("Before rotating:");
		printArray(a, n);
		
		MatrixRotate mr = new MatrixRotate(a, n);
		mr.rotateClockwise();
		
		
	}
	
	
	@Test
	public void testArray5x5(){
		
		n=5;
		a= new int[][]{ {1,2,3,4,5},
						{6,7,8,9,10},
						{11,12,13,14,15},
						{16,17,18,19,20},
						{21,22,23,24,25}
					};
		System.out.println("Before rotating:");
		printArray(a, n);
		
		MatrixRotate mr = new MatrixRotate(a, n);
		mr.rotateClockwise();
		
		
	}
	
	@Test
	public void testArray17x17(){
		
		n=17;
		a= new int[17][17];
		int v = 1;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j]=v++;
			
		System.out.println("Before rotating:");
		printArray(a, n);
		
		MatrixRotate mr = new MatrixRotate(a, n);
		mr.rotateClockwise();
		mr.rotateClockwise();
		
		
	}
	
	public static void printArray(int[][] x, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(x[i]));
		}
	}
	
}
