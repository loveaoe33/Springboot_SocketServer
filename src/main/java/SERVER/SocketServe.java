package SERVER;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import DAO.JPA_MYSQLController;
import DAO.JPA_MYSQLRepository;




@ComponentScan("DAO")
@Component
public class SocketServe {
//static SocketServe _ServerUp=new SocketServe();//
	JPA_MYSQLController jA_MYSQLController;  
	@Autowired
	public SocketServe(	JPA_MYSQLController jA_MYSQLController  ) {
		this.jA_MYSQLController=jA_MYSQLController;
	}
public  void SocketConnection() throws IOException {
	final int serverPort=8888;
	
	try {
		ServerSocket socketListen=new ServerSocket(serverPort);
		System.out.println("服務啟動,等待連接");
		while(true) {
            Socket socketAccept = socketListen.accept();
    		System.out.println("成功連接到Server");    		
    		Thread thread=new Thread(new SocketHandle(socketAccept,this.jA_MYSQLController));
    		thread.start();
		}
	}catch(IOException e){
		System.out.println(e.getMessage());

	}
 }

}


