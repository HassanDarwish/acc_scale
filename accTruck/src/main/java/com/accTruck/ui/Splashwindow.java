package com.accTruck.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
 

public class Splashwindow  extends JWindow implements ActionListener {

	
	
	 public Splashwindow() {

	        setSize(199, 79);
	        setLayout(new BorderLayout());
	         
	        
	        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	        int y = (int) ((dimension.getHeight() -getHeight()) / 2);
	        setLocation(x, y);
	        
	        
	        
	    	ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	   // 	JOptionPane.showMessageDialog(this,"Hello, Welcome to Javatpoint.");
	  
	    	try {
	     	
	    		
	    		URL url=classloader.getResource("logo.png");
	    		if(url==null) {
	    			url=classloader.getResource("resources/logo.png");
	    			
	    		} 
	    		 
				BufferedImage img = ImageIO.read(url);
	  	
	    	
	    	JLabel background = new JLabel(new ImageIcon(img));
	    	
			this.add(background);
	    	} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

				 
			}
	        
	        setVisible(true);
	        toFront();
	      //  JOptionPane.showMessageDialog(this,"Hello, Welcome to Javatpoint."); 
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	   //MainFrame.builder.build();
	        loginFrame.builder.build();
	        this.dispose();
	        
	    }
	 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	    System.exit(0);
	}
	  private   WindowListener closeWindow = new WindowAdapter(){
	        public void windowClosing(WindowEvent e){
	            e.getWindow().dispose();
	        }
	    };
}
// notes 
/*

frame.getContentPane().remove(partnerSelectionPanel);
frame.add(new JPanel());
frame.getContentPane().invalidate();
frame.getContentPane().validate();

*/