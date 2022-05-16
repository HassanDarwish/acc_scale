package truck_scale.button;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

import com.enums.actions;
import com.users.user; 

import observer.Iobserver;
import proxyAction.IProxy;
import proxyAction.ProxyAuth;

public class Click_save_matrail  extends Parent_Button{

	
	final JTextField matrial_title;
 
	final Iobserver dataModelObserver;
	
	public Click_save_matrail(ImageIcon icon, String title,JTextField truck_Number,user user_,Iobserver dataModelObserver) {
		super(icon, title,user_); setText(title);this.matrial_title=truck_Number;  this.dataModelObserver=dataModelObserver;
	 
		setUser(user_); // to be used
	 
		
		 }

	@Override
	public void Execute() {
	 
		IProxy action=new ProxyAuth.Builder<JTextField>().build(user,this.matrial_title,actions.SaveMatrial,dataModelObserver);
		boolean result=action.action();
	}

}
