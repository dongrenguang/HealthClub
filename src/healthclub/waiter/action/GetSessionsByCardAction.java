package healthclub.waiter.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import healthclub.member.action.BaseAction;
import healthclub.member.model.Session1;
import healthclub.waiter.service.WaiterService;

public class GetSessionsByCardAction extends BaseAction {
	
	private WaiterService waiterService;
	private int card;
	
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    String sessionUsername=(String) session.getAttribute("username_waiter");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		ArrayList<Session1> orderedAct=new ArrayList<Session1>();
		orderedAct=waiterService.getOrderedAct(card);
		
		ArrayList<String> orderSessionStrings=new ArrayList<String>();
		for(int i=0;i<orderedAct.size();i++){
			Session1 session1=orderedAct.get(i);
			String sessionString="";
//			sessionString=session1.getTheme()+" ; "+session1.getTime().toString()+" ; "
//					+session1.getLocation()+
			
		}
		return "Sessions";
	}

	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}



}
