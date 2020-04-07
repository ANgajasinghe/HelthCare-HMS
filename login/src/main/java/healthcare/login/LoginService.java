package healthcare.login;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import loginDTO.LoginDTO;

@Path("login")
public class LoginService {
	
	
	@POST
	public void name(LoginDTO loginDTO) {
		
		System.out.println(loginDTO.getUser_id());
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
