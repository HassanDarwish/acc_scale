package truck_scale.button;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.accTruck.ui.MainFrame;

import jdbc.ASingleton;
import observer.Iobservable;
import observer.Iobserver;
import observer.Logger;

public class Login_Button extends Parent_Button implements Iobservable{
JFrame y;
JPasswordField password_;
JTextField username;

	public Login_Button(ImageIcon icon, String title, com.users.user user_,JFrame x,JPasswordField password,JTextField user_name) {
		super(icon, title, user_);
		 attach(new Logger(),"logger");
		// TODO Auto-generated constructor stub
		this.setText(title);this.username=user_name;this.password_=password;
		y=x;
	}

	@Override
	public void Execute() {
		com.users.user  U = null;
		// TODO Auto-generated method stub
		y.dispose();
		String user_name=username.getText();
		String password= new String(password_.getPassword());
		
		ASingleton jdbc;
		try {
			jdbc = ASingleton.getInstance();
			Connection con=jdbc.poll();
			Statement stmt=con.createStatement();  
		 
			ResultSet rs = stmt.executeQuery("SELECT * from user where username='"+user_name+"' and password='"+password+"'");
			while (rs.next()) {
				   update("login by user '"+user_name +"' at :"+new Timestamp(System.currentTimeMillis()),"logger");
				   U=new com.users.user();
				    U.setName(rs.getString("username"));
				    U.setPassword(rs.getString("password"));
				    U.setAuthRole(rs.getString("role"));
				     
				  
				}
			
			jdbc.push(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		MainFrame.user=U;
		
		MainFrame.builder.build();
		
		
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
