package SERVER;

import SocketClass.FeeBackClass;
import SocketClass.SQLClsas;


public interface SQLConnect {
  SQLConnect _init(SQLClsas sqlclass);
  String SQLSetting();
  FeeBackClass Add_Data();
  FeeBackClass Delete_Data();
  FeeBackClass Update_Data();
  FeeBackClass Query_Data();
}
