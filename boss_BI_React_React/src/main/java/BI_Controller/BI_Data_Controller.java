package BI_Controller;

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
import BI_Object.date_Condition;
import BI_Object.select_Condition;
import BI_Server.Boss_BiServer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = { "BI_Config", "JPA", "BI_Server","BI_Object" ,"BI_Lib" })
public class BI_Data_Controller {

	
	private Boss_BiServer boss_BiServe;
	private BI_RangeDate bI_RangeDate;
	private ObjectMapper mapper;
	
	@Autowired
	public BI_Data_Controller(Boss_BiServer boss_BiServe,BI_RangeDate bI_RangeDate,ObjectMapper mapper) {

		this.boss_BiServe=boss_BiServe;
		this.bI_RangeDate=bI_RangeDate;
		this.mapper=mapper;

	}
	
	
	
	@GetMapping("BI_Data_Controller/test")
	public String test2() {
		System.out.println("有近"+bI_RangeDate.getDateCombine());
		boss_BiServe.getLastYearCash();
		return "123";
	}
	
	
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "發送成功"),
	@ApiResponse(responseCode = "400", description = "參數錯誤") })
	@GetMapping("BI_Data_Controller/initAmountData")
	public String initAmointData() {
		return boss_BiServe.getInit_Amount();
	}
	

	@Operation(summary = "select condition")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "發送成功"),
	@ApiResponse(responseCode = "400", description = "參數錯誤") })
	@GetMapping("BI_Data_Controller/test2")
	public String getSQLSelect(@RequestParam  String sqlSelect) throws JsonMappingException, JsonProcessingException {
		System.out.println("有近2"+sqlSelect);

		RequestData	requestData=mapper.readValue(sqlSelect, RequestData.class);
		System.out.println("有近2"+requestData.getChartType());
		return "123";
	}
	
	

	
	
}
