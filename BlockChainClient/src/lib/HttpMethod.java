package lib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ObjectClass.RouterObject;
import lombok.var;

public class HttpMethod {

	private static HttpMethod httpMethod;
	private RouterObject routerObjetc;
    private String router_Url="localhost:8080";
    
	public HttpMethod() {
		routerObjetc=routerObjetc.getInstance();
	}
	public static enum BlockRouter{  //router address
    	BLOCKNEW,BLOCKALL,CONTRACTADDRESS,TRANSLOG,NODEBALANCE,NODEWALLET;

    }
    
	public static HttpMethod getMethodInstance() {
		if (httpMethod == null) {
			httpMethod = new HttpMethod();
		}
		return httpMethod;
	}
    public String routerSelect(BlockRouter router) { //router select
    	
    	switch(router) {
    	case BLOCKNEW:
    		router_Url=router_Url+routerObjetc.getRouterArray("blockNew")  ;
    		break;
    	case BLOCKALL:
    		router_Url=router_Url+routerObjetc.getRouterArray("blockAll")  ;
    		break;
    	case CONTRACTADDRESS:
    		router_Url=router_Url+routerObjetc.getRouterArray("contractAddress")  ;
    		break;
    	case TRANSLOG:
    		router_Url=router_Url+routerObjetc.getRouterArray("transLog")  ;
    		break;
    	case NODEBALANCE:
    		router_Url=router_Url+routerObjetc.getRouterArray("nodeBalance")  ;
    		break;
    	case NODEWALLET:
    		router_Url=router_Url+routerObjetc.getRouterArray("nodeWallet")  ;
    		break;
    	default:
    		router_Url="";
    	}
		return router_Url;
        
    }
	public void asnyGet(String Url) { // 無參數
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.submit(() -> {
			try {
				// 發送 HTTP GET 請求
				URL url = new URL(Url);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);

				// 獲取響應碼
				int responseCode = connection.getResponseCode();
				System.out.println("Response Code: " + responseCode);

				if (responseCode == HttpURLConnection.HTTP_OK) {

					// 讀取響應內容
					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					String inputLine;
					StringBuilder response = new StringBuilder();
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					// 顯示響應內容
					System.out.println("Response Body: " + response.toString());
				} else {

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		// 關閉執行緒池
		executorService.shutdown();
	}

	public void asnyMethod(String Url, String content, String Method) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(() -> {
			try {
				URL url = new URL(Url);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod(Method);
				connection.setConnectTimeout(5);
				connection.setReadTimeout(5);
				connection.setDoOutput(true);

				String requestBody = "";
				connection.setRequestProperty("Content-Type", "application/json");
				connection.getOutputStream().write(requestBody.getBytes("UTF-8"));

				int responseCode = connection.getResponseCode();

				if (responseCode == HttpURLConnection.HTTP_OK) { // 200 code
					StringBuilder response = new StringBuilder();
					try (var reader = new java.io.BufferedReader(
							new java.io.InputStreamReader(connection.getInputStream()))) {
						String inputLine;
						while ((inputLine = reader.readLine()) != null) {
							response.append(inputLine);
						}
					}

				} else {

				}

			} catch (Exception e) {

			}

		});
		executorService.shutdown();

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
