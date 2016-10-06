package org.algolib.utils;

import org.junit.Test;

public class CountBitsTest {

	
	@Test
	public void testCountBits(){
		int x = 10;
		int numOfBits = CountBits.countBits(x);
		System.out.println("NumOf bits = "+numOfBits);
	}
	@Test
	public void testCountBits2(){
		int x = 0xffff;
		int numOfBits = CountBits.countBits(x);
		System.out.println("NumOf bits = "+numOfBits);
	}
	@Test
	public void testCountBits3(){
		int x = 0x1010101;
		int numOfBits = CountBits.countBits(x);
		System.out.println("NumOf bits = "+numOfBits);
	}
	
	@Test
	public void testCountBits4(){
		int x = 0xfff;
		int numOfBits = CountBits.countBits(x);
		System.out.println("NumOf bits = "+numOfBits);
	}
}
