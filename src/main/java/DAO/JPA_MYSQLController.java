package DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@ComponentScan("DAO")
@Service
public  class  JPA_MYSQLController 	 {

private  JPA_MYSQLRepository jPA_MYSQLRepository;

@Autowired
public JPA_MYSQLController(JPA_MYSQLRepository jPA_MYSQLRepository) {
	this.jPA_MYSQLRepository=jPA_MYSQLRepository;
}
public  void Add_JPA(JPA_MYSQL jPA_MYSQL) {
	jPA_MYSQLRepository.save(jPA_MYSQL);
}
public  void Delete_JPA(JPA_MYSQL jPA_MYSQL ) {
	jPA_MYSQLRepository.delete(jPA_MYSQL);
}

public  JPA_MYSQL QueryOne_JPA(int id) {
	return 	jPA_MYSQLRepository.QueryOne_JPA(id);
}




}
