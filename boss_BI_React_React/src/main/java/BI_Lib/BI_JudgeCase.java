package BI_Lib;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import BI_Object.RequestData;
import BI_Object.date_Condition;
import jakarta.validation.constraints.AssertFalse.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class BI_JudgeCase {
	public BI_JudgeCase() {
		
		
	}
	private StringBuilder sb = new StringBuilder();
	public String caseCheck(RequestData requestData) {
		System.out.println("case:"+requestData.getAmountCase());

		switch (requestData.getAmountCase()) {

		case "健保/自費":
			return caseSelect("1",requestData.getOuLldCase());
		case "健保應收":
			return caseSelect("2",requestData.getOuLldCase());
		case "自費實收":
			return caseSelect("3",requestData.getOuLldCase());
		}
		return "none";
	}

	public String sqlWhereCheck(ArrayList datas) {
		for (int i = 0; i < datas.size(); i++) {
			if (datas.get(i).equals("無")) {

				return "none";
			} else {

				sb.append(datas.get(i)).append(",");
			}

		}
		return sb.toString();

	}

	private String caseSelect(String caseAmount,String ouldCase) {

		switch (ouldCase) {
		case "門診/住院":
			return caseAmount+ "1";
		case "門診":
			return caseAmount+ "2";
		case "住院":
			return caseAmount+ "3";
		}
		return "none";
	}

}
