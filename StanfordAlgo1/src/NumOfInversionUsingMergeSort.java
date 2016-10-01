import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumOfInversionUsingMergeSort {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("IntegerArray.txt"));
		List<Integer> integerList = new ArrayList<Integer>();
		String x;
		while ((x = reader.readLine()) != null) {
			integerList.add(Integer.valueOf(x));
		}
		integerList= Arrays.asList(6,5,4,3,2,1);
		//System.out.println(integerList.size());

		System.out.println(numberOfInversions(integerList));
	}

	private static long numberOfInversions(List<Integer> integerList) {
		return mergeAndReturnInversions(integerList.toArray(new Integer[] {}),
				0, integerList.size() - 1);
	}

	private static long mergeAndReturnInversions(Integer[] numbers, int i, int j) {
		return mergeSortHelper(numbers, i, j);
	}

	private static long mergeSortHelper(Integer[] a, int start, int end) {
		long numOfonversions=0;
		if (start < end) {
			int mid = (start + end) / 2;
			numOfonversions = mergeSortHelper(a, start, mid);
			numOfonversions+= mergeSortHelper(a, mid + 1, end);
			numOfonversions+= merge(a, start, end, mid);
		}
		return numOfonversions;
	}

	private static long merge(Integer[] a, int start, int end, int mid) {
		int x[] = new int[mid - start + 1];
		int y[] = new int[end - mid];
		// copy first array
		for (int i = 0; i < mid - start + 1; i++) {
			x[i] = a[start + i];
		}
		for (int i = 0; i < end - mid; i++) {
			y[i] = a[mid + 1 + i];
		}
		int numOfinversion=0;
		int i = 0;
		int j = 0;
		int k = start;
		while (i < x.length && j < y.length) {
			if (x[i] < y[j]) {
				a[k] = x[i];
				k++;
				i++;
			} else {
				a[k] = y[j];
				k++;
				j++;
				numOfinversion+=x.length-i;
			}
		}

		while (i < x.length) {
			a[k] = x[i];
			i++;
			k++;
		}
		while (j < y.length) {
			a[k] = y[j];
			j++;
			k++;
		}
		return numOfinversion;

	}

}
