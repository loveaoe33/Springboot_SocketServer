package JPA;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
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
	private DecimalFormat formatter;
	private QueryMethod query;
	private ObjectMapper mapper;

	@Autowired
	public Boss_BI_JPAController(Boss_BI_JPA_InitAmount_Interface boss_BI_InitAmount,
			Boss_BI_JPA_SqlWhere_Interface boss_BI_SqlWhere, BI_RangeDate bi_RangeDate, ObjectMapper mapper,
			QueryMethod query, DecimalFormat formatter) {
		this.boss_BI_InitAmount = boss_BI_InitAmount;
		this.boss_BI_SqlWhere = boss_BI_SqlWhere;
		this.bi_RangeDate = bi_RangeDate;
		this.query = query;
		this.mapper = mapper;
		this.formatter = formatter;
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

	public String getRange(RequestData requestData, String year, String startDate, String endDate, String code)
			throws JsonProcessingException { // all case &&
		// all IO

//		bi_RangeDate
		String[] startDates = startDate.split("-");
		String[] endDates = endDate.split("-");
		String startYear = startDates[0];
		String endYear = endDates[0];
		System.out.println("startYear:" + startDates[0] + "endYear" + startDates[1]);

		if (startYear.equals(endYear)) {
			ArrayList<RangeData> jsonData = buildRangeData(requestData, bi_RangeDate.getProceeYear(startYear),
					Integer.valueOf(startDates[1]), startDates[1] + startDates[2], Integer.valueOf(endDates[1]),
					endDates[1] + endDates[2], code);

			return (jsonData != null) ? mapper.writeValueAsString(jsonData) : "none";

		} else {
			return "fail";
		}

	}

	public void getRange(RequestData requestData, String caseSelect, String caseIO, String year, String startDate,
			String endDate, String code) throws JsonProcessingException { // caseSelect && IO

		ArrayList<RangeData> jsonData = buildRangeData(requestData, year, Integer.valueOf(startDate), "",
				Integer.valueOf(endDate), "", code);
		System.out.println(mapper.writeValueAsString(jsonData));
	}

	public void getRange_Compare(RequestData requestData, String year, String startDate, String endDate,
			String compareYear, String compare_startDate, String compare_endDate, String code)
			throws JsonProcessingException { // all case && all IO

		ArrayList<RangeData> jsonData = buildRangeData(requestData, year, Integer.valueOf(startDate), "",
				Integer.valueOf(endDate), "", code);
		System.out.println(mapper.writeValueAsString(jsonData));

	}

	public void getRange_Compare(RequestData requestData, String caseSelect, String caseIO, String year,
			String startDate, String endDate, String compareYear, String compare_startDate, String compare_endDate,
			String code) throws JsonProcessingException { // all
		// case
		// &&
		// all
		// IO

		ArrayList<RangeData> jsonData = buildRangeData(requestData, year, Integer.valueOf(startDate), "",
				Integer.valueOf(endDate), "", code);
		System.out.println(mapper.writeValueAsString(jsonData));

	}

	public String callCompareLast(RequestData requestData, String code) throws JsonProcessingException {
		String lastYear = String.valueOf(bi_RangeDate.getYear() - 1);
		String thisYear = String.valueOf(bi_RangeDate.getYear());
		String range = String.valueOf(bi_RangeDate.getLocalMonth());
		String io = requestData.getOuLldCase();
		String caseSelect = requestData.getAmountCase();
		HashMap<String, Object> result = new HashMap<>();
		int startMonth = 1;
		int endMonth=Integer.parseInt(range);
//		int endMonth = Integer.parseInt(range.replace("0", ""));
		
		System.out.println("lastYear" +lastYear+"thisYear"+thisYear+"range"+range+"startMonth"+startMonth+"endMonth"+endMonth);		

		
		CompletableFuture<ArrayList<RangeData>> future1 = CompletableFuture
				.supplyAsync(() -> buildRangeData(requestData, lastYear, startMonth, "", endMonth, "", code));

		CompletableFuture<ArrayList<RangeData>> future2 = CompletableFuture
				.supplyAsync(() -> buildRangeData(requestData, thisYear, startMonth, "", endMonth, "", code));
		CompletableFuture<Void> allDone = CompletableFuture.allOf(future1, future2);
		try {
			ArrayList<RangeData> jsonData = future1.get();
			ArrayList<RangeData> jsonData2 = future2.get();
			if (jsonData == null || jsonData2 == null) {

				return "none";
			}
			String resultString = mapper.writeValueAsString(jsonData) + "_" + mapper.writeValueAsString(jsonData2);
			System.out.println("result" + resultString);
			return resultString;
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";

		}

//		System.out.println(mapper.writeValueAsString(jsonData));
//		System.out.println(mapper.writeValueAsString(jsonData2));
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

	public String callRangeCompare(RequestData requestData, String code) {
		String[] selectData_start = requestData.getCompareType().getStartDate().split("/");
		String[] selectData_end = requestData.getCompareType().getEndDate().split("/");
		String[] compareData_start = requestData.getCompareType().getCompareStartDate().split("/");
		String[] compareData_end = requestData.getCompareType().getCompareEndDate().split("/");
		String compareProcess_start = bi_RangeDate.getProceeYear(selectData_start[0]) + selectData_start[1]
				+ selectData_start[2];
		String compareProcess_end = bi_RangeDate.getProceeYear(selectData_end[0]) + selectData_end[1]
				+ selectData_end[2];
		String selectProcess_start = bi_RangeDate.getProceeYear(selectData_start[0]) + selectData_start[1]
				+ selectData_start[2];
		String selectProcess_end = bi_RangeDate.getProceeYear(selectData_end[0]) + selectData_end[1]
				+ selectData_end[2];
		int select_startMonth = Integer.valueOf(selectData_start[1]);
		int select_endMonth = Integer.valueOf(selectData_end[2]);
		int compare_startMonth = Integer.valueOf(compareData_start[1]);
		int compare_endMonth = Integer.valueOf(compareData_end[2]);
		String range = String.valueOf(bi_RangeDate.getLocalMonth());
		int startMonth = 1;
		int endMonth = Integer.parseInt(range.replace("0", ""));

		CompletableFuture<ArrayList<RangeData>> future1 = CompletableFuture
				.supplyAsync(() -> buildRangeData(requestData, bi_RangeDate.getProceeYear(selectData_start[0]),
						selectData_start[1], selectData_start[2], selectData_end[1], selectData_end[2], code));

		CompletableFuture<ArrayList<RangeData>> future2 = CompletableFuture
				.supplyAsync(() -> buildRangeData(requestData, bi_RangeDate.getProceeYear(compareData_start[0]),
						compareData_start[1], compareData_start[2], compareData_end[1], compareData_end[2], code));

		CompletableFuture<Void> allDone = CompletableFuture.allOf(future1, future2);

		try {
			ArrayList<RangeData> jsonData = future1.get();
			ArrayList<RangeData> jsonData2 = future2.get();
			System.out.println("resultsss" + jsonData);

			if (jsonData == null || jsonData2 == null) {

				return "none";
			}
			String resultString = mapper.writeValueAsString(jsonData) + "_" + mapper.writeValueAsString(jsonData2);
			System.out.println("resultsss" + resultString);

			return resultString;
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";

		}

	}

	public ArrayList<RangeData> buildRangeData(RequestData requestData, String year, int startMonth,
			String startDate_Local, int endMonth, String endDate_Local, String code) { // local && rangeYear

		System.out.println("getAmountCase" + requestData.getCompareRadio());

		ArrayList<RangeData> list = new ArrayList<>();
		if (requestData.getCompareRadio().equals("lastYear")) {
			for (int i = startMonth; i <= endMonth; i++) {
			
				String monthStr = (i < 10 ? "0" + i : String.valueOf(i));
				RangeData data = RangeData.builder().keyMonth(i + "月").priceMonth(query.strategy(boss_BI_SqlWhere,
						requestData, year + monthStr + "01", year + monthStr + "31", code)).build();

				list.add(data);
			}

		} else if (requestData.getCompareRadio().equals("localYear")) {

			System.out.println("startDate_Local" + startDate_Local + "endDate_Local" + endDate_Local);
			for (int i = startMonth; i <= endMonth; i++) {
				String monthStr = (i < 10 ? "0" + i : String.valueOf(i));
				if (startMonth == endMonth) {
					RangeData data = RangeData.builder().keyMonth(i + "月").priceMonth(query.strategy(boss_BI_SqlWhere,
							requestData, year + startDate_Local, year + endDate_Local, code)).build();

					list.add(data);

				} else if (i == startMonth) {

					RangeData data = RangeData.builder().keyMonth(i + "月").priceMonth(query.strategy(boss_BI_SqlWhere,
							requestData, year + startDate_Local, year + monthStr + "31", code)).build();

					list.add(data);

				} else if (i == endMonth) {

					RangeData data = RangeData.builder().keyMonth(i + "月").priceMonth(query.strategy(boss_BI_SqlWhere,
							requestData, year + monthStr + "01", year + endDate_Local, code)).build();

					list.add(data);
				} else {

					RangeData data = RangeData.builder().keyMonth(i + "月").priceMonth(query.strategy(boss_BI_SqlWhere,
							requestData, year + monthStr + "01", year + monthStr + "31", code)).build();

					list.add(data);

				}

			}

		}

		System.out.print(list);
		return list;
	}

	public ArrayList<RangeData> buildRangeData(RequestData requestData, String year, String startMonth,
			String startDate, String endMonth, String endDate, String code) { // other year

		int startPoint = Integer.valueOf(startMonth);
		int endPoint = Integer.valueOf(endMonth);
		System.out.print("S" + startPoint + "E" + endPoint);
		if (requestData.getCompareRadio().equals("otherYear")) {
			ArrayList<RangeData> list = new ArrayList<>();
			for (int i = startPoint; i <= endPoint; i++) {
				String monthStr = (i < 10 ? "0" + i : String.valueOf(i));
				String monthEnd = (i < 10 ? "0" + i : String.valueOf(i));

				if (startPoint == endPoint) {
					RangeData endData = RangeData.builder().keyMonth(i + "月")
							.priceMonth(query.strategy(boss_BI_SqlWhere, requestData, year + monthStr + startDate,
									year + monthStr + endDate, code))
							.build();
					list.add(endData);

				} else if (i == endPoint) {
					RangeData endData = RangeData.builder().keyMonth(i + "月")
							.priceMonth(query.strategy(boss_BI_SqlWhere, requestData, year + monthStr + "01",
									year + monthEnd + endDate, code))
							.build();
					list.add(endData);

				} else if (i == startPoint) {
					RangeData endData = RangeData.builder().keyMonth(i + "月")
							.priceMonth(query.strategy(boss_BI_SqlWhere, requestData, year + monthStr + startDate,
									year + monthStr + "31", code))
							.build();
					list.add(endData);
				} else {
					RangeData startData = RangeData.builder().keyMonth(i + "月")
							.priceMonth(query.strategy(boss_BI_SqlWhere, requestData, year + monthStr + "01",
									year + monthStr + "31", code))
							.build();
					list.add(startData);

				}
			}

			return list;
		}
		return null;

	}

}
