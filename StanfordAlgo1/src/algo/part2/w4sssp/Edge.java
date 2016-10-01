package algo.part2.w4sssp;

import java.math.BigDecimal;

public class Edge {

	protected int from;
	protected int to;
	protected BigDecimal weight;
	
	public Edge(int from, int to, BigDecimal weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	
	
}
