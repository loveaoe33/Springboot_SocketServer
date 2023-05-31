package SERVER;

import org.springframework.beans.factory.annotation.Autowired;

import SocketClass.FeeBackClass;
import SocketClass.SQLClsas;

public class CarJPA implements SQLConnect {
    private final SQLClsas SQLsingle;
    private SQLClsas SettSql;
    
    
    @Autowired
    public CarJPA(SQLClsas sqlclass) {
    	this.SQLsingle=SettSql;
    }
	@Override
	public CarJPA _init(SQLClsas sqlclass) {
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
