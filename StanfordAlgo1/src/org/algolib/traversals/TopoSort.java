package org.algolib.traversals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.algolib.beans.Node;

public class TopoSort<T> {

	private Stack<Node<T>> topoOrder = new Stack<Node<T>>(); 
	Set<Node<T>> visitedNodes = new HashSet<Node<T>>();
	
	
	public Stack<Node<T>> topoSort(List<Node<T>> nodes){
		for(Node<T> n:nodes){
			if(!visitedNodes.contains(n)){
				DFS(n);
			}
		}
		return topoOrder;
	}


	private void DFS(Node<T> n) {
		visitedNodes.add(n);
		for(Node forwardNode : n.getForwardNodes()){
			DFS(forwardNode);
			topoOrder.add(forwardNode);
		}
	}
	
}
