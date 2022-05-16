package truck_scale.button;
import com.users.*;

import observer.Iobserver;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import com.enums.actions;
import proxyAction.IProxy;
import proxyAction.ProxyAuth;

public class Click_save extends Parent_Button{
	/**
	 * 
	 */ 
	
	final JTextField truck_Number;
 
	final Iobserver dataModelObserver;
	
	public Click_save(ImageIcon icon, String title,JTextField truck_Number,user user_,Iobserver dataModelObserver) {
		super(icon, title,user_); setText(title);this.truck_Number=truck_Number;  this.dataModelObserver=dataModelObserver;
		// TODO Auto-generated constructor stub
		setUser(user_); // to be used
	}

	

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		IProxy action=new ProxyAuth.Builder<JTextField>().setTruck_Number(truck_Number).build(this.user,this.truck_Number,actions.SaveTruck,dataModelObserver);
		boolean result=action.action();
	}

	 

}
