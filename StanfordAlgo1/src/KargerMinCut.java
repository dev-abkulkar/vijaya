import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class KargerMinCut {
	
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		HashMap<Integer,Node> intToNodeMap = new HashMap<Integer,Node>();
		
		String file = "kargerMinCut.txt";
		Scanner sc = new Scanner(new File(file));
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			String[] nodes = line.split("[\\s\\t]");
			Integer first = Integer.parseInt(nodes[0]);
			Node firstNode = null;
			if(intToNodeMap.containsKey(first)){
				firstNode = intToNodeMap.get(first);
				System.out.println(first+" is already in map");
			}else{
				firstNode= new Node(first);
				intToNodeMap.put(first,firstNode);
			}
			System.out.println(firstNode);
			
			for(int i=1;i<nodes.length;i++){
				Integer child = Integer.parseInt(nodes[i]);	
				Node childNode = null;
				
				if(intToNodeMap.containsKey(child)){
					childNode = intToNodeMap.get(child);
				}else{
					childNode= new Node(child);
					intToNodeMap.put(child,childNode);
				}
				firstNode.childNodes.add(childNode);
			}
		}
		
		//printGraph(intToNodeMap,"Generated graph...");
		TreeSet<Integer> minCutSet = new TreeSet<Integer>();
		for(int z=0;z<3000;z++){
			int mc = kargerMinCut(intToNodeMap);
			minCutSet.add(mc);
			//System.out.println("Output.............................................");
			System.out.println("Min Cut ["+z+"]="+mc);
			
		}
		System.out.println("Krager Min Cut = "+minCutSet.first());
	}
	
	
	private static void printGraph(HashMap<Integer, Node> intToNodeMap, String string) {
		// TODO Auto-generated method stub
		if(string!=null)
			System.out.println(string);
		for(Integer key : intToNodeMap.keySet()){
			System.out.print(key+"-->");
			List<Node> children = intToNodeMap.get(key).childNodes;
			for (Node node : children) {
				System.out.print(node.val+",");
			}
			System.out.println();
		}
		System.out.println();
	}


	private static int kargerMinCut(HashMap<Integer, Node> intToNodeMap) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos  = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(intToNodeMap);
		oos.flush();
		oos.close();
		bos.close();
		byte[] byteData =  bos.toByteArray();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
		HashMap<Integer,Node> clonedMap = (HashMap<Integer, Node>) new ObjectInputStream(bais).readObject();
		//printGraph(clonedMap);
		
		while(true){
			
			Set<Integer> vertices = clonedMap.keySet();	
			List<Integer> vertexList  = new ArrayList<Integer>(vertices);
			if(vertexList.size()==2) break;
			
			//choose 2 vertices at random.
			int verIndex1 = ThreadLocalRandom.current().nextInt(0, vertexList.size());
			Node node1 = clonedMap.get(vertexList.get(verIndex1));
			List<Node> childNodes = node1.childNodes;
			
			int verIndex2 = ThreadLocalRandom.current().nextInt(0, childNodes.size());
			//fuse them into a single node.
			Node node2 = clonedMap.get(childNodes.get(verIndex2).val);
			//System.out.println("Fusing node :"+node1 +" <-- "+node2);
			//fuse node2 into node1
			node1.fusedNodes.add(node2);
			for(Node childOfNode2: node2.childNodes){
				if(!childOfNode2.equals(node1)){
					node1.childNodes.add(childOfNode2);
					//System.out.println("Adding "+childOfNode2+" as a child to "+node1);
				}
				List<Integer> indiciesOfNode2 = new ArrayList<Integer>();
				for(int i=0; i<childOfNode2.childNodes.size();i++){
					if(childOfNode2.childNodes.get(i).equals(node2)){
						indiciesOfNode2.add(i);
					}
				}
				
				for(int i:indiciesOfNode2){
					if(!childOfNode2.childNodes.get(i).equals(node1))
						childOfNode2.childNodes.set(i, node1);
				}
				
			}
			
			clonedMap.remove(node2.val);
			//printGraph(clonedMap,"Before Removing self loops..........");
			for(Integer nodeInd : clonedMap.keySet()){
				Node nodeX = clonedMap.get(nodeInd);
				List<Integer> selfLoopIndices = new ArrayList<Integer>();
			
				for(int x =0;x<nodeX.childNodes.size();x++){
					if(nodeX.equals(nodeX.childNodes.get(x))){
						selfLoopIndices.add(x);
					}
				}
				Collections.reverse(selfLoopIndices);
				for(int y:selfLoopIndices){
					nodeX.childNodes.remove(y);
				}
			}
			//printGraph(clonedMap,"After Removing self loops..........");
		}
		System.out.println();
		//printGraph(clonedMap,"Final graph..........");
		Integer[] keysArr = clonedMap.keySet().toArray(new Integer[2]);
		return clonedMap.get(keysArr[0]).childNodes.size();
	}


	public static class Node implements Serializable{
		List<Node> childNodes = new ArrayList<Node>();
		List<Node> fusedNodes = new ArrayList<Node>();
		int val;
		
		public Node(int val){
			this.val =val;
		}
		boolean hasChildren(){
			return this.childNodes!=null && this.childNodes.size()>0;
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
