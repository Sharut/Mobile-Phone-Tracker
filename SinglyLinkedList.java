import java.util.*;

public class SinglyLinkedList <Object>{
public class Node {
	public Object element; // reference to the element stored at this node
	public Node next; // reference to the subsequent node in the list
	public Node (Object e, Node n) {
		element = e;
		next = n;
	}

	public Object getElement() 
		{ return element; }

	public Node getNext() 
		{ return next; }

	public void setNext(Node n) 
		{ next = n; }
}

private Node head = null; // head node of the list (or null if empty)
private Node tail = null; // last node of the list (or null if empty)
public int size = 0; // number of nodes in the list

public SinglyLinkedList () { } // constructs an initially empty list
 // access methods

public int size( ) 
	{ return size; }

public boolean isEmpty() 

	{ return size == 0; }

public boolean isMember(Object x){
	Node start = head;
	if(size==0)
		return false;
	else{
		while(start!=null){
			if(start.getElement()==x)
				return true;
			start = start.getNext();

		}
	}
	return false;

}

public Node first() { // returns (but does not remove) the first element
	if (isEmpty( )) return null;
	return head;
}

public Node last( ) { // returns (but does not remove) the last element
	if (isEmpty( )) return null;
	return tail;
}
 // update methods
public void addFirst(Object e) { // adds element e to the front of the list
	head = new Node(e, head); // create and link a new node
	if (size == 0)
		tail = head; // special case: new node becomes tail also
		size++;
}
public void addLast(Object e) { // adds element e to the end of the list
	Node newest = new Node (e, null); // node will eventually be the tail
	if (isEmpty( ))
		head = newest; // special case: previously empty list
	else
		tail.setNext(newest); // new node after existing tail
		tail = newest; // new node becomes the tail
		size++;
}
//public void removeFirst() { // removes and returns the first element
//	if (isEmpty( )) return null; // nothing to remove
//	head = head.getNext( ); // will become null if list had only one node
//	size−−;
//	if (size == 0)
//		tail = null; // special case as list is now empty
//}


public void DeleteAny(Object a){ // deletes any element in the list 
	if (isEmpty( )) return ; // nothing to remove
	if(isMember(a)==true){
		Node counter= head;
		Node previous = head;
		if(previous.getElement()==a){
			head = head.getNext( ); // will become null if list had only one node
			size = size - 1 ;
			if (size == 0)
				tail = null; // special case as list is now empty
		}			
		else{
			counter=counter.getNext();
			while(counter!=null){
				if(counter.getElement()==a)
					previous.setNext(counter.getNext());
				if(previous.getNext()==null)
					tail=previous;
				counter=counter.getNext();
				previous=previous.getNext();
			}
			size--;
			
		}
	}
}
}