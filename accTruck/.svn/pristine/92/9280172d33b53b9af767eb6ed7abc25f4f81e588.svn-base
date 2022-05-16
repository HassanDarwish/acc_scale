package com.accTruck.ui.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Truck_Read_Balance_panel extends JPanel{

	final		JLabel truck_Lable;
	final	JTextField truck_Number;
	
	private Truck_Read_Balance_panel() {
		
		truck_Lable=new JLabel("Enter Truck Balance");
		truck_Number=new JTextField(15);
		build_layout();
		
	}
	
	private void build_layout() {
		
		  SpringLayout layout =  new SpringLayout(); 
		  layout.putConstraint(SpringLayout.WEST,  truck_Lable,10,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, truck_Lable,40,SpringLayout.NORTH, this);
	      
	      layout.putConstraint(SpringLayout.WEST,  truck_Number,20,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, truck_Number,80,SpringLayout.NORTH, this);
	      
	      this.setLayout(layout);
	      add(truck_Lable);add(truck_Number);
	      
	}
	
 
	
	public static  class builder{
		
		public static Truck_Read_Balance_panel build(){
			return new Truck_Read_Balance_panel();
		}
	}

}

