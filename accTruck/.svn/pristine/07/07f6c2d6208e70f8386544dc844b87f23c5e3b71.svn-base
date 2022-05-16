package com.accTruck.ui.panel;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.InputVerifier.MyInputVerifier;
import com.accTruck.listeners.Button_action_listener;
import com.users.user;

import jdbc.model.MatrialTableModel;
 
import observer.Iobserver;
import observer.Logger;
import truck_scale.button.Click_save;
import truck_scale.button.Click_save_matrail;
import truck_scale.interfaces.getIcon;

public class Matrial_add_panel extends JPanel implements getIcon  , Iobserver{
	JLabel matrail_Lable,form_label;
	JTextField matrial_title;
	JButton save_click ;
	ImageIcon icon;
	
	JTable table ;
	
	public final ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	private Matrial_add_panel(MatrialTableModel myData ) {
		form_label=new JLabel("Add material Form");
		matrail_Lable=new JLabel("Enter material name");
		matrial_title=new JTextField(15);
		icon= get_Icon("save2.png",new Logger());
		
		matrial_title.setInputVerifier(new MyInputVerifier());
		
		save_click=new Click_save_matrail(icon, "Save",matrial_title,new user() ,this);
		save_click.addActionListener(new Button_action_listener.builder().build());
		build_layout(myData);
		
		
	}
	
	private void build_layout(MatrialTableModel myData) {
		
		  table = new JTable(myData);
		
		  SpringLayout layout =  new SpringLayout(); 
		  layout.putConstraint(SpringLayout.WEST,  form_label,10,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, form_label,40,SpringLayout.NORTH, this);
	      
		  layout.putConstraint(SpringLayout.WEST,  matrail_Lable,20,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, matrail_Lable,80,SpringLayout.NORTH, this);
	      
	      layout.putConstraint(SpringLayout.WEST,  matrial_title,180,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, matrial_title,80,SpringLayout.NORTH, this);
	     
	      JScrollPane scrollPane = new JScrollPane(table);
	      scrollPane.setPreferredSize(new Dimension(380,280));
	      
	      layout.putConstraint(SpringLayout.WEST,  scrollPane,180,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, scrollPane,200,SpringLayout.NORTH, this);
	      
	      layout.putConstraint(SpringLayout.WEST,  save_click,180,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, save_click,130,SpringLayout.NORTH, this);
	      
	      
	      this.setLayout(layout);
	      add(matrail_Lable);add(matrial_title);add(form_label);add(save_click);add(scrollPane);
	      
	}
	
	public  static class builder{
		
		public static Matrial_add_panel build(){
			MatrialTableModel myData = new MatrialTableModel.Builder().build("select * from matrial");
			return new Matrial_add_panel(myData);
		}
	}

	@Override
	public void update(String sms) {
		// TODO Auto-generated method stub
		 
		MatrialTableModel myData = new MatrialTableModel.Builder().build("select * from matrial");
		table.setModel(myData); // effective command
	}
}
