package BI_Object;

import java.math.BigDecimal;
import java.util.Arrays;
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

	public BigDecimal strategy(Boss_BI_JPA_SqlWhere_Interface jpa, RequestData data, String startDate, String endDate,
			String code) {
		System.out.print("QuerystartDate"+startDate+"endDate"+endDate+"code"+code);
		switch (code) {
		case "11": /* 健保/自費 門診/住院 */
			return getTotalPaidQuery().query(jpa, startDate, endDate);
		case "12": /* 健保/自費 門診 */
			List<String> caseList_12 = Arrays.asList("1", "2");
			List<String> ouldList_12 = Arrays.asList("O");
			return getTotalPaidQuery().queryCase(jpa, caseList_12, ouldList_12, startDate, endDate);

		case "13": /* 健保/自費 住院 */
			List<String> caseList_13 = Arrays.asList("1", "2");
			List<String> ouldList_13 = Arrays.asList("I");
			return getTotalPaidQuery().queryCase(jpa, caseList_13, ouldList_13, startDate, endDate);
		case "21":
			List<String> caseList_21 = Arrays.asList("1");
			List<String> ouldList_21 = Arrays.asList("I", "O");
			return getTotalPaidQuery().query(jpa, code, code);
		case "22":
			List<String> caseList_22 = Arrays.asList("1");
			List<String> ouldList_22 = Arrays.asList("I");
			return getTotalPaidQuery().query(jpa, code, code);
		case "23":
			List<String> caseList_23 = Arrays.asList("1");
			List<String> ouldList_23 = Arrays.asList("O");
			return getTotalPaidQuery().query(jpa, code, code);
		case "31":
			List<String> caseList_31 = Arrays.asList("2");
			List<String> ouldList_31 = Arrays.asList("I", "O");
			return getTotalPaidQuery().query(jpa, code, code);
		case "32":
			List<String> caseList_32 = Arrays.asList("2");
			List<String> ouldList_32 = Arrays.asList("I");
			return getTotalPaidQuery().query(jpa, code, code);
		case "33":
			List<String> caseList_33 = Arrays.asList("1");
			List<String> ouldList_33 = Arrays.asList("O");
			return getTotalPaidQuery().query(jpa, code, code);
		case "otherYear":

			return null;
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
		public BigDecimal query(Boss_BI_JPA_SqlWhere_Interface jpa, String startDate, String endDate) {
			// select all
			return jpa.arrayTotalPaid(startDate, endDate);
		}

		@Override
		public BigDecimal queryCase(Boss_BI_JPA_SqlWhere_Interface jpa, List<String> caseSelect, List<String> caseIO,
				String startDate, String endDate) {
			// select case && io
			return jpa.arrayTotalPaid(startDate, endDate, caseSelect, caseIO);
		}

		@Override
		public BigDecimal queryCaseWhere(Boss_BI_JPA_SqlWhere_Interface jpa, List<String> caseSelect,
				List<String> caseIO, String startDate, String endDate, List<String> sqlWhere) {
			// select case && io && sqlwhere && compare year
			return null;
		}

	}

	private class ownPaidQuery implements RangeQuery {

		@Override
		public BigDecimal query(Boss_BI_JPA_SqlWhere_Interface jpa, String startDate, String endDate) {
			// select all
			return jpa.arrayTotalPaid(startDate, endDate);
		}

		@Override
		public BigDecimal queryCaseWhere(Boss_BI_JPA_SqlWhere_Interface jpa, List<String> caseSelect,
				List<String> caseIO, String startDate, String endDate, List<String> sqlWhere) {
			// select case && io && sqlwhere && compare year
			return null;
		}

		@Override
		public BigDecimal queryCase(Boss_BI_JPA_SqlWhere_Interface jpa, List<String> caseSelect, List<String> caseIO,
				String startDate, String endDate) {
			// select case && io && sqlwhere
			return null;
		}

	}

}
