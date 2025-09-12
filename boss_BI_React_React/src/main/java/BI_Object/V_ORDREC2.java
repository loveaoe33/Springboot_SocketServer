package BI_Object;

import java.math.BigDecimal;

import jakarta.persistence.Id;

public class V_ORDREC2 {

	
    public String STOCK;
    @Id
    public String REC_NO;
    public int REC_COUNT;           // 或 BigDecimal，看你資料庫型態
    public String REC_DATE;
    public String ITEM_NO;
    public String EFFECT_DATE;
    public BigDecimal REC_PRICE;
    public BigDecimal TOT_QTY;
    public BigDecimal REC_AMT;
    public BigDecimal INVOICE_AMT;
    public String INVOICE_NO;
    public String INVOICE_DATE;
}
