package healthcare.login;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dto.LoginDTO;
import model.LoginModel;


@Path("login")
public class LoginService {
	
	LoginModel lg = new LoginModel();
	
	@GET
	@Path("{user}/{pwd}")
	public String getToken(@PathParam("user") String username, 
			@PathParam("pwd") String password) {
		 return lg.checkUser(username,password);	 
	}
	
	@GET
	@Path("check")
	public String getLoginUser(@QueryParam("token") String encriptString) {
		//System.out.println(lg.CheckLogin(encriptString));
		return lg.CheckLogin(encriptString);
	}
	
	@DELETE
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteToken(@QueryParam("token") String encriptString) {
		System.out.println("delete token "+encriptString);
		return lg.deleteToken(encriptString);
	}
	
	
	@POST
	@Path("abc")
	public void ABC(String X) {
		Gson gson = new Gson();
	
		LoginDTO clzDto = gson.fromJson(X,LoginDTO.class);
		System.out.println(clzDto.getUser_id());
	
		
		
		
		
		
	}
	
	
	@GET
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LoginDTO> getData() {
		LoginDTO lgDto = new LoginDTO();
		lgDto.setUser_id(1001);
		lgDto.setUser_id(555);
		lgDto.setToken("fghj");
		
		List<LoginDTO> fgDtos = new ArrayList<>();
		fgDtos.add(lgDto);
		return fgDtos;
	}
}
