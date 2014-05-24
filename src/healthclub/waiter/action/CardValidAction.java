package healthclub.waiter.action;

import java.io.IOException;

import healthclub.member.action.BaseAction;
import healthclub.member.model.Users;
import healthclub.waiter.service.WaiterService;

public class CardValidAction extends BaseAction{
	private WaiterService waiterService;
	private String card;
	
	public String execute(){
		
		int id=-1;
		try {
			id=Integer.parseInt(card);
		} catch (Exception e) {
			// TODO: handle exception
			try {
				response.getWriter().print("N");
				return null;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		Users user=waiterService.getUser(id);
		if(user==null){
			try {
				response.getWriter().print("N");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				response.getWriter().print("Y");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
	
	

}
