package BI_Object;

import java.math.BigDecimal;

import JPA.Boss_BI_JPA_SqlWhere_Interface;

public class QueryMethod {
	private Boss_BI_JPA_SqlWhere_Interface jpa;

	public QueryMethod(Boss_BI_JPA_SqlWhere_Interface jpa) {
		this.jpa = jpa;
	}

	public class totalPaidQuery implements RangeQuery {

		@Override
		public BigDecimal query(String startDate, String endDate, String sqlWhere) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal queryDeep(String caseSelect, String caseIO, String year, String startDate, String endDate,
				String compareYear, String compare_startDate, String compare_endDate, String sqlWhere) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public class ownPaidQuery implements RangeQuery {

		@Override
		public BigDecimal query(String startDate, String endDate, String sqlWhere) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal queryDeep(String caseSelect, String caseIO, String year, String startDate, String endDate,
				String compareYear, String compare_startDate, String compare_endDate, String sqlWhere) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public class healthPaidQuery implements RangeQuery {

		@Override
		public BigDecimal query(String startDate, String endDate, String sqlWhere) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal queryDeep(String caseSelect, String caseIO, String year, String startDate, String endDate,
				String compareYear, String compare_startDate, String compare_endDate, String sqlWhere) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
