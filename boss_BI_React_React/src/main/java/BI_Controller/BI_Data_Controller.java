package BI_Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import BI_Lib.BI_RangeDate;
import BI_Object.RequestData;
import BI_Object.RequestData.CompareType;
import BI_Object.date_Condition;
import BI_Object.select_Condition;
import BI_Server.Boss_BiServer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = { "BI_Config", "JPA", "BI_Server", "BI_Object", "BI_Lib" })
public class BI_Data_Controller {

	private Boss_BiServer boss_BiServe;
	private BI_RangeDate bI_RangeDate;
	private ObjectMapper mapper;

	@Autowired
	public BI_Data_Controller(Boss_BiServer boss_BiServe, BI_RangeDate bI_RangeDate, ObjectMapper mapper) {

		this.boss_BiServe = boss_BiServe;
		this.bI_RangeDate = bI_RangeDate;
		this.mapper = mapper;

	}

	@GetMapping("BI_Data_Controller/callCompareLast") // compareLastMonth
	public String callCompareLast(@RequestParam String sqlSelect) throws JsonProcessingException { // ok
		System.out.println("有近" + bI_RangeDate.getDateCombine());
		RequestData requestData = mapper.readValue(sqlSelect, RequestData.class);
		return boss_BiServe.compareCash(requestData);
	}

	@GetMapping("BI_Data_Controller/callCompareLasttest") // compareLastMonth
	public HashMap<String, String> callCompareLasttest() throws JsonProcessingException { // ok
		HashMap<String, String> result = new HashMap<>();
		CompareType compareType = CompareType.builder().startDate("20250101").endDate("20250131")
				.compareStartDate("20240101").compareEndDate("20240131").build();

		RequestData data = RequestData.builder().amountCase("健保/自費").chartType(null).compareRadio("lastYear")
				.ouLldCase("門診/住院").compareType(compareType).build();

		if (boss_BiServe.compareCash(data).equals("fail")) {
			System.out.print("進1");

			return null;
		} else {
			System.out.print("進2");
			String[] json = boss_BiServe.compareCash(data).split("_");
			result.put("lastYear", json[0]);
			result.put("thisYear", json[1]);
			return result;

		}

	}

	@GetMapping("BI_Data_Controller/callCompareLasttest2") // compareLastMonth
	public HashMap<String, String> callCompareLasttest2() throws JsonProcessingException { // ok
		HashMap<String, String> result = new HashMap<>();
		CompareType compareType = CompareType.builder().startDate("20250101").endDate("20250131")
				.compareStartDate("20240101").compareEndDate("20240131").build();

		RequestData data = RequestData.builder().amountCase("健保/自費").chartType(null).compareRadio("lastYear")
				.ouLldCase("住院").compareType(compareType).build();

		if (boss_BiServe.compareCash(data).equals("fail")) {
			System.out.print("進1");

			return null;
		} else {
			if (boss_BiServe.compareCash(data) != "") {
				System.out.print("進2sss"+boss_BiServe.compareCash(data));

				String[] json = boss_BiServe.compareCash(data).split("_");
				result.put("lastYear", json[0]);
				result.put("thisYear", json[1]);
				return result;

			}

			return null;

		}

	}
	
	
	
	@GetMapping("BI_Data_Controller/callCompareLasttest3") // compareLastMonth
	public HashMap<String, String> callCompareLasttest3() throws JsonProcessingException { // ok
		HashMap<String, String> result = new HashMap<>();
		CompareType compareType = CompareType.builder().startDate("2025/09/03").endDate("2025/12/31")
				.compareStartDate("2024/09/03").compareEndDate("2024/11/31").build();

		RequestData data = RequestData.builder().amountCase("健保/自費").chartType(null).compareRadio("otherYear")
				.ouLldCase("住院").compareType(compareType).build();
      
		if (boss_BiServe.compareCash(data).equals("fail")) {
			System.out.print("進1");

			return null;
		} else {
//			if (boss_BiServe.compareCash(data) != "") {
//				System.out.print("進2sss"+boss_BiServe.compareCash(data));
//
//				String[] json = boss_BiServe.compareCash(data).split("_");
//				result.put("lastYear", json[0]);
//				result.put("thisYear", json[1]);
//				return result;
//
//			}

			return null;

		}

	}
	

	@GetMapping("BI_Data_Controller/test3")
	public String callRangeAmount() throws JsonProcessingException {
		RequestData data = RequestData.builder().amountCase(null).chartType(null).compareRadio("localYear")
				.compareType(null).build();
		return boss_BiServe.compareCash(data);

	}

	@ApiResponses({ @ApiResponse(responseCode = "200", description = "發送成功"),
			@ApiResponse(responseCode = "400", description = "參數錯誤") })
	@GetMapping("BI_Data_Controller/initAmountData")
	public String initAmointData() throws JsonProcessingException { // initData
		RequestData data = RequestData.builder().amountCase(null).chartType(null).compareRadio("initData")
				.compareType(null).build();
		return boss_BiServe.compareCash(data);
	}

	@Operation(summary = "select condition")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "發送成功"),
			@ApiResponse(responseCode = "400", description = "參數錯誤") })

	@GetMapping("BI_Data_Controller/test2")
	public String getSQLSelect(@RequestParam String sqlSelect) throws JsonMappingException, JsonProcessingException {
		System.out.println("有近2" + sqlSelect);

		RequestData requestData = mapper.readValue(sqlSelect, RequestData.class);
		System.out.println("有近2" + requestData.getChartType());
		return "123";
	}

}
