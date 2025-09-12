package BI_Object;

import java.math.BigDecimal;

import jakarta.persistence.Id;

public class V_INV {
    public String STOCK;
    @Id
    public String ITEM_NO;
    public BigDecimal CURRENT_QTY; // 如果是整數也可用 int
    public String FULL_NAME;
    public String FULL_NAME_C;
}
