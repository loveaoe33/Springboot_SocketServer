package BI_Object;

import java.math.BigDecimal;

import jakarta.persistence.Id;

public class V_PRICEHE {
	@Id
	public String CODE;
	public String  EFF_DATE;
	public BigDecimal PRICE;
	public BigDecimal HE_PRICE;
}
