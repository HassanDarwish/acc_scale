package com.accTruck.ui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.accTruck.listeners.Button_action_listener;
import com.accTruck.listeners.MainFrame_listener;
import com.users.MenuBar_enums;

import truck_scale.button.My_JMenuItem;
import truck_scale.interfaces.getIcon; 

public class MainFrame extends JFrame implements getIcon{
	
	private JPanel currentPanell=null ;
	public static com.users.user user;
	 
/*
	public JPanel getCurrentPanell() {
		return currentPanell;
	}*/
	public void setCurrentPanell(JPanel currentPanell) {
		this.currentPanell = currentPanell;
	}

	/**
	 * 
	 */ 


	private MainFrame() {
		set_listeners();
		 
		buid_GUI() ;
	}
	private void  set_listeners() {
		addWindowListener(MainFrame_listener.builder.build());
	}
	private void  buid_GUI() {
		
		add_MenuBar();
     	setSize(800,600);
		
     	java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
		
		/*
		 Read_Balance reader1 =  new Read_Balance(get_Icon("shipped2.png"), "reader from 10.0.6.64", "10.0.6.64");
		 add(reader1);
		*/
		
		//
	// 	add (Truck_add_panel.builder.build());
		//
		setVisible(true);
	}
	
public void setPanel(JPanel T1) {
	clear_Frame_from_panel();
	 getContentPane().add(T1);
     invalidate();
     validate();
     setCurrentPanell(T1);
}
	
 public void clear_Frame_from_panel() {
	 
	  
	 if(currentPanell!=null) {
		getContentPane().remove(currentPanell);
		invalidate();
		 validate();
	 }
 }
 
	
	private void add_MenuBar() {
		// TODO Auto-generated method stub
 JMenuItem i1, i2, i3, i4, i5, report_menu_truck, report_menu_weight,add_Matrial;  
	     
		 JMenuBar mb=new JMenuBar();  
		 JMenu menu=new JMenu("Trucks");  JMenu menu_Matrial=new JMenu("Matrial");  
		 JMenu   submenu=new JMenu("Weight And Balance"); 
		  i1=new My_JMenuItem.builder().build("Add Truck",this,MenuBar_enums.Truck_add_panel);  i1.addActionListener(new Button_action_listener.builder().build());
          i2=new My_JMenuItem.builder().build("Remove Truck",this,MenuBar_enums.Truck_Read_Balance_panel);  i2.addActionListener(new Button_action_listener.builder().build());
          
          i3=new JMenuItem("List Trucks");  
          i4=new JMenuItem("Truck Weight And Balance");  
          i5=new JMenuItem("Add Balance");  
          
          add_Matrial=new My_JMenuItem.builder().build("Add Matrial",this,MenuBar_enums.Matrial_add_panel); 
          add_Matrial.addActionListener(new Button_action_listener.builder().build());
          
          menu_Matrial.add(add_Matrial);
          
          menu.add(i1); 
          menu.add(i2); 
          menu.add(i3);  
          submenu.add(i4); 
          submenu.add(i5);  
          menu.add(submenu);  
         
          report_menu_truck=new JMenuItem("report_truck");  
          report_menu_weight=new JMenuItem("report_weight"); 
          
          
          JMenu menu_reports=new JMenu("Reports"); 
          menu_reports.add(report_menu_truck);
          menu_reports.add(report_menu_weight);
          mb.add(menu); mb.add(menu_Matrial);
          mb.add(menu_reports);  
           
          setJMenuBar(mb);  
	}

	public static class builder {
		public	static void build() {
		  new MainFrame();
		}
	}
	
	
	
}
