package BI_Server;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import BI_Lib.BI_JudgeCase;
import BI_Object.RequestData;
import JPA.Boss_BI_JPAController;

@Service
public class Boss_BiServer {

	private Boss_BI_JPAController jpaController;
	private BI_JudgeCase bI_JudgeCase;

	@Autowired
	public Boss_BiServer(Boss_BI_JPAController jpaController,BI_JudgeCase bI_JudgeCase) {
		this.jpaController = jpaController;
		this.bI_JudgeCase=bI_JudgeCase;
	}

	public String compareCash(RequestData caseData) throws JsonProcessingException { // compare condition amount chart data
		HashMap<String, String> data = new HashMap<String, String>();
		switch (caseData.getCompareRadio()) {
		case "initData":
			getInit_Amount();
			break;
		case "localYear":      //year range data
//			callRange();
//					 data=jpaController.data_Local_Compare(RequestData caseData);
			break;
		case "lastYear":      //compare last year && same range
			callCompareLast(caseData);
			break;
		case "otherYear":     //compare last year
			break;
		}

		return "";
	}

	private void getWeekCash() { // get week Operating amount temp

	}

	private String getInit_Amount() {// get year month local Operating amount temp

		return jpaController.getInit_Amount();

	}

	private String getLastYearCash() { // get year Operating amount temp
		return String.valueOf(jpaController.getLastYear_Amount("113"));
	}

	private String callCompareLast(RequestData requestData) throws JsonProcessingException {   //get compare local month &&  last year month amount 
		String code=bI_JudgeCase.caseCheck(requestData);
		if(code.equals("11")) {
			System.out.println("進入1");
			jpaController.callCompareLast(requestData, code);
		}else {
			System.out.println("進入2");

			jpaController.callCompareLast(requestData, code);

		}
			
			
		return "Sucess";
	}

//	private String callRange() throws JsonProcessingException {  //get range data no compare
//		jpaController.getRange("114", "1", "9");
//		return "Sucess";
//	}
//	
//	
//	private String callRange_Compare() throws JsonProcessingException {  //get range data && compare
//		jpaController.getRange_Compare("114", "1", "9","113","1","9");
//		return "Sucess";
//	}

}
