import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class SCC {

	
	public static void main(String[] args) throws FileNotFoundException {
		String file = "kargerMinCut.txt";
		Scanner sc = new Scanner(new File(file));
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			String[] nodes = line.split("[\\s\\t]");
			Integer from = Integer.parseInt(nodes[0]);
			Integer to = Integer.parseInt(nodes[1]);
			
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static class Node implements Serializable{
		List<Node> ins = new ArrayList<Node>();
		List<Node> outs = new ArrayList<Node>();
		
		int val;
		
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


