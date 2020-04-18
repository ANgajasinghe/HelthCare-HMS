package healthcare.gateway.userprofile;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import utility.IpMapperDTO;
import utility.IpMapperModel;

public class UserHttpCall {
	
	IpMapperDTO iMapperDTO;
	private final OkHttpClient httpClient = new OkHttpClient();
	public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

	public UserHttpCall() {
		super();
		IpMapperModel iModel = new IpMapperModel();
		iMapperDTO = iModel.getIpMapperDTO();
	}
	
//	public String GetSpecdata(String username, String password) throws Exception {
//		Request request = new Request.Builder()
//                .url(iMapperDTO.getUserIP()+"/"+username+"/"+password)
//                .addHeader("custom-key", "PAF")  // add request headers
//                .addHeader("User-Agent", "Nayanajith")
//                .build();
//		
//		try (Response response = httpClient.newCall(request).execute()) {
//
//            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//            String responseData = response.body().string();
//            return responseData;
//        }
//		
//		
//	}
//	
//	public String abcString(String x) {
//		
//		@SuppressWarnings("deprecation")
//		RequestBody body = RequestBody.create(JSON, x);
//		Request request = new Request.Builder()
//                .url(iMapperDTO.getUserIP()+"/login/webapi/login/abc")
//                .addHeader("custom-key", "PAF")  // add request headers
//                .addHeader("User-Agent", "Nayanajith")
//                .post(body)
//                .build();
//		try (Response response = httpClient.newCall(request).execute()) {
//			return response.body().string();
//            //if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//
//        } catch (IOException e) {
//			e.printStackTrace();
//		}
//		return x;
//	}

//	public String GetSpecdata(String username, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	

}
