package com.accTruck.ui;

import javax.swing.JFrame;

import com.accTruck.listeners.MainFrame_listener;
import com.accTruck.ui.panel.Login_panel;

import truck_scale.interfaces.getIcon;

public class loginFrame extends JFrame implements getIcon{

	
	private loginFrame() {
		 
			buid_GUI() ;
		}
		private void  set_listeners() {
			addWindowListener(MainFrame_listener.builder.build());
		}
		private void  buid_GUI() {
			
		 
	     	setSize(250,170);
			
	     	java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
			
			add(new Login_panel.builder().build(this));
			setUndecorated(true);
			setVisible(true);
		}
	
	
	
	public static class builder {
		public	static void build() {
		  new loginFrame();
		}
	}
	
}
