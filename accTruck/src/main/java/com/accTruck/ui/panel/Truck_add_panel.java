package com.accTruck.ui.panel;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.TableModel;

import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Toolkit;

import truck_scale.button.Click_save;

import com.InputVerifier.MyInputVerifier;
import com.accTruck.listeners.Button_action_listener;
import com.users.user;

import jdbc.model.MyTableModel;
import observer.Iobservable;
import observer.Iobserver;

public class Truck_add_panel extends JPanel implements Iobserver{
	
final	JLabel truck_Lable,form_label;
final	JTextField truck_Number;
final 	JButton save_click ;
final	ImageIcon icon;
	
	JTable table ;
	
	public final ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	
	private Truck_add_panel(MyTableModel myData ) {
		form_label=new JLabel("Add Truck Form");
		truck_Lable=new JLabel("Enter Truck Plate number");
		truck_Number=new JTextField(15);
		icon= getIcon("save2.png");
		
		truck_Number.setInputVerifier(new MyInputVerifier());
		
		save_click=new Click_save(icon, "Save",truck_Number,new user() ,this);
		save_click.addActionListener(new Button_action_listener.builder().build());
		build_layout(myData);
		
	}
	private ImageIcon getIcon(String img) {
	 	 
		URL url=classloader.getResource(img);
		if(url==null) {
			url=classloader.getResource("resources/"+img);
		} 
		
		BufferedImage Bimg = null;
		try {
			Bimg = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	return new ImageIcon(Bimg);
}
	private void build_layout(MyTableModel myData) {
		
		  table = new JTable(myData);
		
		  SpringLayout layout =  new SpringLayout(); 
		  layout.putConstraint(SpringLayout.WEST,  form_label,10,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, form_label,40,SpringLayout.NORTH, this);
	      
		  layout.putConstraint(SpringLayout.WEST,  truck_Lable,20,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, truck_Lable,80,SpringLayout.NORTH, this);
	      
	      layout.putConstraint(SpringLayout.WEST,  truck_Number,180,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, truck_Number,80,SpringLayout.NORTH, this);
	     
	      JScrollPane scrollPane = new JScrollPane(table);
	      scrollPane.setPreferredSize(new Dimension(380,280));
	      
	      layout.putConstraint(SpringLayout.WEST,  scrollPane,180,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, scrollPane,200,SpringLayout.NORTH, this);
	      
	      layout.putConstraint(SpringLayout.WEST,  save_click,180,SpringLayout.WEST, this);  
	      layout.putConstraint(SpringLayout.NORTH, save_click,130,SpringLayout.NORTH, this);
	      
	      
	      this.setLayout(layout);
	      add(truck_Lable);add(truck_Number);add(form_label);add(save_click);add(scrollPane);
	      
	}
	
 
	
	public  static class builder{
		
		public static Truck_add_panel build(){
			MyTableModel myData = new MyTableModel.Builder().build("select * from truck");
			return new Truck_add_panel(myData);
		}
	}



	@Override
	public void update(String sms) {
		// TODO Auto-generated method stub
		 
		MyTableModel myData = new MyTableModel.Builder().build("select * from truck");
		table.setModel(myData); // effective command
	}



 
	 

}
