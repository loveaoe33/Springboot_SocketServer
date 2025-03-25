package ObjectClass;

import java.util.HashMap;

public class RouterObject {
	public static RouterObject routerObject;
	private String headerRouer;
	private String lastRouter;
	private String router_Url="http://localhost:8080";

	private HashMap<String, String> routerList = new HashMap();

	public RouterObject() {
		setList();
	}

	public static RouterObject getInstance() {

		if (routerObject == null) {
			return routerObject = new RouterObject();
		} else {
			return routerObject;
		}
	}

	private void setList() {
		routerList.put("blockNew", "/EthereumController/View_Last_Brock");
		routerList.put("blockAll", "/EthereumController/View_Array_Block");
		routerList.put("contractAddress", "/EthereumController/Contract_Address");
		routerList.put("transLog", "/EthereumController/View_Transaction_Hash");
		routerList.put("nodeBalance", "/EthereumController/Check_Wallet");
		routerList.put("nodeWallet", "/EthereumController/Print_Wallet");
		routerList.put("approve_log", "/EthereumController/Contract_getUserApprovLog");
		routerList.put("admin_update_log", "/EthereumController/Contract_getAdminUpdatelog");
		routerList.put("transaction_log", "/EthereumController/Contract_getTransactionlog");

	}

	public String getRouterUrl(String Case) {
		return String.format("%d%d", router_Url,routerList.get(Case));
	}

	public String setRouterUrl() {

		return null;
	}


}
