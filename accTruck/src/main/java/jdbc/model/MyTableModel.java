package jdbc.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;

import javax.swing.table.AbstractTableModel;

import com.users.DB_Entity_enums;

import jdbc.ASingleton;
import observer.Iobservable;
import observer.Iobserver;
import observer.Logger;

public class MyTableModel extends AbstractTableModel   implements Iobservable {

	private MyTableModel() {};
	int _count=0,colum_count=0;
	private String[] columnNames ;
	private ArrayList<Truck> TruckList=new ArrayList<Truck> ();
	DB_Entity_enums DB_Entity;
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return _count;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colum_count;
	}
	  public String getColumnName(int col) {
	      return columnNames[col];
	   }
	@Override
	 public Object getValueAt(int row, int col) {
	      Object temp = null;
	      
	      switch (col) {
	      case 0:
	    	  temp = TruckList.get(row).getId();
	    	  break;
	      case 1:
	    	  temp = TruckList.get(row).getVehicleplate();
	    	  break;
	      case 2:
	    	  temp =   TruckList.get(row).getWeight() ;
	    	   
	    	  break;
	      case 3:
	    	  temp =  TruckList.get(row).getIddriver();
	    	  break;
	    	  
	      }
	  
	    
	      return temp;
	   }
 
	
	
	public static class Builder{
		
		
		public  MyTableModel build(String querry ) {
			MyTableModel data_model=new MyTableModel();
			data_model.attach(new Logger(),"logger");
			
			//String query="select * from truck" ;
			int count=0;
			try {
				ASingleton instance= ASingleton.getInstance();
				Connection connection=instance.poll();
				
				data_model.update("\n DB connection has polled ", "logger");
				Statement stmt=connection.createStatement();  
				ResultSet rs=stmt.executeQuery(querry);  
				data_model.update("\n DB executeQuery done ", "logger");
				ResultSetMetaData rsmd = rs.getMetaData();
				
				int columnsNumber = rsmd.getColumnCount();
				int counter=0;
				ArrayList<String> list_names_column = new ArrayList<String>();
				
				while(counter<columnsNumber) {
				counter++;
				list_names_column.add(rsmd.getColumnName(counter));
				}
				String[] columnNames = new String[list_names_column.size()];
				list_names_column.toArray(columnNames);
				
				data_model.update("\n DB we get column count : "+ counter, "logger");
				
				while(rs.next())  {
					Truck entity_Truck=new Truck();
				 	entity_Truck.setId(rs.getInt(1));
					entity_Truck.setVehicleplate(rs.getInt(2));
					entity_Truck.setWeight(rs.getInt(3));
					entity_Truck.setIddriver(rs.getInt(4));
			 
		 			data_model.TruckList.add(entity_Truck);
					count++;
				}
				data_model.update("\n DB we get row count : "+count, "logger");
				data_model._count=count;
				data_model.columnNames=columnNames;
				data_model.colum_count=columnsNumber;
				
				
				 instance.push(connection);
			} catch (ClassNotFoundException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			data_model.update("\n MyTableModel creation completed ", "logger");
			return data_model;
			
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
