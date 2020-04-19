package helthcare.payment;

import java.util.List;

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

import healthcare.payments.model.PaymentModel;


@Path("payment")
public class PaymentService {
	
	private PaymentModel appm = new PaymentModel();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PaymentDTO> getPaymentData(){
		System.out.println("Calling ");
		return appm.getPaymentData();
		
	}
	
	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String SelecthospitalName(@PathParam("id") String id) {
		System.out.println("calling+"+id);
		return appm.SelecthospitalName(id);
	}
	
	
	@POST
	@Path("add")
	public String InsertIntoPayments(PaymentDTO paymentDTO) {
		System.out.println("calling service");
		return appm.InsertIntoPayments(paymentDTO);
	}
	
	
	
	@PUT
	@Path("update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdatePayment(@PathParam("id")int id,PaymentDTO paymentDTO) {
		paymentDTO.setPayment_id(id);
		if(appm.UpdatePayment(paymentDTO)) {
			return Response.ok().build();
		}else {
		return Response.notModified().entity("payment was updated!!").build();
		}
	}
	
	
	
	@DELETE
	@Path("delete/{id}")
	public Response DeletePayment(@PathParam("id") int id) {
	    if (appm.DeletePayment(id)) {
	        return Response.ok().entity("Payment was deleted!!").build();
	    } else {
	        return Response.notModified().build();
	    }
	}
	
	

}


//IT18073256
//Dilshan K.K.D.N..