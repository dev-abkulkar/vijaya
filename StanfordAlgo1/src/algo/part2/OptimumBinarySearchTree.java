package algo.part2;

public class OptimumBinarySearchTree {
	static double[] f = { 0.05, 0.4, 0.08, 0.04, 0.1, 0.1, 0.23 };
	//static double[] f = { 0.8, 0.1, 0.1};

	public static void main(String[] args) {
		int n = f.length;
		double[][] a = new double[f.length][f.length];
		for (int s = 0; s <= n - 1; s++) {
			for (int i = 0; i < n; i++) {
				if(i+s<=n-1){
					a[i][i+s] = findMin(a,i,s);
				}
			}
		}
		System.out.println("Optimum Value= "+a[0][n-1]);
	}

	private static double findMin(double[][] a, int i, int s) {
		double min = Double.MAX_VALUE;
		double sigmaPk = sumOfFrequencies(i, i+s);
		for (int r = i; r <= i+s; r++) {
			double airminus1 = r - 1 < 0 ? 0 : a[i][r - 1];
			double ar1j = r + 1 > a.length - 1 ? 0 : a[r + 1][i+s];
			double cur = sigmaPk + airminus1 + ar1j;
			min = cur < min ? cur : min;
		}
		return min;
	}

	private static double sumOfFrequencies(int i, int j) {
		double sum = 0;
		for (int k = i; k <= j; k++) {
			sum+=f[k];
		}
		return sum;
	}
}
