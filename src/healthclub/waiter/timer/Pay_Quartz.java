package healthclub.waiter.timer;
import healthclub.waiter.service.WaiterService;
import healthclub.waiter.service.impl.WaiterServiceImpl;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
//import org.springframework.scheduling;
//import org.springframework.scheduling.backportconcurrent;
//import org.springframework.scheduling.concurrent;
//import org.springframework.scheduling.support;
//import org.springframework.scheduling.timer;

public class Pay_Quartz extends QuartzJobBean{
	private WaiterService waiterService;

	 protected void executeInternal(JobExecutionContext context)
		        throws JobExecutionException {
		      // TODO Auto-generated method stub
		      boolean res=waiterService.createAccount();
		      if(!res){
		    	  System.out.println("create account failed£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡");
		      }else{
		    	  System.out.println("create account sussess£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡");
		      }
		   }

	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}
	
	

}
