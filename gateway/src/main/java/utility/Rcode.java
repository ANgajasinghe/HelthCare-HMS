package utility;

import javax.ws.rs.core.Response;

public class Rcode {
	public static int No_Content = 204;
	
	public static Response No_content(String message) {
		return Response.status(Response.Status.NOT_FOUND).entity(GMessage.nodata+message).build();
	}
	
	public static Response Invalide(String message) {
		return Response.status(Response.Status.NOT_FOUND).entity(GMessage.invalid+message).build();
	}
}
