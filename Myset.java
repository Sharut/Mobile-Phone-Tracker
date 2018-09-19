import java.util.*;



public class Myset <Object> extends SinglyLinkedList <Object>{
	public SinglyLinkedList <Object> list;

    public Myset () {
    	list = new SinglyLinkedList <Object>(); 
    } // constructs an initially empty set

    public int size(){
    	return list.size();
    }

    public Boolean IsEmpty()
    {
        return list.isEmpty();
    }

    public Boolean IsMember(Object a){
        return list.isMember(a);

    }

    public void Insert(Object o){
    	if(list.isMember(o)==false)
			list.addLast(o); 
    }

    public void Delete(Object o){
    	if(list.isMember(o)==false)
    		throw new java.util.NoSuchElementException("element doesn't belong to the set");
    	else
    		list.DeleteAny(o);		
    }

    public Myset Union(Myset <Object> a){
    	Myset <Object> firstSet = new Myset <Object>();
    	Node am = this.list.first(); 
    	Node amm = a.list.first();
    	if(am!=null){
    		while(am!=null){
    			firstSet.Insert(am.getElement());
    			am=am.getNext();
    		}
    	}

    	if(amm!=null){
    		while(amm!=null){
    			firstSet.Insert(amm.getElement());
    			amm=amm.getNext();
    		}
    	}

    	return firstSet;
    }

    public Myset Intersection(Myset <Object> a){
    	Myset <Object> secondSet = new Myset <Object>();
    	Node ala = this.list.first();
    	while(ala!=null){
    		if(a.IsMember(ala.getElement())==true)
    			secondSet.Insert(ala.getElement());
    		ala=ala.getNext();
    	}
    	return secondSet;
    }

    public void Display(){
    	Node hum = this.list.first();
    	if(hum==null)
    		return ;
    	while(hum.getNext()!=null){
    		System.out.print(hum.getElement() + ",");
    		hum=hum.getNext();
    	}
    	System.out.print(hum.getElement());
    	System.out.println();

    }
  
/*
    public static void main(String args[])
    {
    	Myset hello = new Myset();
    	Myset hey = new Myset();
    	hey.Insert(2);
    	hey.Insert(1);
    	hey.Insert(5);
    	hello.Insert(5);
    	hello.Insert(6);
    	hello.Insert(7);
    	System.out.println(hello.IsMember(9));
    	hello.Delete(6);
    	hello.Insert(8);
    	hello.Display();
    	hey.Display();
    	Myset bae= hello.Intersection(hey);
    	bae.Display();
    	System.out.println(hello.size());


    }*/
}












