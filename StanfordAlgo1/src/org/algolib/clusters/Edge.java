package org.algolib.clusters;


class Edge implements Comparable<Edge>{
	int  u,v;
	long length; 
	Edge(int u2,int v2,long length){
		this.v=v2;
		this.u=u2;
		this.length=length;
	}
	
	@Override
	public int compareTo(Edge o) {
		return (int) (this.length-o.length);
	}

	@Override
	public String toString() {
		return "Edge [u=" + u + ", v=" + v + ", length=" + length + "]";
	}
}