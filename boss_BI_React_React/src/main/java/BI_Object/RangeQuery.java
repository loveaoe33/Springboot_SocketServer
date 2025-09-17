/**
 * 
 */
package BI_Object;

import java.math.BigDecimal;

/**
 * @author loveaoe33
 *
 */
public interface RangeQuery {
	BigDecimal query(String startDate, String endDate,String sqlWhere);
	BigDecimal queryDeep(String caseSelect, String caseIO, String year, String startDate, String endDate,
			String compareYear, String compare_startDate, String compare_endDate,String sqlWhere);
	
}
