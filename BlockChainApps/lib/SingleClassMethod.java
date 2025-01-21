import java.util.HashMap;

public class SingleClassMethod {
	private static SingleClassMethod singleClassMethod;

	public SingleClassMethod() {

	}

	public static getMethodInstance() {
		if (singleClassMethod==null )
		{
			singleClassMethod=new SingleClassMethod();
		}			
			return singleClassMethod;
	}
	
	public String postAccount(String Account,String Password) {  //登入合約帳號
		HashMap<String,String> accountData=HashMap<String,String>();
		accountData.put(Account, Password)
		return null;

	}
	public String registerAccount(String Account,String Password) {  //註冊合約帳號
		
		
	}
	
	
	public Boolean nodeCheck() {  //SERVER節點檢查
	
		return null;
	}
	
	 
}
