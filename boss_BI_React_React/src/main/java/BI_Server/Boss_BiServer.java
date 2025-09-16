package BI_Server;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import BI_Object.RequestData;
import JPA.Boss_BI_JPAController;

@Service
public class Boss_BiServer {

	private Boss_BI_JPAController jpaController;

	@Autowired
	public Boss_BiServer(Boss_BI_JPAController jpaController) {
		this.jpaController = jpaController;
	}

	public String compareCash(RequestData caseData) { // compare condition amount chart data
		HashMap<String, String> data = new HashMap<String, String>();
		switch (caseData.getCompareRadio()) {
		case "localYear":
//					 data=jpaController.data_Local_Compare(RequestData caseData);
			break;
		case "lastYear":
			break;
		case "otherYear":
			break;
		}

		return "";
	}

	public void getWeekCash() { // get week Operating amount temp

	}

	public String getInit_Amount() {// get year month local Operating amount temp

		return jpaController.getInit_Amount();

	}

	public String getLastYearCash() { // get year Operating amount temp
		return String.valueOf(jpaController.getLastYear_Amount("113"));
	}

	public String callCompareLast() throws JsonProcessingException {   //get compare local month &&  last year month amount 
		jpaController.callCompareLast();
		return "Sucess";
	}

	public String callRange() throws JsonProcessingException {
		jpaController.getRange("114", "1", "9");
		return "Sucess";
	}

}
