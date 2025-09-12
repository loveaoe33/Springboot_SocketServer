package BI_Object;

import java.math.BigDecimal;

import jakarta.persistence.Id;

public class V_TPRC {
    public String PRICE_DATE;
    public String PRICE_TIME;  // 如果是時間欄位，也可以用 java.sql.Time
    public int CHART_NO;
    public int SERNO;
    public String DIV_NO;
    public String DOCTOR_NO;
    public String INP_OPD;
    @Id
    public String CODE;
    public BigDecimal TQTY;    // 如果一定是整數，也可改成 int
}
