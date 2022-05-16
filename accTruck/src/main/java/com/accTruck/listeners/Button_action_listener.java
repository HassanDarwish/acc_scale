package com.accTruck.listeners;

import java.awt.event.ActionEvent;

import truck_scale.interfaces.Command;

public class Button_action_listener implements java.awt.event.ActionListener {
	 
	private Button_action_listener() {
		
	}
 	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Command obj = (Command) e.getSource();
	    obj.Execute();
	}
	public static class builder {
		public	 Button_action_listener build() {
		 return new Button_action_listener();
		}
	 
	}
	 
	 

}
