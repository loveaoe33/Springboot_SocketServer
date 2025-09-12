package JPA;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import BI_Object.V_BILL;


@Repository
public interface Boss_BI_JPA_InitAmount_Interface extends JpaRepository<V_BILL, Long>{
    @Query(
            value = "SELECT SUM(TOT_AMT-COALESCE(COMP_DISCOUNT, 0)-COALESCE(PART_AMT, 0)) FROM v_bill WHERE BILL_DATE LIKE CONCAT(?1,'%') AND CATEGORIES<>3",
            nativeQuery = true
        )
    BigInteger getBilAmount(String year);
    
 
    @Query(
            value = "SELECT SUM(PAID) FROM V_CHARGE WHERE CASH_DATE LIKE CONCAT(?1,'%')",
            nativeQuery = true
        )
    BigInteger getSelfAmount(String year);

}