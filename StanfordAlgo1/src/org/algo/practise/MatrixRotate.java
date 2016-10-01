package org.algo.practise;

public class MatrixRotate {

	private int[][] a ;
	private int n;
	
	public MatrixRotate(int[][] a, int n) {
		this.a = a;
		this.n = n;
	}
	
	public int[][] rotateClockwise(){
		int layer = this.n;
		int count = 0;
		while(layer-count>1){
			processLayer(count,layer);
			layer--;
			count++;
			
		}
		return this.a;
		
	}

	private void processLayer(int count, int layer) {
		int s = count;
		int l=layer-1;
		for (int i = s; i < l; i++) {
			int o = i-s;
			//store top in temp
			int top = a[s][i];
			
			// left-->top
			a[s][i] = a[l-o][s];
			
			//bottom-->left
			a[l-o][s] = a[l][l-o];
			
			//right-->bottom
			a[l][l-o] = a[s+o][l];
			
			//top-->right
			a[s+o][l] = top;
		}
		
	}
	
}
