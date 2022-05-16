package proxyAction;

import com.accTruck.ui.MainFrame;

public class LoginAction implements IProxy {

	@Override
	public boolean action() {
		// TODO Auto-generated method stub
		MainFrame.builder.build();
		return false;
	}

}
