package healthcare.gateway.userprofile;

import java.io.IOException;

import healthcare.gatewayDTO.IpMapperDTO;
import healthcare.gatewayDTO.IpMapperModel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UserHttpCall {
	
	IpMapperDTO iMapperDTO;
	private final OkHttpClient httpClient = new OkHttpClient();

	public UserHttpCall() {
		super();
		IpMapperModel iModel = new IpMapperModel();
		iMapperDTO = iModel.getIpMapperDTO();
	}
	
	public String GetSpecdata() throws Exception {
		Request request = new Request.Builder()
                .url(iMapperDTO.getUserIP()+"/login/webapi/login/get")
                .addHeader("custom-key", "PAF")  // add request headers
                .addHeader("User-Agent", "Nayanajith")
                .build();
		
		try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            String responseData = response.body().string();
            return responseData;
        }
		
		
	}
	
	
	

}
