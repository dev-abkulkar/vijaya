package org.algo.practise;

import java.util.ArrayList;
import java.util.List;

public class ErasothenesSieve {
	public static void main(String[] args) throws Exception {
		List<Integer> primes = getAllPrimes2(100);
		int[] arr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		int i=0;
		for (Integer integer : primes) {
			System.out.print(integer+", ");
			if (arr[i] != integer)
				throw new Exception("Wrong prime detected");
			i++;
		}
	}

	List<Integer> getAllPrimes(int a,int b){
		return null;
	}
		
	static List<Integer> getAllPrimes(int n){
		List<Integer> allNos = new ArrayList<Integer>();
		List<Integer> primes = new ArrayList<Integer>();
		
		for(int i=0;i<=n;i++){
			allNos.add(i);
		}
		
		int j=2;
		
		while(j<n){
			for (int x = 2 * j; x <= n; x = x + j) {
				allNos.set(x, -1);
			}
			
			j++;
			
			
			while (j < n && allNos.get(j) == -1) {
				j++;
			}
		}
		
		for(int z=2;z<=n;z++){
			if(allNos.get(z)!=-1){
				primes.add(z);
			}
		}
		
		return primes;
	}
	
	static List<Integer> getAllPrimes2(int n){
		List<Integer> allNos = new ArrayList<Integer>();
		List<Integer> primes = new ArrayList<Integer>();
		
		for(int i=2;i<=n;i++){
			allNos.add(i);
		}
		
		int j=2;
		
		while(j<n){
			for (int x = 2 * j; x <= n; x = x + j) {
				allNos.set(x-2, -1);
			}
			
			j++;
			
			
			while (j < n && allNos.get(j-2) == -1) {
				j++;
			}
		}
		
		for(int z=2;z<=n;z++){
			if(allNos.get(z-2)!=-1){
				primes.add(z);
			}
		}
		
		return primes;
	}

	
	
}
