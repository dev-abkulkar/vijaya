package org.algo.practise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class SumOfPrimeFactorsInRangeTest {

	
	@Test
	public void testFromhackerEarth() throws IOException{
		String file = "practise/SumOfPrimeFactorsInRange.txt";
		
        /*
         * Read input from stdin and provide input before running
		*/
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            //System.out.println("hello world");
            String[] numbersLine = br.readLine().split(" ");
            int a = Integer.parseInt(numbersLine[0]);
            int b = Integer.parseInt(numbersLine[1]);
        	int sum = SumOfPrimeFactorsInRange.sumOfPrimeFactorsInRange(a,b);
        	System.out.println(sum);
        }
	}
}
