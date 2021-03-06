package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import observer.Iobservable;
import observer.Iobserver;
import observer.Logger;

public class ASingleton implements Iobservable{

	private static volatile ASingleton instance;
 	private static volatile LinkedList<Connection> connection_queue=new LinkedList<Connection>();
	private static Object   mutex = new Object();

	private ASingleton() { attach(new Logger(),"logger");}
	

	public static ASingleton getInstance() throws InterruptedException, ClassNotFoundException {
		//ASingleton result = instance;
		if (instance == null) {
			synchronized (mutex) {
				instance = instance;
				if (instance == null)
					instance = new ASingleton();
			 
				if(connection_queue.size()<=0) {
				int i=0;
				while( i<20) {
					connection_queue.add(getJDBC_Connection());
					i++;
			
					}
				
					instance.update("\n databased poll fullfilled by "+i, "logger");
			}
				
				}
		}
		return instance;
	}
	public synchronized Connection poll() {
		Connection	z_connection;
	
		if(connection_queue.size()>0) {
			instance.update("\n databased poll size is "+connection_queue.size(), "logger");
		 	z_connection=connection_queue.poll();
			instance.update("\n databased poll size is "+connection_queue.size(), "logger");
		 try {
			if( z_connection.isValid(1)) {
			return z_connection;
			}else {
				connection_queue.clear();
				int i=0;
				while( i<20) {
					try {
						connection_queue.add(getJDBC_Connection());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						instance.update("Exception is" + e.toString(), "logger");
						 
					}
					i++;
				 
					}
				 	z_connection=connection_queue.poll();
				instance.update("\n databased poll size is "+connection_queue.size(), "logger");
				return  z_connection;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			instance.update("Exception is" + e.toString(), "logger");
			e.printStackTrace();
		}
		}else {
			instance.update("\n databased poll size is "+connection_queue.size(), "logger");
			connection_queue.clear(); //vip important
			int i=0;
			while( i<20) {
				try {
					connection_queue.add(getJDBC_Connection());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					instance.update("Exception is" + e.toString(), "logger");
					e.printStackTrace();
				}
				i++;
			 
				}
			instance.update("\n databased poll size is "+connection_queue.size(), "logger");
			 	z_connection=connection_queue.poll();
			instance.update("\n databased poll size is "+connection_queue.size(), "logger");
	
		 
		}
		return z_connection;
	}
	
	public synchronized void  push(Connection connection) {
		connection_queue.push(connection); 
		instance.update("\n databased poll pushed ", "logger");
		instance.update("\n databased poll size is "+connection_queue.size(), "logger");
	}
	private static Connection getJDBC_Connection() throws ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");  
	//	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","");  
	/*	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionUrl =
                "jdbc:sqlserver://10.0.12.55\\dev;"
                        + "databaseName=reporting;"
                        + "user=sa;"
                        + "password=P@ssw0rd;"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "hostNameInCertificate = any;"
                        + "trustStore = any;"
                        + "trustStorePassword = any;"
                        + "loginTimeout=30;";
 */
	        Connection connectionDB_instance=null;;
	      
	        try {
	        	connectionDB_instance =DriverManager.getConnection("jdbc:mysql://localhost:3306/acctruck","root","");
	    		instance.update("\n Connection created ", "logger");
	        }
	        // Handle any errors that may have occurred.
	        catch (Exception e) {
	        	instance.update("Exception is" + e.toString(), "logger");
	            e.printStackTrace();
	            
	        }
	        instance.update("\n connectionDB_instance  create correctlly" , "logger");
		return connectionDB_instance;
		  
	}
 // 109469   109309 			mohamed mohsen     109469
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
			 ASingleton instance= ASingleton.getInstance();
			 instance.poll();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				instance.update("Exception is" + e.toString(), "logger");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				instance.update("Exception is" + e.toString(), "logger");
				e.printStackTrace();
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
