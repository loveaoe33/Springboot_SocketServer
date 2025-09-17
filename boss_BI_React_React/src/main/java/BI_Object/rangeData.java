package BI_Object;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RangeData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 或 SEQUENCE/UUID，依DB不同
	private Long id;
	public String keyMonth;
	public BigDecimal priceMonth;

}
