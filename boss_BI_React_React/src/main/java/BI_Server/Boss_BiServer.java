package BI_Server;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import BI_Lib.BI_JudgeCase;
import BI_Object.RequestData;
import JPA.Boss_BI_JPAController;

@Service
public class Boss_BiServer {

	private Boss_BI_JPAController jpaController;
	private BI_JudgeCase bI_JudgeCase;
	private ObjectMapper mapper;

	@Autowired
	public Boss_BiServer(Boss_BI_JPAController jpaController, BI_JudgeCase bI_JudgeCase, ObjectMapper mapper) {
		this.jpaController = jpaController;
		this.bI_JudgeCase = bI_JudgeCase;
		this.mapper = mapper;
	}

	public String compareCash(RequestData caseData) throws JsonProcessingException { // compare condition amount chart
																						// data
		HashMap<String, String> data = new HashMap<String, String>();
		switch (caseData.getCompareRadio()) {
		case "initData":
			return getInit_Amount();
		case "localYear": // year range data
			return callRange(caseData);
//					 data=jpaController.data_Local_Compare(RequestData caseData);
		case "lastYear": // compare last year && same range
			return callCompareLast(caseData);
		case "otherYear": // compare last year
			return callRangeCompare(caseData);
		}

		return "fail";
	}

	private void getWeekCash() { // get week Operating amount temp

	}

	private String getInit_Amount() {// get year month local Operating amount temp

		return jpaController.getInit_Amount();

	}

	private String getLastYearCash() { // get year Operating amount temp
		return String.valueOf(jpaController.getLastYear_Amount("113"));
	}

	private String callCompareLast(RequestData requestData) throws JsonProcessingException { // get compare local month
																								// && last year month
																								// amount
		String code = bI_JudgeCase.caseCheck(requestData);
		return jpaController.callCompareLast(requestData, code);

	}

	private String callRangeCompare(RequestData requestData) throws JsonProcessingException {
		requestData.getCompareType().normalizeDates();
		String code = bI_JudgeCase.caseCheck(requestData);
		return jpaController.callRangeCompare(requestData, code);

	}

	private String callRange(RequestData requestData) throws JsonProcessingException { // get range data no compare
		String code = bI_JudgeCase.caseCheck(requestData);
		System.out.print("code" + code);

		return jpaController.getRange(requestData, "", requestData.getCompareType().getStartDate(),
				requestData.getCompareType().getEndDate(), code);
	}

//	private String callRange_Compare() throws JsonProcessingException {  //get range data && compare
//		jpaController.getRange_Compare("114", "1", "9","113","1","9");
//		return "Sucess";
//	}

}
