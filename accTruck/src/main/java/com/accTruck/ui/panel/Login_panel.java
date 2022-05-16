package com.accTruck.ui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.accTruck.listeners.Button_action_listener;
import com.users.user;

import observer.Logger;
import truck_scale.button.Login_Button;
import truck_scale.interfaces.getIcon;

public class Login_panel extends JPanel implements getIcon{

	

 
	private Login_panel(JFrame x){
		final	JLabel user_Lable,password_label;
		final	JTextField user_name;
		final 	JButton login_click ;
		final	JPasswordField password;
		final	ImageIcon icon;
		final 	JButton cancel_click ;
		icon= get_Icon("lock.png",new Logger());
		
		user_Lable=new JLabel("user name");
		password_label=new JLabel("Enter password");
		user_name=new JTextField(13);
		password=new JPasswordField(13);
		login_click=new Login_Button(icon, "Login",new user() ,x,  password,  user_name);
		cancel_click=new JButton("Cancel");
		
		  SpringLayout layout =  new SpringLayout(); 
		  layout.putConstraint(SpringLayout.WEST,  user_Lable,10,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, user_Lable,30,SpringLayout.NORTH, this);
	      
	      
	      layout.putConstraint(SpringLayout.WEST,  password_label,10,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, password_label,60,SpringLayout.NORTH, this);
	      
	      
	      layout.putConstraint(SpringLayout.WEST,  user_name,104,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, user_name,30,SpringLayout.NORTH, this);
	      
	      layout.putConstraint(SpringLayout.WEST,  password,104,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, password,60,SpringLayout.NORTH, this);
	      
	      layout.putConstraint(SpringLayout.WEST,  login_click,104,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, login_click,110,SpringLayout.NORTH, this);
	      
	      layout.putConstraint(SpringLayout.WEST,  cancel_click,10,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, cancel_click,110,SpringLayout.NORTH, this);
	      
	      this.setLayout(layout);
	      add(user_Lable);add(user_name);add(password);add(login_click);
	      add(password_label);add(cancel_click);
	      
	      login_click.addActionListener(new Button_action_listener.builder().build());
	      
	      
	      
	      cancel_click.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
	    	  
	      });
		 
	}
	
	
public  static class builder{
		
		public   Login_panel build(JFrame x){
		 
			return new Login_panel(x );
		}
	}
 
}
