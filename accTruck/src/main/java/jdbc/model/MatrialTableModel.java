package jdbc.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;

import javax.swing.table.AbstractTableModel;

import jdbc.ASingleton;
import observer.Iobservable;
import observer.Iobserver;
import observer.Logger;

public class MatrialTableModel extends AbstractTableModel   implements Iobservable {

	private MatrialTableModel() {};
	int _count=0,colum_count=0;
	private String[] columnNames ;
	private ArrayList<Matrial> MatrialList=new ArrayList<Matrial> ();
	
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
	    	  temp = MatrialList.get(row).getId();
	    	  break;
	      case 1:
	    	  
	    	  temp = MatrialList.get(row).getTitle();
	    	  break;
	     
	      }
	  
	    
	      return temp;
	   }

	
	public static class Builder{
		
		
		public  MatrialTableModel build(String querry ) {
			MatrialTableModel data_model=new MatrialTableModel();
			data_model.attach(new Logger(),"logger");
			
			//String query="select * from matrial" ;
			int count=0;
			try {
				ASingleton instance= ASingleton.getInstance();
				Connection connection=instance.poll();
				
				data_model.update("\n DB MatrialTableModel connection has polled ", "logger");
				Statement stmt=connection.createStatement();  
				ResultSet rs=stmt.executeQuery(querry);  
				data_model.update("\n DB MatrialTableModel executeQuery done ", "logger");
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
				
				data_model.update("\n DB MatrialTableModel get column count : "+ counter, "logger");
				
				while(rs.next())  {
					Matrial entity_Matrial=new Matrial();
					entity_Matrial.setId(rs.getInt(1));
				 	entity_Matrial.setTitle(rs.getString(2));
 		 			data_model.MatrialList.add(entity_Matrial);
					count++;
				}
				data_model.update("\n DB MatrialTableModel get row count : "+count, "logger");
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
			data_model.update("\n MatrialTableModel creation completed ", "logger");
		 
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
