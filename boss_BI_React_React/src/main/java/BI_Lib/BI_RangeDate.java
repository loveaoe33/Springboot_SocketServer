package BI_Lib;

import java.time.LocalDate;

import org.springframework.stereotype.Component;



public class BI_RangeDate {

	private LocalDate today = LocalDate.now();
	private int ProcBorn = 1911;
	private StringBuilder sb=new StringBuilder();

	public BI_RangeDate() {

	}

	public int getYear() {
		return today.getYear()-ProcBorn;
	}
	


	public String getMonth() { // get range month
	    sb.setLength(0); // clear string
		String Month=String.format("%02d", today.getMonthValue());
        sb.append(today.getYear()-ProcBorn).append(Month);
		return sb.toString();
	}
	
	
	public String getDateCombine() {
	    sb.setLength(0); // clear string
		String month=String.format("%02d", today.getMonthValue());
		String day=String.format("%02d", today.getDayOfMonth());
        sb.append(today.getYear()-ProcBorn).append(month).append(day);
		return sb.toString();
	}

	public void getWeek() { // get Range Week

	}

	public void getSeason() { // get Range Season

	}

}
