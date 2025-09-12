package BI_Object;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "V_CHARGE")
public class V_CHARGE {
	public String CASHIER;
	public String CASH_DATE;
	public String CASH_TIME;
	public int REC_COUNT;
	public String OPD_DATE;
	public int CHART_NO;
	public int SERNO;
	public int PT_TYPE;
	public int DISCOUNT_PTR;
	@Id
	public int BILL_NO;
	public int PAID_FLAG;
	public String INP_OPD;
	public int DIV_NO;
	public String DOCTOR_NO;
	public BigDecimal TOT_AMT;
	public int AR;
	public int SUPPLE_AMT;
	public BigDecimal DISCOUNT;
	public BigDecimal COMP_DISCOUNT;
	public int BILL_DOUBT;
	public int OVERPAY;
	public BigDecimal PAID;
	public BigDecimal UNPAID;
	public String PAID_TYPE;
	public String PROGGRAM_ID;
}
