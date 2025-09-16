package JPA;

import java.math.BigDecimal;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import BI_Object.V_BILL;

@Repository
public interface Boss_BI_JPA_SqlWhere_Interface extends JpaRepository<V_BILL, Long> {

	// select total expense && health insurance last amount
	@Query(value = "SELECT SUM(TOT_AMT) as totalPaid " + "FROM v_bill "
			+ "WHERE BILL_DATE BETWEEN :startDate AND :endDate " + // 
			"AND CATEGORIES <> '3'", nativeQuery = true)
	BigDecimal arrayTotalPaid(@Param("startDate") String startDate, @Param("endDate") String endDate);

	// select total expense && health insurance last amount
	@Query(value = "SELECT SUM(TOT_AMT) as totalPaid " + "FROM v_bill "
			+ "WHERE BILL_DATE BETWEEN :startDate AND :endDate " + "AND CATEGORIES IN (:caseSelect) " + // <- IN
			"AND INP_OPD IN (:caseIO) " + // <- I/O 欄位也用 IN
			"AND CATEGORIES <> '3'", nativeQuery = true)
	BigDecimal arrayTotalPaid(@Param("startDate") String startDate, @Param("endDate") String endDate,
			@Param("caseSelect") List<String> caseSelect, @Param("caseIO") List<String> io);
	
	
	
	// select total expense && health insurance last amount && sql where
	@Query(value = "SELECT SUM(TOT_AMT) as totalPaid " + "FROM v_bill "
			+ "WHERE BILL_DATE BETWEEN :startDate AND :endDate " + "AND CATEGORIES IN (:caseSelect) " + // <- IN
			"AND INP_OPD IN (:caseIO) " + // <- I/O 欄位也用 IN
			"AND CATEGORIES <> '3'", nativeQuery = true)
	BigDecimal arrayTotalPaid(@Param("startDate") String startDate, @Param("endDate") String endDate,
			@Param("caseSelect") List<String> caseSelect, @Param("caseIO") List<String> io,@Param("whereSelect") List<String> where);

	
	


	// select own expense last amount
	@Query(value = "SELECT SUM(TOT_AMT) as totalPaid " + "FROM v_charge " + "WHERE CASH_DATE LIKE CONCAT(?1,'%' )"
			+ "AND CATEGORIES <> '3'", nativeQuery = true)
	BigDecimal findToOwnPaid(String year);

	// select own and case expense last amount
	@Query(value = "SELECT SUM(TOT_AMT) as totalPaid " + "FROM v_charge "
			+ "WHERE   INP_OPD=?2   AND CASH_DATE LIKE CONCAT*(?1,'%' )" + "  INP_OPD IN (:caseIO) AND CATEGORIES <> '3'", nativeQuery = true)
	BigDecimal findToOwnPaid(@Param("startDate") String startDate, @Param("endDate") String endDate,
			@Param("caseIO") List<String> io);




}
