package BI_Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import BI_Lib.BI_RangeDate;
import BI_Object.date_Condition;
import BI_Object.select_Condition;

@Configuration
public class BI_Config {

	@Bean
	public select_Condition getSelect_Condition() {
		
		return new select_Condition();
	} 
	
	
	@Bean
	public date_Condition getDate_Condition() {
		
		return new date_Condition();
	} 
	
	
	@Bean
	public BI_RangeDate getBI_RangeDate() {
		
		return new BI_RangeDate();
	}	
    @Bean
    public ObjectMapper getObjectMapper() {
    	return new ObjectMapper();
    	
    	
    }
}
