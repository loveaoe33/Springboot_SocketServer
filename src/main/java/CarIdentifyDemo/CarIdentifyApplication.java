package CarIdentifyDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import CarIdentifyMain.CarIdentifyController;

@SuppressWarnings("unused")
@SpringBootApplication(scanBasePackages = {"CarIdentifyMain","DAO","JPAClass_Face","SERVER","SocketClass"})
// 確保包名匹配
@EnableJpaRepositories("DAO")
@EntityScan(basePackages ="DAO")
public class CarIdentifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarIdentifyApplication.class, args);
	}

}
