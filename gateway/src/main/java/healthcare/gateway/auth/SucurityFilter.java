package healthcare.gateway.auth;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

@Provider
public class SucurityFilter implements ContainerRequestFilter {

	private static final String AUTHIRIZATION_HEADER = "Authorization";
	private static final String AUTHIRIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECUIRED_URL_PREFIX = "secured";
	
	public static String abc = null;
	@Context
    private UriInfo info;
	
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		UriInfo info = requestContext.getUriInfo();
		abc = "akalanka";
		System.out.println(info.getAbsolutePath());
		System.out.println("Request Filters");
		System.out.println("Headers " + requestContext.getHeaders());
		
//		Response unauthResponse  = Response.status(Response.Status.UNAUTHORIZED)
//				.entity("User Cannot Access the resource")
//				.build();
//		requestContext.abortWith(unauthResponse);//not go through this filter 
		
		

	}

}
