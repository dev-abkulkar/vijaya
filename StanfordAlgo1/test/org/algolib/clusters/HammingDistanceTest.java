package org.algolib.clusters;

import org.junit.Test;

public class HammingDistanceTest {

	@Test
	public void hdTest(){
		System.out.println(KBigClustering.hd(5, 4));
	}
	
	@Test
	public void hdTest2(){
		//110
		//100
		System.out.println(KBigClustering.hd(6, 4));
	}
	
	@Test
	public void hdTest3(){
		//110
		//101
		System.out.println(KBigClustering.hd(6, 5));
	}
	
}
