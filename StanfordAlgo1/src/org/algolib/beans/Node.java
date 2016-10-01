package org.algolib.beans;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	private T value ;
	private List<Node<T>> forwardNodes = new ArrayList<Node<T>>();
	private List<Node<T>> backNodes = new ArrayList<Node<T>>();
	
	public Node(T value){
		this.value=value;
	}
	
	public T getValue(){
		return value;
	}
	
	public void setValue(T value){
		this.value = value;
	}
	
	@Override
	public boolean equals(Object node){
		if(this == node)
			return true;
		if(node == null)
			return false;
		if(this.getClass()!=node.getClass())
			return false;
		Node<T> other = (Node<T>)node;
		if(value == null)
			return false;
		return this.value.equals(other.value);
	}

	public List<Node<T>> getForwardNodes() {
		return forwardNodes;
	}

	public void setForwardNodes(List<Node<T>> forwardNodes) {
		this.forwardNodes = forwardNodes;
	}

	public List<Node<T>> getBackNodes() {
		return backNodes;
	}

	public void setBackNodes(List<Node<T>> backNodes) {
		this.backNodes = backNodes;
	}
}
