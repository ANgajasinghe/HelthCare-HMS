package healthcare.gateway;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpCall {
	
	// one instance, reuse
    private final OkHttpClient httpClient = new OkHttpClient();
	

	public String GetData() throws Exception {
		Request request = new Request.Builder()
                .url("http://192.168.1.100:8080/doctors/webapi/myresource")
                .addHeader("custom-key", "mkyong")  // add request headers
                .addHeader("User-Agent", "OkHttp Bot")
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
