public class ExchangeList extends SinglyLinkedList <Exchange> { // Exchange list class

	public ExchangeList merge(ExchangeList a){
		ExchangeList my = new ExchangeList();
		Node x = a.first();
		Node y = this.first();
		if(x==null)
			return this;
		if(y==null)
			return a;

		while(x!=null){
			my.addLast(x.getElement());
			x= x.getNext();
		}

		while(y!=null){
			my.addLast(y.getElement());
			y= y.getNext();
		}
		return my;

	}

	public String show(){
		Node a = this.first();
		String s = "";
		if(a==null)
			return s;
		if(a.getNext()==null){
			s= s+a.getElement().treeId;
			return s;
		}

		while(a.getNext()!=null){
			s= s+a.getElement().treeId +", ";
			a=a.getNext();
		}
		s=s+a.getElement().treeId;
		return s;

		
	}
}