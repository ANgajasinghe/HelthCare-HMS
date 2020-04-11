package healthcare.gateway.auth;

import java.io.IOException;


import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthFilter implements ContainerRequestFilter {

	

	private static final String REALM = "example";
	private static final String AUTHENTICATION_SCHEME  = "Bearer ";
	String ggString = "http://192.168.1.100:8080/gateway/webapi/login";
	AuthClient client = new AuthClient();
	public static String CurrentAuth = "defult";
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
		System.out.println(reqPath);
//		if (true) {
//			return;
//		}
		
		if (ggString.equals(reqPath)) {
			return;
		}
		
		String authorizationHeader =
                requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		String token = authorizationHeader
                .substring(AUTHENTICATION_SCHEME.length()).trim();
		
		System.out.println(token);
		this.authChecker(token,requestContext);
		
		
	}
	
	private void authChecker (String tokenString,ContainerRequestContext requestContext) {
		String mode = client.AuthChecker(tokenString);
		
		mode = mode.trim();
		
		if (!mode.equals("false")) {
			CurrentAuth = mode;
			return;
		}
		else {
			abortWithUnauthorized(requestContext);
		}
	}
	
	private void abortWithUnauthorized(ContainerRequestContext requestContext) {

        // Abort the filter chain with a 401 status code response
        // The WWW-Authenticate header is sent along with the response
        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .header(HttpHeaders.WWW_AUTHENTICATE, 
                                AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"")
                        .entity("User Cannot Access the resource")
                        .build());
    }

}
