package BI_Object;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "V_BILAMT")
public class V_BILAMT {
	public String CHART_NO;
	@Id
	public String BILL_NO;
	public String CATEGORIES;
	public String ACNT_NO;
	public BigDecimal AMT;
	public BigDecimal ACNT_DISCOUNT;
	public BigDecimal DISCOUNT;
	public BigDecimal COMP_DISCOUNT;
	public BigDecimal PAID;
}
