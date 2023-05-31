/*
package SERVER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import SocketClass.FeeBackClass;
import SocketClass.SQLClsas;

@Service
@Component
public class FaceJPA implements SQLConnect {
    
	private final SQLClsas SQLsingle;
	private SQLClsas SettSql;

	@Autowired
	public FaceJPA(SQLClsas sqlclass) {
		this.SQLsingle=sqlclass;
	}
	
	@Override
	public FaceJPA _init(SQLClsas sqlclass) {
		// TODO Auto-generated method stub
		this.SettSql=sqlclass;
		return this;
	}


	@Override
	public String SQLSetting() {
		// TODO Auto-generated method stub
		SQLsingle.ReSetConnection(SettSql);
		return "重新設置完成";
	}

	@Override
	public FeeBackClass Add_Data() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeeBackClass Delete_Data() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeeBackClass Update_Data() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeeBackClass Query_Data() {
		// TODO Auto-generated method stub
		return null;
	}



}
*/
