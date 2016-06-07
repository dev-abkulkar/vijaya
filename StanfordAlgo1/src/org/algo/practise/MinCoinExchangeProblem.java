package org.algo.practise;

import java.util.Arrays;
import java.util.Map;

public class MinCoinExchangeProblem {

	
	public static CoinExchangeResult calculateMinCoinsNeeded(int targetAmount, int[] coinValues){
		if(targetAmount<=0 || coinValues==null || coinValues.length==0){
			return null;
		}
		
		int[] coinsForVal = new int[targetAmount+1];
		coinsForVal[0]=0;
		
		int[] denomCount = new int[coinValues.length];
		
		
		for(int i=1;i<=targetAmount;i++){
			coinsForVal[i]=Integer.MAX_VALUE;
		}
		
		
		
		for (int c = 0; c < coinValues.length; c++) {
			for (int targetVal = 1; targetVal <= targetAmount; targetVal++) {
				if(targetVal >= coinValues[c]){
					int rem = targetVal-coinValues[c];
					if(coinsForVal[rem]!=Integer.MAX_VALUE){
						if(1+coinsForVal[rem]< coinsForVal[targetVal]){
							coinsForVal[targetVal] = 1+coinsForVal[rem];
							denomCount[c]++;
						}
					}
				}
			}
		}
		CoinExchangeResult cer = new CoinExchangeResult(coinsForVal[targetAmount], null);
		System.out.println(Arrays.toString(denomCount));
		return cer;
	}
	
	
	
	
	public static class CoinExchangeResult{
		private int numOfCoins;
		private Map<Integer,Integer> denomToCount;
		
		public CoinExchangeResult(int numOfCoins, Map<Integer, Integer> denomCount) {
			this.denomToCount=denomCount;
			this.numOfCoins=numOfCoins;
		}
		
		public int getNumOfCoins(){
			return this.numOfCoins;
		}
		
		public Map<Integer,Integer> getDenomToCount(){
			return this.denomToCount;
		}

		@Override
		public String toString() {
			return "CoinExchangeResult [numOfCoins=" + numOfCoins
					+ ", denomToCount=" + denomToCount + "]";
		}
		
		
	}
}
