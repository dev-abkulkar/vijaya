package algo.part2;

public class TraverseArrayWithMinStepsRec {
	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		//int[] a = { 2,3,1,1,4};
		//int[] a ={1,1,2,3,1,4};
		int minNumOfSteps = INF;
		System.out.println("length = "+a.length);
		// for(int i=0;i<a.length;i++){
		minNumOfSteps = minNumOfSteps(a, 0, a.length-1);
		// }
		System.out.println(minNumOfSteps);
	}

	public static int minNumOfSteps(int[] a, int i, int len) {
		if (a[i] >= len)
			return 1;
		if (a[i] == 0)
			return INF;

		int curMin = INF;
		for (int j = 1; j <= a[i]; j++) {
			int k = minNumOfSteps(a, i + j, len - j);
			if (k < curMin)
				curMin = k;
		}
		return 1 + curMin;
	}

}
