package lib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ObjectClass.RouterObject;
import lombok.var;

public class HttpMethod<T> {

	private static HttpMethod httpMethod;
	private RouterObject routerObjetc;
    public String result="";
	public HttpMethod() {
		routerObjetc=routerObjetc.getInstance();
	}
	public static enum BlockRouter{  //router address
    	BLOCKNEW,BLOCKALL,CONTRACTADDRESS,TRANSLOG,NODEBALANCE,NODEWALLET,APPROVELOG,ADMINUPDATELOG,TRANSACTIONLOG;

    }
	
    
	public static HttpMethod getMethodInstance() {
		if (httpMethod == null) {
			httpMethod = new HttpMethod();
		}
		return httpMethod;
	}
    public String routerSelect(BlockRouter router) { //router select
    	String router_Url;
    	switch(router) {
    	case BLOCKNEW:
    		router_Url=routerObjetc.getRouterUrl("blockNew")  ;
    		break;
    	case BLOCKALL:
    		router_Url=routerObjetc.getRouterUrl("blockAll")  ;
    		break;
    	case CONTRACTADDRESS:
    		router_Url=routerObjetc.getRouterUrl("contractAddress")  ;
    		break;
    	case TRANSLOG:
    		router_Url=routerObjetc.getRouterUrl("transLog")  ;
    		break;
    	case NODEBALANCE:
    		router_Url=routerObjetc.getRouterUrl("nodeBalance")  ;
    		break;
    	case NODEWALLET:
    		router_Url=routerObjetc.getRouterUrl("nodeWallet")  ;
    		break;
     	case APPROVELOG:
    		router_Url=routerObjetc.getRouterUrl("approve_log")  ;
    		break;
     	case ADMINUPDATELOG:
    		router_Url=routerObjetc.getRouterUrl("admin_update_log")  ;
    		break;
      	case TRANSACTIONLOG:
    		router_Url=routerObjetc.getRouterUrl("transaction_log")  ;
    		break;
    	default:
    		router_Url="";
    	}
		return router_Url;
        
    }
	public void asnyGet(String Url) { // 無參數
		result="";
        ExecutorService executorService = Executors.newFixedThreadPool(2); //池決定非同步數量
        System.out.println("Requesting URL: " + Url);

      executorService.submit(() -> {
            try {
                URL url = new URL(Url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                int responseCode = connection.getResponseCode();
                System.out.println("Response Code: " + responseCode);

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    System.out.println(in);

                    while ((inputLine = in.readLine()) != null) {

                        response.append(inputLine).append("\n");;
                        System.out.println(response);

                    }
                    in.close();

                    System.out.println("Response"+response.toString());
                    result=response.toString();;
                } else {
                	result= "HttpFail"; 
                }
            } catch (Exception e) {
                e.printStackTrace();
                result= "FunctionFail"; 
            }
			return null;
        });

//        try {
//        
//            String result = futureResponse.get(); // get() 會等待非同步
//            return result;
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//            return "FunctionFail"; 
//        } finally {
//            executorService.shutdown();
//        }
	}

	public void asnyMethod(String Url, String content, String Method) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            try {
                URL url = new URL(Url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod(Method);
                connection.setConnectTimeout(5000);  
                connection.setReadTimeout(5000);    
                connection.setDoOutput(true);      

              
                if (content != null && !content.isEmpty()) {
                    connection.getOutputStream().write(content.getBytes("UTF-8"));
                }

            
                connection.setRequestProperty("Content-Type", "application/json");

            
                int responseCode = connection.getResponseCode();

          
                if (responseCode == HttpURLConnection.HTTP_OK) { // 200 OK
                    StringBuilder response = new StringBuilder();
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                        String inputLine;
                        while ((inputLine = reader.readLine()) != null) {
                            response.append(inputLine);
                        }
                    }
                    System.out.println("Response Body: " + response.toString());
                if(Url.contains("View_Array_Block")) {
                	
                	
                }else if(Url.contains("")) {
                	
                	
                }

                    result=response.toString();;
                } else {
                	result= "HttpFail"; 
                }
            } catch (Exception e) {
                e.printStackTrace();
                result= "FunctionFail"; 
            }
        });

//        try {
//            return futureResponse.get(); 
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//            return "FunctionFail"; 
//        } finally {
//            executorService.shutdown();
//        }
    }


//	public void asnycGet(String Url,String Content) {
//		
//		
//		
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(() -> {
//            try {
//
//
//      
//                URL url = new URL(Url);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("GET");
//                connection.setConnectTimeout(5000);
//                connection.setReadTimeout(5000);
//
//                // 設置請求標頭
//                connection.setRequestProperty("Content-Type", "application/json");
//
//                // 啟用輸出流，這樣才能發送 RequestBody
//                connection.setDoOutput(true);
//
//                // 發送 JSON 請求體
//                try (OutputStream os = connection.getOutputStream()) {
//                    byte[] input = Content.getBytes("utf-8");
//                    os.write(input, 0, input.length);
//                }
//
//                // 發送 GET 請求並獲得響應碼
//                int responseCode = connection.getResponseCode();
//                System.out.println("Response Code: " + responseCode);
//
//                // 如果請求成功，讀取響應內容
//                if (responseCode == HttpURLConnection.HTTP_OK) { // 200
//                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                    String inputLine;
//                    StringBuilder response = new StringBuilder();
//
//                    while ((inputLine = in.readLine()) != null) {
//                        response.append(inputLine);
//                    }
//                    in.close();
//
//                    // 輸出響應內容
//                    System.out.println("Response Body: " + response.toString());
//                } else {
//                    System.out.println("GET request failed.");
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//
//        // 關閉執行緒池
//        executorService.shutdown();
//    }

}
