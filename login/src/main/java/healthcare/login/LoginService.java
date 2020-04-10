package healthcare.login;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dto.LoginDTO;
import model.LoginModel;


@Path("login")
public class LoginService {
	
	LoginModel lg = new LoginModel();
	
	@GET
	@Path("{user}/{pwd}")
	public void name(@PathParam("user") String username, 
			@PathParam("pwd") String password) {
		 boolean v = lg.checkUser(username,password);
		 if (v) {
			 System.out.println(username);
		}
		 
	}
	
	@POST
	@Path("abc")
	public void ABC(String X) {
		Gson gson = new Gson();
		//array conversion 
		//LoginDTO[] clzDto = gson.fromJson(X,LoginDTO[].class);
		//System.out.println(clzDto[0].getLogin_id());
		
		
		//ArrayList<LoginDTO> list = new ArrayList(Arrays.asList(clzDto));
		//List<LoginDTO> fDtos = list;
		
		//System.out.println(fDtos.size());
		
		
		//object conversion 
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
