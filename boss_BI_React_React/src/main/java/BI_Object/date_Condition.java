package BI_Object;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
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
//@Table(name = "ortvmarquee")
public class date_Condition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 或 SEQUENCE/UUID，依DB不同
	private Long id;
	public Date mainStartDate;
	public Date mainEndDate;
	public Date otherStartDate;
	public Date otherEndDate;
}
