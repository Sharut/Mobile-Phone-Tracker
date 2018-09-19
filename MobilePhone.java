import java.util.*;


public class MobilePhone {			//mobile phone class
	public int mobilenumber;
	public boolean mobilestatus;
	public Exchange base;
	public MobilePhone(int number){
		mobilenumber = number;
	}

	public int number(){
		return mobilenumber;
	}

	public Boolean status(){
		return mobilestatus;
	}

	public void switchOn(){
		mobilestatus=true;

	}

	public void switchOff(){
		mobilestatus=false;

	}

	public Exchange location(){
			return base;
	}

	public void setBaseStation(Exchange base){
		this.base=base;
		
	}


}