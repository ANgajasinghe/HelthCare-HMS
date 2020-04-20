package healthcare.gateway.services;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.PaymentDTO;

@Path("payment")
public class PaymentService extends ConfigService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaymentData(){
		SetAuthorization();
		//System.out.println("Calling ");
		return iAuthorization.getPaymentData();
		
	}
	
	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response SelecthospitalName(@PathParam("id") String id) {
		SetAuthorization();
		System.out.println("calling+"+id);
		return iAuthorization.SelecthospitalName(id);
	}
	
	
	@POST
	@Path("add")
	public Response InsertIntoPayments(PaymentDTO paymentDTO) {
		System.out.println("Calling InsertIntoPayments");
		SetAuthorization();
		
		return iAuthorization.InsertIntoPayments(paymentDTO);
	}
	
	
	@PUT
	@Path("update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdatePayment(@PathParam("id")int id,PaymentDTO paymentDTO) {
		SetAuthorization();
		paymentDTO.setPayment_id(id);
		return iAuthorization.UpdatePayment(paymentDTO);
		
	}
	
	
	@DELETE
	@Path("delete/{id}")
	public Response DeletePayment(@PathParam("id") int id) {
		SetAuthorization();
	    return iAuthorization.DeletePayment(id);
	       
	    
	}

}
