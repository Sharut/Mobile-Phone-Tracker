import java.util.*;
import java.io.*;

public class RoutingMapTree {

	public Exchange mynode; //mynode corresponds to the root of the tree//

	public RoutingMapTree(){
		mynode = new Exchange(0);

	}

	public Boolean containsNode(Exchange a){
		if(mynode==a)
			return true;
		if(mynode.one.size()==0)
			return false;
		for(int i=0;i<mynode.one.size();i++){
			if( mynode.subtree(i).containsNode(a)==true)
				return true;
		}
	return false;

	}

	public Boolean containsId(int id){
		if(mynode.treeId == id)
			return true;
		for(int i=0;i<mynode.one.size();i++){
			if( mynode.subtree(i).containsId(id)==true)
				return true;
		}
	return false;
	}


	public Exchange getNode(int ids){
		if(mynode.treeId == ids)
			return mynode;
		for(int i=0;i<mynode.numChildren();i++){
			 Exchange my = mynode.subtree(i).getNode(ids);
			 if (my!= null )
			 	return my;		 
		}
	return null;
	}

	public void switchOn (MobilePhone a, Exchange b){

		if(a.status()==false){
			a.switchOn();
			b.residentSet().Insert(a);
			a.setBaseStation(b);
			//System.out.println(b.parent().treeId);
			while(b.isRoot()==false){
				b=b.parent();
				b.residentSet().Insert(a);
				//System.out.println("switched on phone and added it to exchange B" + b.treeId);
				//b.residentSet().mysetDisplay();
			}

		}
		else
			System.out.println("MobilePhone " + a.number() +  " is already switched on");
	}

	public void switchOff(MobilePhone a){

		if(a.status()==true){
			a.switchOff();
		//	Exchange x=a.location();
		//	a.base=null;

		//	while(x!=null){
		//		x.ring.Delete(a);
		//		x=x.parent();
		//	}	
			
		}
		else
			System.out.println("MobilePhone " + a.number() + " is already switched off");

	}

	public Exchange findPhone(MobilePhone m) {
		return m.location();
		
	}


	public Exchange lowestRouter(Exchange a, Exchange b)    {
		//if(a==null || b==null)
			//throw new Commonparent(a.treeId + " and "+ b.treeId + " don't have a common parent ");
		if(a==b)
			return a;
		return lowestRouter(a.parent(),b.parent());

	}

	public ExchangeList routeCall(MobilePhone a, MobilePhone b) {
		
				
		ExchangeList m1 = new ExchangeList();
		ExchangeList m2 = new ExchangeList();

		Exchange baseA = a.location();
		Exchange baseB = b.location();
		Exchange top= lowestRouter(baseA,baseB);
		while(baseA!=top){
			m1.addLast(baseA);
			baseA =  baseA.parent();
		}
		m1.addLast(top);
		//System.out.println(m1.show());
		while(baseB!=top){
			m2.addFirst(baseB);
			baseB=baseB.parent();
		}
		//System.out.println(m2.show());
		//System.out.println(m2.merge(m1).show());
		return m2.merge(m1);


	}

	public void movePhone(MobilePhone a, Exchange b){
			Exchange x = a.location();
			
			while(x.parent()!=null){
				x.ring.Delete(a);
				x=x.parent();
			}
			if(x.parent()==null)
				x.ring.Delete(a);
			//Exchange x = a.location();
			switchOff(a);
			switchOn(a,b);
			//System.out.println(x.parent().residentSet().mysetPhone()+ "hey");
		
	}


	public String performAction(String actionMessage){
		Scanner s = new Scanner(actionMessage);
		String check = s.next();
		if(check.equals("addExchange")){
			int l = s.nextInt();
			Exchange exA = getNode(l);
			Exchange exB = new Exchange(s.nextInt());
			//if(exA == null){
			//	throw new java.util.NoSuchElementException("node not in the tree");
			//}
			//else{
			//	exA.addChild(exB);
				//System.out.println("exchnge a is " + exA.treeId + " child is "+ exA.child(exA.one.size()-1).treeId);
				//System.out.println("parent of " + exB.treeId + "is " + exB.parent().treeId);
			try{
				exA.addChild(exB);
				return actionMessage;
			}
			catch(Exception e){
				return actionMessage + ": Error- No exchange with identifier " + l;
			}
			//}
		}


		else if(check.equals("findPhone")){
			int phoneid = s.nextInt();
			MobilePhone m = mynode.residentSet().getMobilePhone(phoneid);
			if(mynode.residentSet().IsMember(m)==false){
				try{
					throw new IOException();
				}
				catch(IOException abh){
					return "queryFindPhone " + phoneid + ": " + "Error - No mobile phone with identifier " + phoneid +" found in the network";
				}
			}
			else if(m.status()==false){
				try{
					throw new IOException();
				}
				catch(IOException abh){
					return "queryFindPhone " + phoneid + ": " + "Error -MobilePhone "+ m.number() +" is switched OFF";
				}
			}

			else{
				Exchange x = findPhone(m);
				return "queryFindPhone " + phoneid + ": " +x.treeId ;
			}
			
		
		}

		else if(check.equals("lowestRouter")){
			int id1=s.nextInt();
			int id2=s.nextInt();
			Exchange node1 = getNode(id1);
			Exchange node2 = getNode(id2);
			try{
				return "queryLowestRouter " + id1+ " "+ id2 + ": "+  lowestRouter(node1, node2).treeId;
			}
			catch(Exception f){
				return "queryLowestRouter " + id1+ " "+ id2 + ": Error- exchanges dont have a common parent"; 
			}

		}

		else if(check.equals("findCallPath")){
			int idA=s.nextInt();
			int idB=s.nextInt();
			MobilePhone a = mynode.residentSet().getMobilePhone(idA);
			MobilePhone b = mynode.residentSet().getMobilePhone(idB);
			if(mynode.residentSet().IsMember(a)==false){
				try{
					throw new IOException();
				}
				catch(IOException abh){
					return "queryFindCallPath " + idA + " " + idB +": Error - No MobilePhone "+ a.number() +" found";
				}

			}
			else if(mynode.residentSet().IsMember(b)==false){
				try{
					throw new IOException();
				}
				catch(IOException ajk){
					return "queryFindCallPath " + idA + " " + idB +": Error - No MobilePhone "+ b.number() +" found";
				}
			}
			else if(a.status()==false){
				try{
					throw new IOException();
				}
				catch(IOException aty){
					return "queryFindCallPath " + idA + " " + idB +": Error - Mobile phone with identifier "+a.number()+" is currently switched off";
				}
			}

			else if(b.status()==false){
				try{
					throw new IOException();
				}
				catch(IOException aer){
					return "queryFindCallPath " + idA + " " + idB +": Error - Mobile phone with identifier "+b.number()+" is currently switched off";
				}
			}

			else{
				ExchangeList mm = routeCall(a,b);
				return "queryFindCallPath " + idA + " " + idB +": " + mm.show();

			}

		
		}

		else if(check.equals("movePhone")){
			int mobId= s.nextInt();
			int nodeId = s.nextInt();
			MobilePhone a = mynode.residentSet().getMobilePhone(mobId);
			Exchange b = getNode(nodeId);
			if(this.containsNode(b)==false){
				try{
					throw new IOException();
				}
				catch(IOException l){
					return actionMessage + "Error -Exchange "+ b.treeId +" Not found ";
				}
			}
			else if(b.numChildren()>0){
				try{
					throw new IOException();
				}
				catch(IOException aer){
					return actionMessage + "Error: "+ b.treeId+" isn't a base station";
				}
			}

			else if(a.status()==false){
				return actionMessage + "Error -MobilePhone "+ a.number() +" is switched OFF";
			}

			else{
				movePhone(a,b);
			}

		}

		else if(check.equals("switchOnMobile")){
			int mobileno= s.nextInt();
			int mynewnodeid = s.nextInt();
			//if(containsId(mynewnodeid)==false)
			//	throw new java.util.NoSuchElementException("node not in the tree");
			try{
				Exchange mynewnode = getNode(mynewnodeid);
				MobilePhone mynewphone = mynode.residentSet().getMobilePhone(mobileno);
				if(mynewphone!=null){
					MobilePhone meu = mynode.residentSet().getMobilePhone(mobileno);
					//System.out.println("bla");
					switchOn(meu , mynewnode);
					return actionMessage;
				}
				else{
					mynewphone = new MobilePhone(mobileno);
					//System.out.println("lalalala");
					switchOn(mynewphone,mynewnode);
					return actionMessage;
				}

			}
			catch(Exception h){
				return actionMessage + ": Error- No exchange with identifier " + mynewnodeid	;
			}
		}

		else if(check.equals("switchOffMobile")){
			int hell = s.nextInt();
			MobilePhone myphone = mynode.residentSet().getMobilePhone(hell);
			//if(myphone==null)
			//	throw new java.util.NoSuchElementException("No phone found----bla");
			try{
				switchOff(myphone);
				return actionMessage;
			}
			catch(Exception m){
				return actionMessage + ": Error- No exchange with identifier "+ hell;
			}
			
		}

		else if(check.equals("queryNthChild")){
			int temp=s.nextInt();
			int temp1=s.nextInt();
			//if(containsId(temp)==false)
			//	throw new java.util.NoSuchElementException("No Exchange found ");
			if(containsId(temp)==true)
				try{
				//System.out.println(getNode(temp).child(temp1).treeId);
					return actionMessage + ": "+Integer.toString(getNode(temp).child(temp1).treeId);
			}
				catch(Exception k){
					return actionMessage + ": Error - No " + temp1+" child of Exchange "+ temp;
			}
			else{
					return actionMessage + ": Error- No exchange with identifier "+ temp;
				
			}
		}


		else if(check.equals("queryMobilePhoneSet")){
			int tempo= s.nextInt();
			//if(containsId(tempo)==false)
			//	throw new java.util.NoSuchElementException("No Phone found ");
			try{
				//getNode(tempo).residentSet().mysetDisplay();
				return actionMessage+": "+getNode(tempo).residentSet().mysetPhone();
			}
			catch(Exception q){
				return actionMessage +": No Such Node with id " + tempo +" exists ";
			}		
		}
	return actionMessage;
	}
}





	
