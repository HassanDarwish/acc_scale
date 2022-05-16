package proxyAction;
import java.sql.Timestamp;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.enums.actions;
import com.users.*;

import observer.Iobservable;
import observer.Iobserver;
import observer.Logger;
import truck_scale.button.Click_save_matrail;
import truck_scale.interfaces.ITextFiled;
public   class ProxyAuth<T> implements IProxy ,Iobservable{

private user user;private T truck_Number;
private actions action;Iobserver dataModelObserver;
	private ProxyAuth(user user,T truck_Number, actions action_type,Iobserver dataModelObserver) {
		 attach(new Logger(),"logger");
		 this.dataModelObserver=dataModelObserver;
		this.user=user;this.truck_Number=truck_Number;this.action=action_type;
	}
	@Override
	public boolean action() {
		// TODO Auto-generated method stub
		boolean returnResult=false;
		
		switch (action) {
		
		case SaveTruck:
			if(user.getAuthRole().equals("admin"))
			{
				IProxy action=new SaveTruckAction.Builder<T>().build(this.user,this.truck_Number,dataModelObserver);
				update(" Saved Truck by "+user.getName()+" :"+new Timestamp(System.currentTimeMillis()),"logger");
				returnResult=  action.action();
			}else {
				update("You do not have permission unauthorized "+user.getName()+" :"+new Timestamp(System.currentTimeMillis()),"logger");
				JOptionPane.showMessageDialog(null, "You do not have permission","unauthorized ", JOptionPane.ERROR_MESSAGE);
				returnResult=false;
			}
		break;
		case ListSCars :
	 		
			break;
		case Editcar :
	 		
			break;
		case findcarbyid :
	 		
			break;
		case SaveMatrial:
			if(user.getAuthRole().equals("admin"))
			{
				IProxy action=new SaveMatrialAction.Builder<T>().build(user,this.truck_Number,dataModelObserver);
				update(" Saved Truck by "+user.getName()+" :"+new Timestamp(System.currentTimeMillis()),"logger");
				returnResult=  action.action();
			}else {
				update("You do not have permission unauthorized "+user.getName()+" :"+new Timestamp(System.currentTimeMillis()),"logger");
				JOptionPane.showMessageDialog(null, "You do not have permission","unauthorized ", JOptionPane.ERROR_MESSAGE);
				returnResult=false;
			}
		break;
		}
		return returnResult;
			
	}

	
	public  static   class Builder<T> implements ITextFiled {
		 public JTextField truck_Number = new JTextField();
		 
		public Builder<T> setTruck_Number(T truck_Number) {
			this.truck_Number = (JTextField) truck_Number;
			return this;
		}

		
		public ProxyAuth<T> build(user user, T truck_Number, actions savetruck,Iobserver dataModelObserver) {
			return new ProxyAuth<T>(user,truck_Number,savetruck,dataModelObserver);
		}
		
	}


	@Override
	public void attach(Iobserver obv, String id) {
		// TODO Auto-generated method stub
		observers.put(id,obv);
	}

	@Override
	public void update(String sms, String id) {
		// TODO Auto-generated method stub
		((Iobserver)observers.get(id)).update(sms);
	}
}
