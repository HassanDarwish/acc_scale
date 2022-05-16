package proxyAction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.InputVerifier.MyInputVerifier;
import com.users.user; 

import jdbc.ASingleton;
import observer.Iobservable;
import observer.Iobserver;
import observer.Logger;
import truck_scale.interfaces.ITextFiled;

public class SaveTruckAction<T> implements IProxy ,Iobservable{

private final user user;
private final JTextField truck_Number;
	
	private SaveTruckAction(user user,T truck_Number,Iobserver dataModelObserver) {
		 attach(new Logger(),"logger");
		 attach(dataModelObserver,"dataModelObserver");
		this.user=user;this.truck_Number=(JTextField) truck_Number;
	}
	
	@Override
	public boolean action() {
		// TODO Auto-generated method stub
		MyInputVerifier inputVerifier = new MyInputVerifier();
		if (inputVerifier.verify(truck_Number)   ){
            JOptionPane.showMessageDialog(null, "Right Value", "Information ",JOptionPane.INFORMATION_MESSAGE);
            try {
    			ASingleton jdbc=ASingleton.getInstance();
				Connection con=jdbc.poll();
				Statement stmt=con.createStatement();  
				String car_license_number=truck_Number.getText();
				String sql = "INSERT INTO  truck(vehicleplate,weight,iddriver) VALUES ( "+car_license_number+" ,0,0)";
 			   stmt.executeUpdate(sql);
			   jdbc.push(con);
			   update("we saved truck at :"+new Timestamp(System.currentTimeMillis()),"logger");
			   update("dataModelObserver  update data model at :"+new Timestamp(System.currentTimeMillis()),"dataModelObserver");
			   
			   JOptionPane.showMessageDialog(null, "saved correctly", "Information ",JOptionPane.INFORMATION_MESSAGE);
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
            
            
            return true;
        }else {
        	JOptionPane.showMessageDialog(null, "Wrong Value", "Warning ",JOptionPane.WARNING_MESSAGE);
        	truck_Number.setText("");
        }
		
		 
		truck_Number.setText("");
		return false;
	}
	public static class Builder<T> implements ITextFiled {
		 

		public SaveTruckAction<T> build(user user, T truck_Number,Iobserver dataModelObserver) {
			return new SaveTruckAction<T>(user,truck_Number,  dataModelObserver);
		}
		
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
