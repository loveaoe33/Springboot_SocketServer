package BI_Object;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
    public static class CompareType {
        private String startDate;
        private String endEdate;
        private String compareStartDate;
        private String compareEndDate;
    }
}
