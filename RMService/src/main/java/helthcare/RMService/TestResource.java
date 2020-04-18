package helthcare.RMService;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tests")
public class TestResource {
	
	TestRepository repo = new TestRepository();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Test> getTest() {
		
		
		System.out.println("getTest called..");
		
		return repo.getTests();
		
	}
	@GET
	@Path("/test/{test_id}")
	@Produces(MediaType.APPLICATION_XML)
	public Test getTestDetails(@PathParam("test_id") int test_id) {
		return repo.getTest(test_id);
		
	}
	
	@POST
	@Path("testpost")
	@Consumes(MediaType.APPLICATION_XML)
	public Test InsertTests(Test t1) {
		System.out.println(t1);
		repo.insertTest(t1);
		return t1;
	}
	@PUT
	@Path("testupdate")
	@Consumes(MediaType.APPLICATION_XML)
	public Test UpdateTests(Test t1) {
		System.out.println(t1);
		if(repo.getTest(t1.getTest_id()).getTest_id()==0) {
			repo.insertTest(t1);
		}else {
		repo.updateTest(t1);
		}
		return t1;
	}
	
	@DELETE
	@Path("/delete/{test_id}")
	public Test deleteTest(@PathParam("test_id") int test_id) {
		Test t = repo.getTest(test_id);
		if(t.getTest_id()!=0) {
		repo.deleteTest(test_id);
		}
		return t;
	}
	
}
