package JPA;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import BI_Object.V_BILL;

@Repository
public interface Boss_BI_JPA_SqlWhere_Interface extends JpaRepository<V_BILL, Long> {

	// INP_OPD o=outpatient i=Hosp
	// select total expense && health insurance last amount
	@Query(value = "SELECT SUM(TOT_AMT) as totalPaid " + "FROM v_bill " + "WHERE BILL_DATE LIKE CONCAT(?1,'%' )"
			+ "AND CATEGORIES <> '3'", nativeQuery = true)
	BigDecimal findTotalPaid(String year);

	// select total && case expense && health insurance last amount
	@Query(value = "SELECT SUM(TOT_AMT) as totalPaid " + "FROM v_bill "
			+ "WHERE  INP_OPD=?2  AND BILL_DATE LIKE CONCAT(?1,'%' )"
			+ "AND CATEGORIES <> '3'", nativeQuery = true)
	BigDecimal findTotalPaid(String year, String caseSelect);

	@Query(value = "SELECT SUM(TOT_AMT) as totalPaid " + "FROM v_bill " + "WHERE INP_OPD = ?2 "
			+ "AND BILL_DATE BETWEEN ?3 AND ?4 " + "AND CATEGORIES <> '3'", nativeQuery = true)
	BigDecimal findTotalPaid(String year, String caseSelect, String compareStart, String compareEnd);
	
	

	// select own expense last amount
	@Query(value = "SELECT SUM(TOT_AMT) as totalPaid " + "FROM v_charge " + "WHERE CASH_DATE LIKE CONCAT(?1,'%' )"
			+ "AND CATEGORIES <> '3'", nativeQuery = true)
	BigDecimal findToOwnPaid(String year);

	// select own and case expense last amount
	@Query(value = "SELECT SUM(TOT_AMT) as totalPaid " + "FROM v_charge " + "WHERE   INP_OPD=?2   AND CASH_DATE LIKE CONCAT*(?1,'%' )"
			+ "AND CATEGORIES <> '3'", nativeQuery = true)
	BigDecimal findToOwnPaid(String year, String caseSelect);

	// select own & case && compare_date expense expense last amount
	@Query(value = "SELECT SUM(TOT_AMT) as totalPaid " + "FROM v_charge " + "WHERE INP_OPD=?2 AND CASH_DATE BETWEEN ?3 AND ?4 "
			+ "AND CATEGORIES <> '3'", nativeQuery = true)
	BigDecimal findToOwnPaid(String year, String caseSelect, String compareStart, String compareEnd);
	
	
	
	
	

	// select insurance expense last amount
	@Query(value = "SELECT SUM(TOT_AMT) as totalPaid " + "FROM v_bill " + "WHERE BILL_DATE LIKE CONCAT*(?1,'%' )"
			+ "AND CATEGORIES == '2'", nativeQuery = true)
	BigDecimal findToHealthPaid(String year);

	// select insurance expense && case last amount
	@Query(value = "SELECT SUM(TOT_AMT) as totalPaid " + "FROM v_bill " + "WHERE  INP_OPD=?2 AND  BILL_DATE LIKE CONCAT*(?1,'%' )"
			+ "AND CATEGORIES == '2'", nativeQuery = true)
	BigDecimal findToHealthPaid(String year, String caseSelect);

	// init insurance expense && case && compare_date last amount
	@Query(value = "SELECT SUM(TOT_AMT) as totalPaid " + "FROM v_bill " + "WHERE  INP_OPD=?2 AND  AND BILL_DATE BETWEEN ?3 AND ?4"
			+ "AND CATEGORIES <> '3'", nativeQuery = true)
	BigDecimal findToHealthPaid(String year, String caseSelect, String compareStart, String compareEnd);

}
