package BI_Object;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "V_BILL")
public class V_BILL {
    public String CHART_NO;
    @Id
    public String BILL_NO;
    public String CATEGORIES;
    public String INP_OPD;
    public String  BILL_DATE;
    public String SERNO;
    public String PT_TYPE;
    public BigDecimal DISCOUNT_PTR;
    public BigDecimal TOT_AMT;
    public BigDecimal ACNT_DISCOUNT;
    public BigDecimal DISCOUNT;
    public BigDecimal COMP_DISCOUNT;
    public BigDecimal DOUBT;
    public BigDecimal OVERPAY;
    public BigDecimal PAID;
    public String PAY_UP_DATE;
    public String RETURN_DATE;
    public String COMEFROM_NO;
    public String PART_NO;
    public BigDecimal PART_AMT;
    public String INFECTION_FLAG;
    public String CHRONIC_FLAG;
    public String FORCE_TYPE;
    public String DIV_NO;
    public String DOCTOR_NO;
}
