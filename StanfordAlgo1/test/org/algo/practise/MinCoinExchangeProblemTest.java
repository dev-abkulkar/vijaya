package org.algo.practise;

import org.algo.practise.MinCoinExchangeProblem.CoinExchangeResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class MinCoinExchangeProblemTest {
	
	
	private long after;
	private long before;

	@Rule 
	public TestName name = new TestName();
	
	@Before
	public void before(){
		System.out.println();
		System.out.println(name.getMethodName());
		this.before = System.currentTimeMillis();
	}	
	
	@After
	public void after(){
		this.after = System.currentTimeMillis();
		System.out.println("Time Taken in seconds = "+ (this.after - this.before) / 1000D);
	}
	
	@Test
	public void testWithNoCoins(){
		int[] coins = null;
		int amt= 1;
		CoinExchangeResult calculateMinCoinsNeeded = MinCoinExchangeProblem.calculateMinCoinsNeeded(amt, coins);
		System.out.println(calculateMinCoinsNeeded);
	}
	
	@Test
	public void testWith4CoinsFor11(){
		int[] coins = {10,5,1,2};
		int amt= 11;
		CoinExchangeResult calculateMinCoinsNeeded = MinCoinExchangeProblem.calculateMinCoinsNeeded(amt, coins);
		System.out.println(calculateMinCoinsNeeded);
	}
	
	@Test
	public void testWith4CoinsFor100(){
		int[] coins = {10,5,1,2};
		int amt= 100;
		CoinExchangeResult calculateMinCoinsNeeded = MinCoinExchangeProblem.calculateMinCoinsNeeded(amt, coins);
		System.out.println(calculateMinCoinsNeeded);
	}
	
	@Test
	public void testWith4CoinsFor3(){
		int[] coins = {10,5,1,2};
		int amt= 3;
		CoinExchangeResult calculateMinCoinsNeeded = MinCoinExchangeProblem.calculateMinCoinsNeeded(amt, coins);
		System.out.println(calculateMinCoinsNeeded);
	}
	
	@Test
	public void testWith3CoinsFor3(){
		int[] coins = {10,5,2};
		int amt= 3;
		CoinExchangeResult calculateMinCoinsNeeded = MinCoinExchangeProblem.calculateMinCoinsNeeded(amt, coins);
		System.out.println(calculateMinCoinsNeeded);
	}
}
