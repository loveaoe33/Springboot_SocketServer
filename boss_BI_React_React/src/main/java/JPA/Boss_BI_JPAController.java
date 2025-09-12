package JPA;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import BI_Lib.BI_RangeDate;
import BI_Object.RequestData;
import jakarta.annotation.PostConstruct;

@Service
public class Boss_BI_JPAController {

	private Boss_BI_JPA_InitAmount_Interface boss_BI_InitAmount;
	private Boss_BI_JPA_SqlWhere_Interface boss_BI_SqlWhere;
	private BigInteger last_Year_Amount;
	private BigInteger thie_Year_Amount;
	private BigInteger thie_Year_SelfAmount;
	private BigInteger thie_Month_Amount;
	private BigInteger this_Local_Amount;
	private BI_RangeDate bi_RangeDate;
	private StringBuilder sb = new StringBuilder();
	private DecimalFormat formatter = new DecimalFormat("#,###.##");

	@Autowired
	public Boss_BI_JPAController(Boss_BI_JPA_InitAmount_Interface boss_BI_InitAmount,
			Boss_BI_JPA_SqlWhere_Interface boss_BI_SqlWhere, BI_RangeDate bi_RangeDate) {
		this.boss_BI_InitAmount = boss_BI_InitAmount;
		this.boss_BI_SqlWhere = boss_BI_SqlWhere;
		this.bi_RangeDate = bi_RangeDate;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		initAmount();
		timerCatch();
	}

	public void timerCatch() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		Runnable task = () -> {
			initLocalAmoint();
			System.out.println("收益更新時間：" + java.time.LocalDateTime.now());
		};

		scheduler.scheduleAtFixedRate(task, 0, 10, TimeUnit.MINUTES);

	}

	public void initAmount() {

		getLastYear_Amount(Integer.toString(bi_RangeDate.getYear() - 1));
		getThisYear_Amount(Integer.toString(bi_RangeDate.getYear()));
		getThie_Year_SelfAmount(Integer.toString(bi_RangeDate.getYear()));
		getThisMonth_Amount(bi_RangeDate.getMonth());
		getLocalDate_Amount(bi_RangeDate.getDateCombine());
	}

	public void initLocalAmoint() {

		getThisYear_Amount(Integer.toString(bi_RangeDate.getYear()));
		getThie_Year_SelfAmount(Integer.toString(bi_RangeDate.getYear()));
		getThisMonth_Amount(bi_RangeDate.getMonth());
		getLocalDate_Amount(bi_RangeDate.getDateCombine());
	}

	public BigInteger getLastYear_Amount(String Year) { // get this year last total
		return last_Year_Amount = boss_BI_InitAmount.getBilAmount(Year);

	}

	public void getThisYear_Amount(String Year) {
		thie_Year_Amount = boss_BI_InitAmount.getBilAmount(Year);
	}

	public void getThie_Year_SelfAmount(String Year) {
		thie_Year_SelfAmount = boss_BI_InitAmount.getSelfAmount(Year);
	}

	public void getThisMonth_Amount(String Month) {
		thie_Month_Amount = boss_BI_InitAmount.getBilAmount(Month);
	}

	public void getLocalDate_Amount(String Date) {
		this_Local_Amount = boss_BI_InitAmount.getBilAmount(Date);
	}

	public String getInit_Amount() {
		sb.setLength(0);
		sb.append(formatter.format(thie_Year_Amount)).append("_").append(formatter.format(thie_Month_Amount))
				.append("_").append(formatter.format(this_Local_Amount)).append("_")
				.append(formatter.format(last_Year_Amount)).append("_").append(formatter.format(thie_Year_SelfAmount));
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public HashMap<String,String> data_Local_Compare(RequestData caseData){   //localYear
		
		 HashMap<String,BigInteger> compareData;   //compareData
         return null;
	}

}
