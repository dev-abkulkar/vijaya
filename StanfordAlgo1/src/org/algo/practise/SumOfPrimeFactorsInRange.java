package org.algo.practise;

import java.lang.Math;
/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;
public class SumOfPrimeFactorsInRange {


	    public static void main(String args[] ) throws Exception {
	        /*
	         * Read input from stdin and provide input before running
			*/
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        for (int i = 0; i < N; i++) {
	            //System.out.println("hello world");
	            String[] numbersLine = br.readLine().split(" ");
	            int a = Integer.parseInt(numbersLine[0]);
	            int b = Integer.parseInt(numbersLine[1]);
	        	int sum = sumOfPrimeFactorsInRange(a,b);
	        	System.out.println(sum);
	        }
	        

	       // System.out.println("Hello World!");
	    }
	    
	    public static int sumOfPrimeFactorsInRange(int a, int b){
	    	int total =0;
	    	for(int i =a ; i<=b;i++){
	    		total+=sumOfPrimeFactorPowers(i);
	    	}
	    	return total;
	    }
	    
	    private static int sumOfPrimeFactorPowers(int n){
	    	int count = 0;
	    	while((n&1)==0){
	    		n = n>>1;
	    		count++;
	    	}
	    	
	    	for(int k=3;k<=Math.sqrt(n);k=k+2 ){
	    		while(n%k==0){
	    			count++;
	    			n=n/k;
	    		}
	    	}
	    	if(n>2)
	    		count++;
	    	
	    	return count;
	    }
	}

