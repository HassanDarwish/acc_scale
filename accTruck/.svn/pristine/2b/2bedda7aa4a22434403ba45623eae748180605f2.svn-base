package truck_scale.button;


import javax.swing.JPanel;

import com.accTruck.ui.MainFrame;
import com.accTruck.ui.panel.Matrial_add_panel;
import com.accTruck.ui.panel.Truck_Read_Balance_panel;
import com.accTruck.ui.panel.Truck_add_panel;
import com.users.MenuBar_enums;

public class My_JMenuItem extends Parent_JMenuItem {

	MainFrame frame;MenuBar_enums panelid;
	//final static SortedMap<com.enums.panels, JPanel> panels = new TreeMap<com.enums.panels, JPanel>();
	private My_JMenuItem(String string,MainFrame frame,MenuBar_enums panelid) {
		// TODO Auto-generated constructor stub
		super(string);
		this.panelid=panelid;
		this.frame=frame;
	}

	@Override
	public void Execute() {
		JPanel T1=null;
		// TODO Auto-generated method stub
		frame.clear_Frame_from_panel();
	 
	 		switch (panelid) {
	 		case Truck_add_panel:
	 		 
	 	 
	 			  T1=Truck_add_panel.builder.build();
	 			 
	 		break;
	 		case Truck_Read_Balance_panel: 
	 			  
		 			  T1=Truck_Read_Balance_panel.builder.build();
		 			 
	 		break;
	 		case Matrial_add_panel:
	 			 
	 			  T1=Matrial_add_panel.builder.build();
	 			 
	 		break;
	 		}
	 		
	 		
	 		frame.setPanel(T1);
        
	 
	}
	public static class builder {
		public	 My_JMenuItem build(String string,MainFrame frame,MenuBar_enums panelid) {
		 return new My_JMenuItem(  string,  frame,  panelid);
		}}
	 

}
