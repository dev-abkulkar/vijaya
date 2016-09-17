package algo.bitops;

public class InsertMIntoN {

	public static int insertMIntoNFromJtoI(int M,int N,int j,int i){
		int x = ~0<<j+1;
		int y= ~0>>>32-i;
		int mask = x|y;
		int NN = N&mask;
		int MM = M<<i;
		return NN | MM;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = ~0;
		System.out.println(Integer.toBinaryString(x));
		int y = x>>>8;
		System.out.println(Integer.toBinaryString(y));
		System.out.println(x+" "+y);
		
		int N = 1<<31;
		int M = 0b11;
		int j=2;
		int i=1;
		System.out.println(Integer.toBinaryString(N));
		System.out.println(Integer.toBinaryString(M));
		System.out.println(Integer.toBinaryString(insertMIntoNFromJtoI(M, N, j, i)));
		
	}

}
