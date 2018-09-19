
import java.util.*;

public class Exchange extends ExchangeList{
	public int treeId;
	public ExchangeList one ;
	public Exchange father ;
	public MobilePhoneSet ring;
	

	public Exchange(int number){	
			// define  constructor//
		one =  new ExchangeList();
		treeId=number;
		father=null;
		ring = new MobilePhoneSet();
	}

	public Exchange parent(){
		return father;
	}
	public int numChildren(){
		return one.size();
	}


	public Exchange child(int i){
		Node aw = one.first();
		if(aw==null)
			return null;
		if(i==0)
			return aw.getElement();

		for(int j=1;j<=i;j++){
			aw=aw.getNext();
		}
		return aw.getElement();

	}
	public void setParent(Exchange a){
        father = a;
	}
    

	public void addChild(Exchange a){
		a.setParent(this);
		one.addLast(a);

	}

	public Boolean isRoot(){
		return this.parent()==null;
	}

	/*public void getRoot()
    {
        return treeId;
    }*/

	public RoutingMapTree subtree(int i) {

		if(child(i)==null)
			return null;

		RoutingMapTree myTree = new RoutingMapTree();
		myTree.mynode=child(i);
		return myTree;
	}


	public MobilePhoneSet residentSet(){
		//MobilePhoneSet mynewset= new MobilePhoneSet();

		//while(ring.list.first()!=null){
			//if(ring.list.first().getElement().status()==true)
		//		mynewset.Insert(ring.list.first().getElement());
//
//			ring.list.first() = ring.list.first().getNext();
//		}
//		return mynewset;
		return ring;
	}
}