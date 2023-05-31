package SocketClass;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SQLClsas  {
  SQLClsas sqlClass;
  private  String ConnecttinString;
  private  String SQlString;
  private  String Account;
  private  String Password;
  public void ReSetConnection(SQLClsas sqlClass) {
	   sqlClass.builder().Account(sqlClass.Account).Password(sqlClass.Password).SQlString(sqlClass.SQlString).ConnecttinString(sqlClass.ConnecttinString);
  }

}
