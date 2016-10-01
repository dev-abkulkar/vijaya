package org.algolib.utils;

public class Combinations {
	public static void main(String[] args) {
	    String a = "ABCDE";
	    int r=1;
	    printCombinations(a,r);   
	  }
	  
	  
	  static void printCombinations(String a ,int r){
	    int n = a.length();
	    if(n==r){
	      System.out.println(a);
	      return;
	    }
	    if(n<r)
	      return;
	    
	    String[] aa = a.split("");
	    
	    for(int i=0;i<=n-r;i++){
	      printCombUtil(aa,i,n-1,r,aa[i]);
	    }
	    
	  }
	  
	  static void printCombUtil(String[] a, int start,int end,int r ,String x){
	    if(x.length()==r){
	      System.out.println(x);
	    }
	    for(int k=start+1;k<=end;k++){
	      printCombUtil(a,k,end,r,x+a[k]);
	    }
	  }

}
