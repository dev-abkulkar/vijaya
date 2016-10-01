import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;





public class SCC {
	
	
	static HashMap<Integer,Node> intToNodeMap = new HashMap<Integer,Node>();
	static String file = "SCC.txt";
	static int largestNode=Integer.MIN_VALUE;
	static int smallestNode=Integer.MAX_VALUE;
	static int finTime =0;
	static List<Node> stack = new LinkedList<Node>();
	
	public static void main(String[] args) throws FileNotFoundException {
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(new File(file));
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			String[] nodes = line.split("[\\s\\t]");
			Integer from = Integer.parseInt(nodes[0]);
			Integer to = Integer.parseInt(nodes[1]);
			smallestNode = Math.min(smallestNode, Math.min(from, to));
			largestNode = Math.max(largestNode, Math.max(from,to));
			
			Node fromNode;
			Node toNode;
			
			if(intToNodeMap.containsKey(from)){
				 fromNode = intToNodeMap.get(from);
			}else{
				fromNode = new Node(from);
				intToNodeMap.put(from, fromNode);
			}
			
			if(intToNodeMap.containsKey(to)){
				 toNode = intToNodeMap.get(to);
			}else{
				toNode = new Node(to);
				intToNodeMap.put(to	, toNode);
			}
			
			fromNode.outs.add(toNode);
			toNode.ins.add(fromNode);
		}
		
		
		System.out.println("Smallest Node:"+smallestNode+" Largest Node: "+largestNode);
		System.out.println("Initializing reverse dfs to build the stack....");
		System.out.flush();
		//reverse dfs on the the graph
		for(Node n: intToNodeMap.values()){
			if(!n.backVisit){
				//System.out.println("Back visiting: "+n.val);
				//System.out.flush();
				dfs(n, false,null);
			}
		}
		//printStack();
		System.out.println("Done building the stack......");
		System.out.flush();
		int[] top = new int[6];
		for (int i=stack.size()-1;i>=0;i--) {
			Node n =stack.get(i);
			if(!n.frontVisit){
				//System.out.println("Forward traversing node "+n.val);
				n.totalNodes++;
				dfs(n, true,n);
				if(top[1]==0){
					top[1]=n.totalNodes;
					
				}else if(top[2]==0){
					top[2]=n.totalNodes;
					
				}else if(top[3]==0){
					top[3]=n.totalNodes;
					
				}else if(top[4]==0){
					top[4]=n.totalNodes;
					
				}else if(top[5]==0){
					top[5]=n.totalNodes;
					
				}else{
					top[0]=n.totalNodes;
					Arrays.sort(top);
					//top[0]=0;
				}
			}
		}
		
		//List<Node> nodes = new ArrayList<Node>(intToNodeMap.values());
		/*Collections.sort(nodes, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				
				return o2.totalNodes-o1.totalNodes;
			}
		});*/
		
		/*System.out.println("Top 3 SCCs with max-nodes:" + nodes.get(0).val
				+ ":" + nodes.get(0).totalNodes + ", " + nodes.get(1).val + ":"
				+ nodes.get(1).totalNodes + ", " + nodes.get(2).val + ":"
				+ nodes.get(2).totalNodes);*/
		System.out.println("Top 5 SCCs with max-nodes:"+top[5]+","+top[4]+","+top[3]+","+top[2]+","+top[1]);
		long end = System.currentTimeMillis();
		System.out.println("Total time taken in minutes= "+(end-start)/(1000*60));
		
	}
	
	private static void printStack() {
		for (int i=stack.size()-1;i>=0;i--) {
			Node n =stack.get(i);
			System.out.print(n.val+" ");
		}
		System.out.println();
	}

	public static void dfs(Node n,boolean front,Node absoluteRoot){
		if(front){
			n.frontVisit=true;
			for(Node node:n.outs){
				if(!node.frontVisit){
					absoluteRoot.totalNodes++;
					dfs(node,front,absoluteRoot);
				}
			}
		}else{
			n.backVisit=true;
			for(Node node:n.ins){
				if(!node.backVisit)
					dfs(node,front,absoluteRoot);
			}
			stack.add(n);
			
		}
		
		
	}
	
	
	public static class Node implements Serializable{
		List<Node> ins = new ArrayList<Node>();
		List<Node> outs = new ArrayList<Node>();
		boolean frontVisit;
		boolean backVisit;
		int finTime; 
		int val;
		int totalNodes=0;
		
		public Node(int val){
			this.val =val;
		}
		
		boolean hasOuts(){
			return this.outs!=null && this.outs.size()>0;
		}
		
		@Override
		public String toString() {
			return "Node [val=" + val + "]";
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + val;
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
			Node other = (Node) obj;
			if (val != other.val)
				return false;
			return true;
		}
		
	}
}


