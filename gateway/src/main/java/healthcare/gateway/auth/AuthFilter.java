package healthcare.gateway.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import utility.GMessage;
import utility.IpMapperDTO;
import utility.IpMapperModel;

@Provider
public class AuthFilter implements ContainerRequestFilter {

	

	private static final String REALM = "example";
	private static final String AUTHENTICATION_SCHEME  = "Bearer ";
	
	private List<String> urlSkipper = new ArrayList<String>();
	AuthClient client = new AuthClient();
	public static String CurrentAuth = "admin";
	public static String CurrentAuthUserId = "0";
	public static String CuttentAuthUserHospitalId = "0";
	
	
	

	@Context
    private UriInfo info;
	
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		//update tablename set LASTTOUCH=CURRENT_TIMESTAMP;
		UriInfo info = requestContext.getUriInfo();
		//System.out.println(info.getAbsolutePath());
		//System.out.println("Request Filters");
		//System.out.println("Headers " + requestContext.getHeaders());
		
		String reqPath = info.getAbsolutePath().toString().trim();
		
		this.Init();
	
		if (UrlSkipper(reqPath)) {
			return;
		}
		
		if (true) {
			return;
		}
//		String authorizationHeader =
//                requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
//
//		
//		if (authorizationHeader == null) {
//			abortWithUnauthorized(requestContext,GMessage.addToken);
//		}
//		else {
//			String token = authorizationHeader
//	                .substring(AUTHENTICATION_SCHEME.length()).trim();
//			
//			System.out.println(token);
//			this.authChecker(token,requestContext);
//		}
		
			
	}
	
	private void authChecker (String tokenString,ContainerRequestContext requestContext) {
		
		String mode = client.AuthChecker(tokenString);
		mode = mode.trim();
		System.out.println(mode);
		System.out.println("calling");
		
		String[] arr = mode.split(",");
		
		if (!arr[0].equals("false")) {
			CurrentAuth = arr[0];
			CurrentAuthUserId =arr[1]; 
			//CuttentAuthUserHospitalId = this.getHospitalID(arr[1]);
			System.out.println("calling");
			return;
		}
		else {
			abortWithUnauthorized(requestContext,GMessage.Unauthorize);
		}
	}
	
	private void abortWithUnauthorized(ContainerRequestContext requestContext,String message) {

        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .header(HttpHeaders.WWW_AUTHENTICATE, 
                                AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"")
                        .entity(message)
                        .build());
    }
	
	private void Init() {
		IpMapperModel iModel = new IpMapperModel();
		IpMapperDTO iMapperDTO = iModel.getIpMapperDTO();
		urlSkipper.add(iMapperDTO.getGatewayIP()+GMessage.path("login"));
		urlSkipper.add(iMapperDTO.getGatewayIP()+GMessage.path("doc")+GMessage.path("session"));
		
	}
	
	private boolean UrlSkipper(String url) {
		for (String string : urlSkipper) {
			System.out.println(url);
			System.out.println(string);
			if (string.equals(url)) {
				System.out.println("This URL need to skip");
				return true;
			}
		}
		return false;
	}
	
	private String getHospitalID(String UserID) {
		 String result[] = client.GetHospitalId(UserID).split(",");
		 return result[0];	
	}
	
	
	
	

}
