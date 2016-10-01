package org.algolib.clusters;


class Edge implements Comparable<Edge>{
	int  u,v;
	long length; 
	Edge(int u2,int v2,long length){
		this.v=Math.min(u2, v2);
		this.u=Math.max(u2, v2);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (length ^ (length >>> 32));
		result = prime * result + u;
		result = prime * result + v;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (length != other.length)
			return false;
		if (u != other.u)
			return false;
		if (v != other.v)
			return false;
		return true;
	}
}