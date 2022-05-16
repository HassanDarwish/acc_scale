package truck_scale.button;

import javax.swing.ImageIcon;

import com.accTruck.ui.MainFrame;
import com.users.user;

import truck_scale.truck_scale;

public class Read_Balance   extends Parent_Button {

	private	 String ip_address=null;
	private		String unit="";
	private	String value="";
	private MainFrame window;
	
 
	public Read_Balance(ImageIcon icon,String title,String ip,user user_) {
		super(icon, title,user_);
		//super(null,title);
		
		  this.ip_address=ip;
		// TODO Auto-generated constructor stub
		setToolTipText(title);
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		truck_scale udpclient= new truck_scale.Builder().setHostname(ip_address).setPort(11020).setHex("3c717565726965733e3c717565727920726571753d2272656d646973702220747970653d222a222077703d2241222f3e3c2f717565726965733e").build();
    	
		System.out.print(getToolTipText()+""+ip_address);
		try {
			udpclient.getWieght();
			unit=udpclient.getUnit();
			value=Float.toString(udpclient.getValue()); 
			
			//window.label.setText(value+"  "+unit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MainFrame getWindow() {
		return window;
	}

	public void setWindow(MainFrame window) {
		this.window = window;
	}

	 

}
