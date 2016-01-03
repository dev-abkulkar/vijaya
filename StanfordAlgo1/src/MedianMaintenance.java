import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.algolib.ds.HeapOrder;
import org.algolib.ds.impl.IntHeap;


public class MedianMaintenance {

	public static void main(String[] args) throws FileNotFoundException {
		String file = "MedianMaintenance.txt";
		//file ="Med2.txt";
		System.out.println(findMedianModTenK(file));
		
	}
	private static int findMedianModTenK(String file) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(file));
		long sumOfMedians=0;
		int counter=0;
		IntHeap leftHeap = new IntHeap(HeapOrder.DESC);
		IntHeap rightHeap = new IntHeap(HeapOrder.ASC);
		List<Integer> medians = new ArrayList<Integer>();
		int a = sc.nextInt();
		sumOfMedians+=a;
		medians.add(a);
		
		int b = sc.nextInt();
		if (a < b) {
			leftHeap.insert(a);
			rightHeap.insert(b);
			sumOfMedians+=a;
			medians.add(a);
		}else{
			leftHeap.insert(b);
			rightHeap.insert(a);
			sumOfMedians+=b;
			medians.add(b);
		}
		counter = 2;
		while(sc.hasNext()){
			int k = sc.nextInt();
			counter++;
			/*if(leftHeap.getSize()==0){
				leftHeap.insert(k);
			}else if(rightHeap.getSize()==0){
				if (leftHeap.peek() > k) {
					rightHeap.insert(leftHeap.extractTopPriority());
					leftHeap.insert(k);
				}else
					rightHeap.insert(k);
			}else{*/
			int maxLeft = leftHeap.peek();
			
			if(k < maxLeft){
				leftHeap.insert(k);
			}else{
				rightHeap.insert(k);
			}
			if ((leftHeap.getSize() - rightHeap.getSize()) > 1) {
				rightHeap.insert(leftHeap.extractTopPriority());
			} else if (leftHeap.getSize() - rightHeap.getSize() < -1) {
				leftHeap.insert(rightHeap.extractTopPriority());
			}
			
		
			int currentMedian=0;
			if(leftHeap.getSize() == rightHeap.getSize() ){
				currentMedian=leftHeap.peek();
			}else if(leftHeap.getSize() > rightHeap.getSize()){
				currentMedian=leftHeap.peek();
			}else{
				currentMedian=rightHeap.peek();
			}
			//System.out.println("LeftHeap= "+leftHeap.getHeapAsString());
			//System.out.println("RightHeap= "+rightHeap.getHeapAsString());
			System.out.println("Current median="+currentMedian);
			sumOfMedians+=currentMedian;
			medians.add(currentMedian);
			//System.out.println("-----Finished Counter---> "+counter);
			System.out.println();
		}
		sc.close();
		System.out.println("sum of medians="+sumOfMedians);
		System.out.println("medians="+medians);
		return (int) (sumOfMedians%10000);
	}
	
}
