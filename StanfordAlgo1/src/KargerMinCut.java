import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class KargerMinCut {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		HashMap<Integer,Node> intToNodeMap = new HashMap<Integer,Node>();
		
		String file = "kargerMinCut.txt";
		Scanner sc = new Scanner(new File(file));
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			String[] nodes = line.split("	");
			Integer first = Integer.parseInt(nodes[0]);
			Node firstNode = null;
			if(intToNodeMap.containsKey(first)){
				firstNode = intToNodeMap.get(first);
			}else{
				firstNode= new Node(first);
			}
			
			for(int i=1;i<nodes.length;i++){
				Integer child = Integer.parseInt(nodes[i]);	
				Node childNode = null;
				
				if(intToNodeMap.containsKey(child)){
					childNode = intToNodeMap.get(child);
				}else{
					childNode= new Node(child);
				}	
				firstNode.childNodes.add(childNode);
			}
			
		}
		
	}
	
	
	public static class Node{
		List<Node> childNodes = new ArrayList<Node>();
		int val;
		
		public Node(int val){
			this.val =val;
		}
		boolean hasChildren(){
			return this.childNodes!=null && this.childNodes.size()>0;
		}
		
	}
}
