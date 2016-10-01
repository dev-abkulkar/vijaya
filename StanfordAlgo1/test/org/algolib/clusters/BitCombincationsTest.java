package org.algolib.clusters;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BitCombincationsTest {

	List<String> bits ;
	@Before
	public void before() {
		bits = new ArrayList<String>();
	}

	@Test
	public void testBitCombinations() {
		int ones = 1;
		int bitLength = 1;
		System.out.println("Ones = " + ones + " bit length=" + bitLength);
		KBigClustering.bitCombinations("", ones, bitLength, bits);
		for (String b : bits) {
			System.out.println(b);
		}
	}
	
	@Test
	public void testBitCombinations2() {
		int ones = 0;
		int bitLength = 1;
		System.out.println("Ones = " + ones + " bit length=" + bitLength);
		KBigClustering.bitCombinations("", ones, bitLength, bits);
		for (String b : bits) {
			System.out.println(b);
		}
	}
	
	
	@Test
	public void testBitCombinations05() {
		int ones = 0;
		int bitLength = 5;
		System.out.println("Ones = " + ones + " bit length=" + bitLength);
		KBigClustering.bitCombinations("", ones, bitLength, bits);
		for (String b : bits) {
			System.out.println(b);
		}
	}
	
	@Test
	public void testBitCombinations25() {
		int ones = 2;
		int bitLength = 5;
		System.out.println("Ones = " + ones + " bit length=" + bitLength);
		KBigClustering.bitCombinations("", ones, bitLength, bits);
		for (String b : bits) {
			System.out.println(b);
		}
	}
	
	@Test
	public void testBitCombinations35() {
		int ones = 3;
		int bitLength = 5;
		System.out.println("Ones = " + ones + " bit length=" + bitLength);
		KBigClustering.bitCombinations("", ones, bitLength, bits);
		for (String b : bits) {
			System.out.println(b);
		}
	}
	
	@Test
	public void testBitCombinations2_24() {
		int ones = 2;
		int bitLength = 24;
		System.out.println("Ones = " + ones + " bit length=" + bitLength);
		KBigClustering.bitCombinations("", ones, bitLength, bits);
		for (String b : bits) {
			System.out.println(b);
		}
	}
	
	@Test
	public void testBitCombinations1_24() {
		int ones = 1;
		int bitLength = 24;
		System.out.println("Ones = " + ones + " bit length=" + bitLength);
		KBigClustering.bitCombinations("", ones, bitLength, bits);
		for (String b : bits) {
			System.out.println(b);
		}
	}

	@After
	public void after() {
		System.out.println("Total combinations = "+ bits.size());
		System.out.println();
	}

}
