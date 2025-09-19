package BI_Object;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import JPA.Boss_BI_JPA_SqlWhere_Interface;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Component
@Getter
@Setter
@Builder
public class QueryMethod {
	
    public BigDecimal strategy(Boss_BI_JPA_SqlWhere_Interface jpa,RequestData data,String startDate,String endDate,String code) {
		switch(code){
		case "11":
			return getTotalPaidQuery().query(jpa, startDate, endDate);
		case "12":
			return getTotalPaidQuery().query(jpa, code, code);
		case "13":
			return getTotalPaidQuery().query(jpa, code, code);
		case "21":
			return getTotalPaidQuery().query(jpa, code, code);
		case "22":
			return getTotalPaidQuery().query(jpa, code, code);
		case "23":
			return getTotalPaidQuery().query(jpa, code, code);
		case "31":
			return getTotalPaidQuery().query(jpa, code, code);
		case "32":
			return getTotalPaidQuery().query(jpa, code, code);
		case "33":
			return getTotalPaidQuery().query(jpa, code, code);
		}
		return null;
		
		
	}
	
    private totalPaidQuery getTotalPaidQuery() {
		return new totalPaidQuery();
	}
	
	private ownPaidQuery getOwnPaidQuery() {
		return new ownPaidQuery();
	}
	private class totalPaidQuery implements RangeQuery {

		@Override
		public BigDecimal query(Boss_BI_JPA_SqlWhere_Interface jpa,String startDate, String endDate) {
			// select all
			return jpa.arrayTotalPaid(startDate, endDate);
		}

		@Override
		public BigDecimal queryCase(Boss_BI_JPA_SqlWhere_Interface jpa, List<String> caseSelect,  List<String> caseIO, String year, String startDate, String endDate) {
			// select case && io
			return jpa.arrayTotalPaid(startDate, endDate, caseSelect, caseIO);
		}

		@Override
		public BigDecimal queryCaseWhere(Boss_BI_JPA_SqlWhere_Interface jpa,List<String> caseSelect,  List<String> caseIO, String year, String startDate,
				String endDate,  List<String> sqlWhere) {
			// select case && io && sqlwhere && compare year
			return jpa.arrayTotalPaid(startDate, endDate, caseSelect, caseIO, sqlWhere);
		}



	}

	private class ownPaidQuery implements RangeQuery {

		@Override
		public BigDecimal query(Boss_BI_JPA_SqlWhere_Interface jpa,String startDate, String endDate) {
			// select all
			return jpa.arrayTotalPaid(startDate, endDate);
		}

		@Override
		public BigDecimal queryCaseWhere(Boss_BI_JPA_SqlWhere_Interface jpa,List<String> caseSelect,  List<String> caseIO, String year, String startDate,
				String endDate,  List<String> sqlWhere) {
			// select case && io && sqlwhere && compare year
			return null;
		}

		@Override
		public BigDecimal queryCase(Boss_BI_JPA_SqlWhere_Interface jpa,List<String> caseSelect,  List<String> caseIO, String year, String startDate, String endDate) {
			// select case && io && sqlwhere
			return null;
		}



	}

}
