package org.algolib.ds;

public class LNode<T> {
     private T data;
     private LNode<T> next;
     
     public LNode(T data) {
		this.data=data;
	}

	public LNode<T> getNext(){
    	 return this.next;
     }
     
     public T getData(){
    	 return this.data;
     }
	
     public void setData(T data){
    	 this.data=data;
     }

     public void setNext(LNode<T> next){
    	 this.next = next;
     }
}
