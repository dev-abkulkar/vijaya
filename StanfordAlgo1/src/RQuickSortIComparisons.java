import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class RQuickSortIComparisons {
	static int comparisons = 0;
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("QuickSort.txt");
		//BufferedReader reader = new BufferedReader(new FileReader(f));
		Scanner scanner = new Scanner(f);
		List<Integer> integerList = new ArrayList<Integer>();
		while(scanner.hasNext()){
			integerList.add(scanner.nextInt());
		}
		
		Integer[] integers = integerList.toArray(new Integer[0]);
		System.out.println("Before sort:"+Arrays.asList(integers ));
		quickSort(integers,0,integers.length-1);
		System.out.println("After Sort:"+Arrays.asList(integers ));
		for(int i=0;i<integers.length-1;i++){
			if(integers[i]>integers[i+1])
				System.out.println("Not sorted!!");
		}
		
		System.out.println("Total num of comparisons="+comparisons);
	}
	
	private static void quickSort(Integer[] integers, int start, int end) {
		if(start>=end)
			return;
		int ppos = getPivotMedian(integers,start,end);
		int mid = partition(integers,ppos,start,end);
		comparisons+=mid-start;
		comparisons+=end-mid;
		quickSort(integers,start,mid-1);
		quickSort(integers,mid+1,end);
	}
	
	private static int partition(Integer[] a, int ppos, int start,
			int end) {
		int i=start+1;
		int j=start+1;
		
		while(j<=end){
			if (a[j] < a[ppos]) {
				swap(a,j,i);
				i++;
			}
			j++;
		}
		swap(a,i-1,ppos);
		return i-1;
	}

	private static void swap(Integer[] a, int j, int i) {
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}

	private static int getPivotMedian(Integer[] a, int start, int end) {
		//System.out.println("--------------->getPivotMedian");
		//System.out.println("Current array status:"+Arrays.asList(a));
		int first = a[start];
		int last = a[end];
		int middle=0;
		if((end-start+1)%2==0){
			middle = start+((end-start+1)/2)-1;
		}else{
			middle = start+(end-start+1)/2;
		}
		//System.out.println("start="+start+" "+"end="+end);
		//System.out.println("Middle index is "+middle);
		int mid = a[middle];
		//System.out.println("The three elements : "+first+", "+mid+", "+last);
		
		if((first<mid && mid<last) || (last<mid && mid<first)){
			//System.out.println("Middle element is "+mid);
			swap(a,start,middle);	
		}else if((mid<first && first<last) || (last<first && first<mid)){
			//System.out.println("Middle element is "+first);
		}else if((first<last && last<mid) || (mid<last && last<first) ) {
			swap(a,start,end);
			//System.out.println("Middle element is "+last);
		}
		//System.out.println("<---------------getPivotMedian");
		return start;
	}

}
