package healthcare.gateway;
import java.io.IOException;

import healthcare.gatewayDTO.IpMapperDTO;
import healthcare.gatewayDTO.IpMapperModel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpCall {
	
	IpMapperDTO iMapperDTO;

	public HttpCall() {
		IpMapperModel iModel = new IpMapperModel();
		iMapperDTO = iModel.getIpMapperDTO();
		
	}

	

	// one instance, reuse
    private final OkHttpClient httpClient = new OkHttpClient();
	

	public String GetSpecdata() throws Exception {
		Request request = new Request.Builder()
                .url(iMapperDTO.getDocIP())
                .addHeader("custom-key", "PAF")  // add request headers
                .addHeader("User-Agent", "Nayanajith")
                .build();
		
		try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            //JSONObject 
            
            // Get response body
            //JsonReader rdJsonReader = Json.
            //JSONArray abcArray  = new JsonArray(response.body().toString());
            //System.out.println(response.body().string());
            String responseData = response.body().string();
            return responseData;
            // jsonParser = new JsonParser();
            //JsonArray arrayFromString = jsonParser.parse(responseData).getAsJsonArray();
            //return arrayFromString;
			
        }
		
		
	}
	
	

}
