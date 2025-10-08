package BI_Object;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestData {

    private String amountCase;
    private String ouLldCase;
	private List<String> sqlCheckbox;   
    private String chartType;
    private String compareRadio;
    private CompareType compareType;
    
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class CompareType {
        private String startDate;
        private String endDate;
        private String compareStartDate;
        private String compareEndDate;
    }
}


