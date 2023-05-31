package CarIdentifyMain;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DAO.testAuto;
import SERVER.SocketServe;


@RestController
@ComponentScan("DAO.testAuto")
public class CarIdentifyController {
	private final SocketServe socketServe;
    private final testAuto testauto;
    @Autowired
    public CarIdentifyController(testAuto testauto,SocketServe socketServe) {
		this.testauto=testauto;
    	this.socketServe=socketServe;
    }


	@GetMapping("/")
	public String init() throws IOException{
		testauto.test();	
		socketServe.SocketConnection();
		System.out.println("初始化完成");
		return "Hey, Spring Boot 的 Hello Wosrld ! ";
	}
	
}
