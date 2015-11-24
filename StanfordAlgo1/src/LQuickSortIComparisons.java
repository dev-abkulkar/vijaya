import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class LQuickSortIComparisons {
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
		System.out.println(Arrays.asList(integers ));
		System.out.println(comparisons);
	}
	
	private static void quickSort(Integer[] integers, int start, int end) {
		if(start>=end)
			return;
		int ppos = getPivotLastElem(integers,start,end);
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

	private static int getPivotLastElem(Integer[] a, int start, int end) {
		swap(a,start,end);
		return start;
	}

}
