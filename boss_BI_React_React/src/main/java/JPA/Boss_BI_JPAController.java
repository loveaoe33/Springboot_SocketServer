package JPA;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import BI_Lib.BI_RangeDate;
import BI_Object.QueryMethod;
import BI_Object.RangeData;
import BI_Object.RequestData;
import BI_Object.RangeData;
import jakarta.annotation.PostConstruct;

@Service
public class Boss_BI_JPAController {

	private Boss_BI_JPA_InitAmount_Interface boss_BI_InitAmount;
	private Boss_BI_JPA_SqlWhere_Interface boss_BI_SqlWhere;
	private BigInteger last_Year_Amount;
	private BigInteger thie_Year_Amount;
	private BigInteger thie_Year_SelfAmount;
	private BigInteger thie_Month_Amount;
	private BigInteger this_Local_Amount;
	private BI_RangeDate bi_RangeDate;
	private StringBuilder sb = new StringBuilder();
	private DecimalFormat formatter = new DecimalFormat("#,###.##");
	private QueryMethod query;
	private ObjectMapper mapper;
	@Autowired
	public Boss_BI_JPAController(Boss_BI_JPA_InitAmount_Interface boss_BI_InitAmount,
			Boss_BI_JPA_SqlWhere_Interface boss_BI_SqlWhere, BI_RangeDate bi_RangeDate, ObjectMapper mapper,QueryMethod query) {
		this.boss_BI_InitAmount = boss_BI_InitAmount;
		this.boss_BI_SqlWhere = boss_BI_SqlWhere;
		this.bi_RangeDate = bi_RangeDate;
		this.query=query;
		this.mapper = mapper;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		initAmount();
		timerCatch();
	}

	public void timerCatch() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		Runnable task = () -> {
			initLocalAmoint();
			System.out.println("收益更新時間：" + java.time.LocalDateTime.now());
		};

		scheduler.scheduleAtFixedRate(task, 0, 10, TimeUnit.MINUTES);

	}

	public void initAmount() {

		getLastYear_Amount(Integer.toString(bi_RangeDate.getYear() - 1));
		getThisYear_Amount(Integer.toString(bi_RangeDate.getYear()));
		getThie_Year_SelfAmount(Integer.toString(bi_RangeDate.getYear()));
		getThisMonth_Amount(bi_RangeDate.getMonth());
		getLocalDate_Amount(bi_RangeDate.getDateCombine());
	}

	public void initLocalAmoint() {

		getThisYear_Amount(Integer.toString(bi_RangeDate.getYear()));
		getThie_Year_SelfAmount(Integer.toString(bi_RangeDate.getYear()));
		getThisMonth_Amount(bi_RangeDate.getMonth());
		getLocalDate_Amount(bi_RangeDate.getDateCombine());
	}

	public BigInteger getLastYear_Amount(String Year) { // get this year last total
		return last_Year_Amount = boss_BI_InitAmount.getBilAmount(Year);

	}

	public void getThisYear_Amount(String Year) {
		thie_Year_Amount = boss_BI_InitAmount.getBilAmount(Year);
	}

	public void getThie_Year_SelfAmount(String Year) {
		thie_Year_SelfAmount = boss_BI_InitAmount.getSelfAmount(Year);
	}

	public void getThisMonth_Amount(String Month) {
		thie_Month_Amount = boss_BI_InitAmount.getBilAmount(Month);
	}

	public void getLocalDate_Amount(String Date) {
		this_Local_Amount = boss_BI_InitAmount.getBilAmount(Date);
	}

	public String getInit_Amount() {
		sb.setLength(0);
		sb.append(formatter.format(thie_Year_Amount)).append("_").append(formatter.format(thie_Month_Amount))
				.append("_").append(formatter.format(this_Local_Amount)).append("_")
				.append(formatter.format(last_Year_Amount)).append("_").append(formatter.format(thie_Year_SelfAmount));
		System.out.println(sb.toString());
		return sb.toString();
	}

	public HashMap<String, String> data_Local_Compare(RequestData caseData) { // localYear

		HashMap<String, BigInteger> compareData; // compareData
		return null;
	}

	public void getCompareLast(String caseIO) {

	}

	public void getCompareLast() {

	}

	public void getRange(RequestData requestData,String year, String startDate, String endDate,String code) throws JsonProcessingException { // all case &&
																											// all IO

		ArrayList<RangeData> jsonData = buildRangeData(requestData, year, Integer.valueOf(startDate), Integer.valueOf(endDate), code);
		System.out.println(mapper.writeValueAsString(jsonData));

	}

	public void getRange(RequestData requestData,String caseSelect, String caseIO, String year, String startDate, String endDate,String code)
			throws JsonProcessingException { // caseSelect && IO

		ArrayList<RangeData> jsonData = buildRangeData(requestData, year, Integer.valueOf(startDate), Integer.valueOf(endDate), code);
		System.out.println(mapper.writeValueAsString(jsonData));
	}

	public void getRange_Compare(RequestData requestData,String year, String startDate, String endDate, String compareYear,
			String compare_startDate, String compare_endDate,String code) throws JsonProcessingException { // all case && all IO

		ArrayList<RangeData> jsonData = buildRangeData(requestData, year, Integer.valueOf(startDate), Integer.valueOf(endDate), code);
		System.out.println(mapper.writeValueAsString(jsonData));

	}

	public void getRange_Compare(RequestData requestData,String caseSelect, String caseIO, String year, String startDate, String endDate,
			String compareYear, String compare_startDate, String compare_endDate,String code) throws JsonProcessingException { // all
																													// case
																													// &&
																													// all
																													// IO

		ArrayList<RangeData> jsonData = buildRangeData(requestData, year, Integer.valueOf(startDate), Integer.valueOf(endDate), code);
		System.out.println(mapper.writeValueAsString(jsonData));

	}

	public void callCompareLast(RequestData requestData,String code) throws JsonProcessingException {
																												
		String lastYear = String.valueOf(bi_RangeDate.getYear() - 1);
		String thisYear = String.valueOf(bi_RangeDate.getYear());
		String range = String.valueOf(bi_RangeDate.getLocalMonth());
		String io=requestData.getOuLldCase();
	    String caseSelect=requestData.getAmountCase();
		int startMonth = 1;
		int endMonth = Integer.parseInt(range.replace("0", ""));
		ArrayList<RangeData> jsonData = buildRangeData(requestData,lastYear, startMonth, endMonth, code);
		ArrayList<RangeData> jsonData2 = buildRangeData(requestData,thisYear, startMonth, endMonth,code);
		System.out.println(mapper.writeValueAsString(jsonData));
		System.out.println(mapper.writeValueAsString(jsonData2));
	}

//	public void callCompareLast() throws JsonProcessingException { // all case && all IO
//		String lastYear = String.valueOf(bi_RangeDate.getYear() - 1);
//		String thisYear = String.valueOf(bi_RangeDate.getYear());
//		String range = String.valueOf(bi_RangeDate.getLocalMonth());
//		int startMonth = 1;
//		int endMonth = Integer.parseInt(range.replace("0", ""));
//		ArrayList<RangeData> jsonData = buildRangeData(lastYear, startMonth, endMonth);
//		ArrayList<RangeData> jsonData2 = buildRangeData(thisYear, startMonth, endMonth);
//		System.out.println(mapper.writeValueAsString(jsonData));
//		System.out.println(mapper.writeValueAsString(jsonData2));
//	}
	
	
	public void callCompareLast_caseSelect(RequestData requestData,String code) throws JsonProcessingException { // all case && all IO
		String lastYear = String.valueOf(bi_RangeDate.getYear() - 1);
		String thisYear = String.valueOf(bi_RangeDate.getYear());
		String range = String.valueOf(bi_RangeDate.getLocalMonth());
		int startMonth = 1;
		int endMonth = Integer.parseInt(range.replace("0", ""));
		ArrayList<RangeData> jsonData = buildRangeData(requestData, lastYear, startMonth, endMonth, range);
		ArrayList<RangeData> jsonData2 = buildRangeData(requestData, thisYear, startMonth, endMonth, range);
		System.out.println(mapper.writeValueAsString(jsonData));
		System.out.println(mapper.writeValueAsString(jsonData2));
	}

	public ArrayList<RangeData> buildRangeData(RequestData requestData,String year, int startMonth, int endMonth,String code) {
		ArrayList<RangeData> list = new ArrayList<>();
		for (int i = startMonth; i <= endMonth; i++) {
			String monthStr = (i < 10 ? "0" + i : String.valueOf(i));
			String startDate = year + monthStr + "01";
			String endDate = year + monthStr + "31";

			RangeData data = RangeData.builder().keyMonth(i + "月")		
					.priceMonth(query.strategy(boss_BI_SqlWhere, requestData,startDate, endDate,code)).build();

			list.add(data);
		}
		return list;
	}

}
