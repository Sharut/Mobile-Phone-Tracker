import java.util.*;

public class MobilePhoneSet extends Myset<MobilePhone>{

	public MobilePhone getMobilePhone(int mynumber){ // gives back the mobile phone given its identifier 
		Node counter1= list.first();
		while(counter1!=null){
			if(counter1.getElement().number()==mynumber)
				return counter1.getElement();
			counter1 =  counter1.getNext();
		}
	return null;

	}

	public void mysetDisplay(){
		Node yes = this.list.first();
		if(yes==null)
			return;
		if(yes.getNext()==null){
			if(yes.getElement().status()==true)
				System.out.println(yes.getElement().number());

			return;
		}

		while(yes.getNext()!=null){
			if(yes.getElement().status()==true)
				System.out.print(yes.getElement().number()+", ");
			yes=yes.getNext();
		}
		if(yes.getElement().status()==true)
			System.out.print(yes.getElement().number());
		 System.out.println("");
	}

	public String mysetPhone(){
		Node yes = this.list.first();
		String s = "";
		if(yes==null)
			return s;
		if(yes.getNext()==null){
			if(yes.getElement().status()==true)
				s= s+yes.getElement().number();
			return s;
		}

		while(yes.getNext()!=null){
			if(yes.getElement().status()==true)
				s= s+yes.getElement().number()+", ";
			yes=yes.getNext();
		}
		if(yes.getElement().status()==true)
			s=s+yes.getElement().number();
		return s;
		//System.out.println();
	}

	//public boolean isMember(MobilePhone l){
	//	return l.location().residentSet().isMember(l)==true;
	//}







}