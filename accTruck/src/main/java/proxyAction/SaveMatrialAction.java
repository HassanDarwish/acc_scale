package proxyAction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.InputVerifier.MyInputStringVerifier;
import com.InputVerifier.MyInputVerifier;
import com.users.user; 
import jdbc.ASingleton;
import observer.Iobservable;
import observer.Iobserver;
import observer.Logger;
import truck_scale.interfaces.ITextFiled;

public class SaveMatrialAction <T> implements IProxy ,Iobservable{

private user user;private JTextField matrial;
	
	private SaveMatrialAction(user user,T matrial,Iobserver dataModelObserver) {
		 attach(new Logger(),"logger");
		 attach(dataModelObserver,"dataModelObserver");
		this.user=user;this.matrial=(JTextField) matrial;
	}
	
	public static class Builder<T> implements ITextFiled {
		 

		public SaveMatrialAction<T> build(user user, T truck_Number,Iobserver dataModelObserver) {
			return new SaveMatrialAction<T>(user,truck_Number,  dataModelObserver);
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

	@Override
	public boolean action() {
		// TODO Auto-generated method stub
		MyInputStringVerifier inputVerifier = new MyInputStringVerifier();
		if (inputVerifier.verify(matrial)   ){
            JOptionPane.showMessageDialog(null, "Right Value", "Information ",JOptionPane.INFORMATION_MESSAGE);
            try {
    			ASingleton jdbc=ASingleton.getInstance();
				Connection con=jdbc.poll();
				Statement stmt=con.createStatement();  
				String matrial_name=matrial.getText();
				String sql = "INSERT INTO  matrial(title) VALUES ( '"+matrial_name+"' )";
			 
			 
 			   stmt.executeUpdate(sql);
		 
			   update("we saved matrail at :"+new Timestamp(System.currentTimeMillis()),"logger");
			   update("dataModelObserver  update data model at :"+new Timestamp(System.currentTimeMillis()),"dataModelObserver");
			   
			   JOptionPane.showMessageDialog(null, "saved correctly", "Information ",JOptionPane.INFORMATION_MESSAGE);
			   jdbc.push(con);
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
        	JOptionPane.showMessageDialog(null, "it is wrong  Value", "Warning ",JOptionPane.WARNING_MESSAGE);
        	matrial.setText("");
        }
		
		 
		matrial.setText("");
		return false;
	}

}
