package BI_Object;

import java.math.BigDecimal;

import jakarta.persistence.Id;

public class V_STAIO {
    public String STOCK;
    @Id
    public String ITEM_NO;
    public BigDecimal CURRENT_QTY; // 或 int，如果一定是整數
}
