package Information_App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan(basePackages = {"BI_Controller"})
@EnableJpaRepositories(basePackages={"JPA"})abstract
@EntityScan(basePackages= {"BI_Object"})
public class BossBiReactReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(BossBiReactReactApplication.class, args);
	}

}
