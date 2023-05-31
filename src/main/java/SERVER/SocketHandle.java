package SERVER;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Date;
import java.time.Instant;
import java.net.Socket;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import DAO.JPA_MYSQL;
import DAO.JPA_MYSQLController;
import DAO.JPA_MYSQLRepository;


public  class  SocketHandle extends Thread {
	
	private JPA_MYSQLController jA_MYSQLController;   
	ByteArrayOutputStream baos=new ByteArrayOutputStream();
	private Socket socket;
	private String Response;
	private String message;
	
	//private static final String PERSISTENCE_UNIT_NAME = "CnnUnit";
	//private static  EntityManagerFactory factory;
	private final Object lock=new Object();
	
    String date= (Date.from(Instant.now())).toString();
	String Result;
	public SocketHandle(Socket socket,JPA_MYSQLController jA_MYSQLController) {
		this.socket=socket;
		this.jA_MYSQLController=jA_MYSQLController;
	}


	public void run() {
		try {
			//factory =Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			//EntityManager entitymanager=factory.createEntityManager();
			
			
			InputStream inputStream =socket.getInputStream();
			OutputStream outputStream=socket.getOutputStream();
			byte[] buffer=new byte[1024];
			
			int bytesRead;
			while((bytesRead=inputStream.read(buffer))!=-1) {
				 message =new String(buffer,0,bytesRead);
				 Response=message.toUpperCase();
				outputStream.write(Response.getBytes());
				
			}
			if(message!=""&& !message.isEmpty()) {
				synchronized(lock) {
					JPA_MYSQL jPA_MYSQL=JPA_MYSQL.builder().name("立帆測試1").date(date).build();
					//((JPA_MYSQLController) jPA_MYSQLRepository).Add_JPA(jPA_MYSQL);
					//*entitymanager.getTransaction().begin();
					//entitymanager.persist(jPA_MYSQL);
					//entitymanager.getTransaction().commit();
					jA_MYSQLController.Add_JPA(jPA_MYSQL);
				}
			}
            socket.close();
            Result=String.format("客户端位址%S傳送字串為%S並断开连接:", socket.getInetAddress(),message);
            System.out.println(Result + socket.getInetAddress());
		} catch (IOException e) {
			// TODO Auto-generated catch block
            Result=String.format("客户端%S发生错误:", socket.getInetAddress());
            System.out.println(Result + e.getMessage());
		}
		
		
	}


	private Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
}
