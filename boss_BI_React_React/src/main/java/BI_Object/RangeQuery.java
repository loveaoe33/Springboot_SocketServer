/**
 * 
 */
package BI_Object;

import java.math.BigDecimal;
import java.util.List;

import JPA.Boss_BI_JPA_SqlWhere_Interface;

/**
 * @author loveaoe33
 *
 */
public interface RangeQuery {
	BigDecimal query(Boss_BI_JPA_SqlWhere_Interface jpa,String startDate, String endDate);   //select all
	BigDecimal queryCase(Boss_BI_JPA_SqlWhere_Interface jpa, List<String> caseSelect, List<String> caseIO, String startDate, String endDate); //select case && io
	BigDecimal queryCaseWhere(Boss_BI_JPA_SqlWhere_Interface jpa,List<String> caseSelect,  List<String> caseIO, String startDate, String endDate, List<String> sqlWhere); //select case && io && sqlwhere

	
}
