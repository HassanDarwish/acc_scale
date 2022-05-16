package truck_scale.button;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.users.user;

import truck_scale.interfaces.Command;
 

public abstract class Parent_Button  extends JButton implements Command{

	
	
	String Title;
	public   final user user = new user();
	public Parent_Button(ImageIcon icon,String title,user user_) {
		
		// TODO Auto-generated constructor stub
		 super(icon);
		 Title=title;
		 setUser(user_);
	}
	public void setUser(user user_) {
		user.setAuthRole(user_.getAuthRole());
		user.setName(user_.getName());
		user.setPassword(user_.getPassword());
	}
}
