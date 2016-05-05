package algo.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class KnapSackRecursive {
	private int totalSize;
	private int numOfitems;
	private int[] values;
	private int[] weights;
	private HashMap<ValueCache,Integer> valueCache = new HashMap<ValueCache,Integer>();	
	

	public void load(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(fileName));
		this.totalSize = sc.nextInt();
		this.numOfitems = sc.nextInt();
		this.values = new int[numOfitems];
		this.weights = new int[numOfitems];
		int counter = 0;
		while (sc.hasNext()) {
			this.values[counter] = sc.nextInt();
			this.weights[counter] = sc.nextInt();
			counter++;
		}
		sc.close();
	}

	public int calculateMaxProfit() {
		return this.ksRecursive(this.totalSize, this.numOfitems);
	}
	
	public int maxProfitThruCache(){
		return this.ksRecursiveCached(this.totalSize, this.numOfitems);
	}

	private int ksRecursive(int size, int n) {
		if (size == 0 || n == 0)
			return 0;
		int wn = this.weights[n - 1];
		int vn = this.values[n - 1];
		if (wn <= size) {
			return Math.max(this.ksRecursive(size, n - 1),vn + this.ksRecursive(size - wn, n - 1));
		} else {
			return this.ksRecursive(size, n - 1);
		}
	}
	
	private int ksRecursiveCached(int size, int n) {
		if (size == 0 || n == 0)
			return 0;
		
		int existingVal = getvalueFromCache(n, size);
		
		if(existingVal!=-1){
			System.out.println("Got value ="+existingVal+"for items="+n+"size = "+size+" from cache!");
			return existingVal;
		}
		
		int wn = this.weights[n - 1];
		int vn = this.values[n - 1];
		if (wn <= size) {
			int valWithout = this.ksRecursive(size, n - 1);
			int valWith = vn + this.ksRecursive(size - wn, n - 1);
			
			int maxVal = Math.max(valWith,valWithout);
			ValueCache vc = new ValueCache();
			vc.items=n;
			vc.weight=size;
			this.valueCache.put(vc, maxVal);
			return maxVal;
			
		} else {

			int maxVal = this.ksRecursive(size, n - 1);
			ValueCache vc = new ValueCache();
			vc.items=n;
			vc.weight=size;
			this.valueCache.put(vc, maxVal);
			return maxVal;
		}
	}
	

	private static class ValueCache{
		int weight;
		int items;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + items;
			result = prime * result + weight;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ValueCache other = (ValueCache) obj;
			if (items != other.items)
				return false;
			if (weight != other.weight)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "ValueCache [weight=" + weight + ", items=" + items + "]";
		}
		
	}
	
	int getvalueFromCache(int N, int W) {
		
		ValueCache vc = new ValueCache();
		vc.items = N;
		vc.weight = W;
		if (this.valueCache.containsKey(vc)) {
			return this.valueCache.get(vc);
		} else
			return -1;
	}
	
}
