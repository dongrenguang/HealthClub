package healthclub.waiter.timer;

import healthclub.member.assist.Assist;
import healthclub.waiter.service.WaiterService;

import java.util.Calendar;
import java.util.TimerTask;

public class Pay extends TimerTask{
	WaiterService waiterService;
	
	public Pay(){
		
	}
	
	public void run(){
		String date=Assist.getNowDateTime();
		//System.out.println(date);
//		System.out.println(waiterService);
//		waiterService.createAccount();
	}

	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}
	
}
